package org.transportadora.model;

public class Motorista extends Pessoa{

    private String cnh;
    private String veiculo;
    private String cidade_base;

    public Motorista(String nome, String cnh, String veiculo, String cidade_base) {
        super(nome);
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidade_base = cidade_base;
    }
    public Motorista(int id, String nome, String cnh, String veiculo, String cidade_base) {
        super(id, nome);
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidade_base = cidade_base;
    }

    public String getCnh() {
        return cnh;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public String getCidade_base() {
        return cidade_base;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public void setCidade_base(String cidade_base) {
        this.cidade_base = cidade_base;
    }

    @Override
    public String toString() {
        return super.toString() + " | CNH: " + cnh + "\n|| Veículo: " + veiculo + " | Cidade Base: " + cidade_base;
    }
}
