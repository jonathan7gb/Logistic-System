package org.transportadora.model;

import jdk.jshell.Snippet;
import org.transportadora.model.enums.StatusPedido;

import java.util.Date;

public class Pedido {

    private int id;
    private Cliente cliente;
    private Date dataPedido;
    private double volume_m3;
    private double peso_kg;
    private StatusPedido status;

    public Pedido(Cliente cliente, Date dataPedido, double volume_m3, double peso_kg, StatusPedido status) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.volume_m3 = volume_m3;
        this.peso_kg = peso_kg;
        this.status = status;
    }

    public Pedido(int id, Cliente cliente, Date dataPedido, double volume_m3, double peso_kg, StatusPedido status) {
        this.id = id;
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.volume_m3 = volume_m3;
        this.peso_kg = peso_kg;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public double getVolume_m3() {
        return volume_m3;
    }

    public double getPeso_kg() {
        return peso_kg;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public void setPeso_kg(double peso_kg) {
        this.peso_kg = peso_kg;
    }

    public void setVolume_m3(double volume_m3) {
        this.volume_m3 = volume_m3;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "|| Pedido ID: " + id + " | Cliente: " + cliente.getNome() + " | Data do Pedido: " + dataPedido + "\n|| Volume (m³): " + volume_m3 + " | Peso (kg): " + peso_kg + " | Status: " + status.getDescricao();
    }

}
