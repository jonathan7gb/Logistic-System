package org.transportadora.model.enums;

public enum StatusPedido {
    PENDENTE("Pendente"),
    ENTREGUE("Entregue"),
    CANCELADO("Cancelado");

    private final String status;

    StatusPedido(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
