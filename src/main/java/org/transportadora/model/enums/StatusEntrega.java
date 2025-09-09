package org.transportadora.model.enums;

public enum StatusEntrega {

    EM_ROTA("Em Rota"),
    ENTREGUE("Entregue"),
    ATRASADA("Atrasada");

    private final String status;

    StatusEntrega(String status) {
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
