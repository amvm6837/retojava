package com.bancopichincha.retojava.domain.model;

public class Cliente extends Persona {

    private Long id;
    private Long contrasenia;
    private String estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(Long contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
