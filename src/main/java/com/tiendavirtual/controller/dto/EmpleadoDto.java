package com.tiendavirtual.controller.dto;

public class EmpleadoDto extends UsuarioDto {

    private String TGSS;

    public EmpleadoDto() {

    }

    public String getTGSS() {
        return TGSS;
    }

    public void setTGSS(String TGSS) {
        this.TGSS = TGSS;
    }

    public EmpleadoDto(String TGSS) {
        this.TGSS = TGSS;
    }
}
