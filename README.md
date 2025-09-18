# Desafio Master: Sistema de Logística de Entregas

## Objetivo

Este projeto é uma aplicação **Java via terminal**, utilizando **JDBC** + **Maven**, que simula a gestão de entregas de uma empresa de logística. O sistema foca no cadastro de clientes, motoristas, pedidos e entregas, além de fornecer relatórios analíticos para acompanhamento dos processos logísticos.

---

## Estrutura do Banco de Dados

O sistema utiliza **MySQL**. Abaixo estão os principais comandos SQL para criação das tabelas e exemplos de consultas utilizadas nos relatórios:

### Tabelas

- **Cliente**: Cadastro de clientes.
- **Motorista**: Cadastro de motoristas.
- **Pedido**: Pedidos realizados por clientes.
- **Entrega**: Entregas atribuídas a motoristas.
- **HistoricoEntrega**: Histórico de eventos ligados a uma entrega.

As tabelas possuem chaves primárias e estrangeiras, garantindo integridade referencial e facilitando operações como exclusão em cascata (ex: excluir cliente exclui pedidos relacionados).

### Relacionamentos

- Um cliente pode ter vários pedidos.
- Cada pedido pode ou não estar associado a uma entrega.
- Um motorista pode realizar várias entregas.
- Cada entrega pode ter múltiplos eventos registrados no histórico.

### Exemplos de Consultas Analíticas

- **Pedidos pendentes por estado**:
  ```sql
  SELECT c.estado, COUNT(*) AS total
  FROM Pedido p
  JOIN Cliente c ON p.cliente_id = c.id
  WHERE p.status = 'PENDENTE'
  GROUP BY c.estado;
  ```

- **Entregas atrasadas por cidade**:
  ```sql
  SELECT c.cidade, COUNT(*) AS total
  FROM Entrega e
  JOIN Pedido p ON e.pedido_id = p.id
  JOIN Cliente c ON p.cliente_id = c.id
  WHERE e.status = 'ATRASADA'
  GROUP BY c.cidade;
  ```

- **Listagem completa de entregas**:
  ```sql
  SELECT e.id AS entrega_id, e.data_saida, e.data_entrega, e.status,
         p.id AS pedido_id, p.data_pedido, c.nome AS cliente_nome, m.nome AS motorista_nome
  FROM Entrega e
  JOIN Pedido p ON e.pedido_id = p.id
  JOIN Cliente c ON p.cliente_id = c.id
  JOIN Motorista m ON e.motorista_id = m.id;
  ```

---

## Triggers e Eventos (Automatismos no Banco)

### Triggers

1. **after_insert_entrega**
   - **Quando:** Após inserir uma nova entrega.
   - **O que faz:** Cria automaticamente um registro no `HistoricoEntrega` indicando que a entrega foi criada e qual o status inicial.
   - **Benefício:** Toda criação de entrega já gera um evento de histórico, facilitando a rastreabilidade.

2. **trg_update_entrega_status**
   - **Quando:** Após uma atualização na tabela `Entrega`.
   - **O que faz:** 
     - Se o status da entrega foi alterado para `ENTREGUE`, atualiza também o status do pedido relacionado para `ENTREGUE`.
     - Sempre registra no `HistoricoEntrega` o evento de alteração de status, informando o status anterior e o novo.
   - **Benefício:** Mantém sincronização entre pedidos e entregas e registra todo o histórico de mudanças de status.

3. **before_delete_entrega**
   - **Quando:** Antes de excluir uma entrega.
   - **O que faz:** Cria um registro no `HistoricoEntrega` informando que a entrega foi excluída e qual era o status final.
   - **Benefício:** Mesmo após a exclusão, o histórico dos eventos da entrega é preservado para auditoria.

### Evento Agendado

- **atualizar_entregas_atrasadas**
  - **Quando:** Executa a cada 1 hora.
  - **O que faz:** Atualiza o status de todas entregas que estão `EM_ROTA` e cuja data de entrega já passou, marcando-as como `ATRASADA`.
  - **Benefício:** Automatiza o controle de entregas atrasadas sem necessidade de intervenção manual.

---

## Estrutura Sugerida do Projeto

```
src/
├── main/
│   ├── java/
│   │   ├── controller/
│   │   ├── dao/
│   │   ├── exceptions/
│   │   ├── model/
│   │   └── repository/
│   │   └── service/
│   │   └── view/
│   └── resources/
├── test/
│   └── java/
```

---

## Requisitos Técnicos

- Projeto Maven com driver JDBC (MySQL ou PostgreSQL)
- Uso de PreparedStatement e ResultSet para consultas seguras
- Estrutura em camadas: model, dao, service, view
- Entrada via Scanner
- Manipulação de datas com java.time
- LEFT JOIN, GROUP BY, filtros e condições
- Boas práticas de modelagem relacional

---

## Critérios de Avaliação Sugeridos

| Critério                         | Pontuação |
|----------------------------------|-----------|
| Funcionamento dos relacionamentos| 30        |
| Uso correto de JOINs e GROUP BY  | 20        |
| Relatórios úteis e organizados   | 20        |
| Estrutura de código em camadas   | 20        |
| Criatividade e recursos extras   | 10        |

---

## Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/jonathan7gb/Logistic-System.git
   cd Logistic-System
   ```
2. **Configure o banco de dados** (MySQL).
3. **Atualize o arquivo de configuração de conexão** com os parâmetros do seu banco.
4. **Compile o projeto via Maven:**
   ```bash
   mvn clean install
   ```
5. **Execute o projeto:**
   ```bash
   java -jar target/logistic-system.jar
   ```

---

## Observações

- O código está organizado para facilitar a manutenção, testes e futuras extensões.
- Triggers e eventos automatizam tarefas importantes e garantem rastreabilidade.
- Relatórios e funcionalidades seguem boas práticas e exploram recursos SQL avançados.
- Sinta-se livre para sugerir melhorias ou adicionar novos recursos!

---

**Desafio criado para promover o aprendizado em Java, JDBC e modelagem de sistemas de logística.**
