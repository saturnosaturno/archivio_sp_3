/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studioproject.entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class CurrentUserBean implements Serializable {
    
    String nome;
    String username;
    boolean loggato=false;
    

    public CurrentUserBean() {
    }

    public CurrentUserBean(String nome, String username, boolean loggato) {
        this.nome = nome;
        this.username = username;
        this.loggato = loggato;
        
    }

    
    public boolean isLoggato() {
        return loggato;
    }

    public void setLoggato(boolean loggato) {
        this.loggato = loggato;
    }
    
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
    
}
