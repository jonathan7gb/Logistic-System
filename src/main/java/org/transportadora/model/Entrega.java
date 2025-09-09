package org.transportadora.model;

import org.transportadora.model.enums.StatusEntrega;

import java.util.Date;

public class Entrega {

    private int id;
    private Pedido pedido;
    private Motorista motorista;
    private Date dataSaida;
    private Date dataEntrega;
    private StatusEntrega status;

    public Entrega(Pedido pedido, Motorista motorista, Date dataSaida, Date dataEntrega, StatusEntrega status) {
        this.pedido = pedido;
        this.motorista = motorista;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.status = status;
    }

    public Entrega(int id, Pedido pedido, Motorista motorista, Date dataSaida, Date dataEntrega, StatusEntrega status) {
        this.id = id;
        this.pedido = pedido;
        this.motorista = motorista;
        this.dataSaida = dataSaida;
        this.dataEntrega = dataEntrega;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Entrega ID: " + id + " | Pedido: [" + pedido + "] | Motorista: [" + motorista + "] | Data Saída: " + dataSaida + " | Data Entrega: " + dataEntrega + " | Status: " + status;
    }
}
