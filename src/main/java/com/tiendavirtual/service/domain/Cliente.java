package com.tiendavirtual.service.domain;

import java.time.LocalDateTime;

public class Cliente extends Usuario{

    private String preferencias;

    private LocalDateTime ultimaConexion;

    public Cliente(){}

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
