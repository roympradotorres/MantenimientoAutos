package com.rprado.mantenimientoautos.entidades;

public class Automovil {
    private int id;
    private String placa, propietario, marca, fabricacion, reparado;


    public Automovil(String placa, String propietario, String marca, String fabricacion, String reparado) {
        this.placa = placa;
        this.propietario = propietario;
        this.marca = marca;
        this.fabricacion = fabricacion;
        this.reparado = reparado;
    }

    public Automovil(int id, String placa, String propietario, String marca, String fabricacion, String reparado) {
        this.id = id;
        this.placa = placa;
        this.propietario = propietario;
        this.marca = marca;
        this.fabricacion = fabricacion;
        this.reparado = reparado;
    }

    public int getId() { return id;}


    public void setId(int id){
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(String fabricacion) {
        this.fabricacion = fabricacion;
    }

    public String getReparado() {
        return reparado;
    }

    public void setReparado(String reparado) {
        this.reparado = reparado;
    }
}
