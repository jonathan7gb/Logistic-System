package org.transportadora.model;

import org.transportadora.model.enums.Estado;

public class Cliente extends Pessoa{

    private String cpf_cnpj;
    private String endereco;
    private String cidade;
    private Estado estado;

    public Cliente(String nome, String cpf_cnpj, String endereco, String cidade, Estado estado) {
        super(nome);
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Cliente(int id, String nome, String cpf_cnpj, String endereco, String cidade, Estado estado) {
        super(id, nome);
        this.cpf_cnpj = cpf_cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return super.toString() + " | CPF/CNPJ: " + cpf_cnpj + "\n|| Endereço: " + endereco + ", " + cidade + " - " + estado.getSigla();
    }
}
