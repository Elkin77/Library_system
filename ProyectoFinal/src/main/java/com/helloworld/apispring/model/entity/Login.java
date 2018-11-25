/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helloworld.apispring.model.entity;

/**
 *
 * @author brayan
 */
public class Login {
    
    private boolean esUsuarioCorrecto;
    
    private String errorUsuario;
    
    private String usuario;
    
    private String tipoUsuario;
    

    public Login() {
    }

    public Login(boolean esUsuarioCorrecto, String errorUsuario, String usuario, String tipoUsuario) {
        this.esUsuarioCorrecto = esUsuarioCorrecto;
        this.errorUsuario = errorUsuario;
        this.usuario = usuario;
        this.tipoUsuario = tipoUsuario;
    }

    public boolean esUsuarioCorrecto() {
        return esUsuarioCorrecto;
    }

    public void setEsUsuarioCorrecto(boolean esUsuarioCorrecto) {
        this.esUsuarioCorrecto = esUsuarioCorrecto;
    }

    public String getErrorUsuario() {
        return errorUsuario;
    }

    public void setErrorUsuario(String errorUsuario) {
        this.errorUsuario = errorUsuario;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
    
}
