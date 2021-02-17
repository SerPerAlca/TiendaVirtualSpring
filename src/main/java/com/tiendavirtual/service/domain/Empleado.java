package com.tiendavirtual.service.domain;

public class Empleado extends Usuario{

    private String TGSS;

    public Empleado(String TGSS) {
        this.TGSS = TGSS;
    }

    public Empleado() {

    }

    public String getTGSS() {
        return TGSS;
    }

    public void setTGSS(String TGSS) {
        this.TGSS = TGSS;
    }
}
