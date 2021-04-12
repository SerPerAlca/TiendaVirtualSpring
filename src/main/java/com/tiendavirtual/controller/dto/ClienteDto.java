package com.tiendavirtual.controller.dto;

import java.time.LocalDateTime;

public class ClienteDto extends UsuarioDto{

    private String preferencias;

    private LocalDateTime ultimaConexion;

    public ClienteDto(){

    }

    public ClienteDto(String preferencias, LocalDateTime ultimaConexion) {
        this.preferencias = preferencias;
        this.ultimaConexion = ultimaConexion;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public LocalDateTime getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(LocalDateTime ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }
}

