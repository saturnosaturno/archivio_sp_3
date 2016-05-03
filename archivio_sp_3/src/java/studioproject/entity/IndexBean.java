/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studioproject.entity;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import studioproject.dao.UtentiDao;

/**
 *
 * @author Ingegnere
 */

@ManagedBean
@RequestScoped
public class IndexBean implements Serializable {
    
    String username;
    String password;

    public IndexBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
     public String doLogin () throws InstantiationException, IllegalAccessException{
        
        if (UtentiDao.checkLogin(username,password)) 
        {
            CurrentUserBean utenteBean= new CurrentUserBean(username,password,true);
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("utenteBean", utenteBean);
            return "listaContatti";
        }
    return "index";
}

}