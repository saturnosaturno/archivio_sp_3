/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studioproject.entity;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import studioproject.dao.ContattiDao;



@ManagedBean
@SessionScoped
public class ListaContattiFiltrati {
   
    
    String filtroAzienda;
    String filtroMansione;
    String filtroProfessione;

    public ListaContattiFiltrati() {
    }

    public String getFiltroAzienda() {
        return filtroAzienda;
    }

    public void setFiltroAzienda(String filtroAzienda) {
        this.filtroAzienda = filtroAzienda;
    }

    public String getFiltroMansione() {
        return filtroMansione;
    }

    public void setFiltroMansione(String filtroMansione) {
        this.filtroMansione = filtroMansione;
    }

    public String getFiltroProfessione() {
        return filtroProfessione;
    }

    public void setFiltroProfessione(String filtroProfessione) {
        this.filtroProfessione = filtroProfessione;
    }
    
    
         public List<Contatti> getallrecordsfiltered() {
        ContattiDao cdao = new ContattiDao();
             System.out.println("sono nel getallrecordfiltered");
        List<Contatti> cont = cdao.retrieveContattiFiltrati2(filtroAzienda, filtroMansione, filtroProfessione);
        return cont;
    }
    
    
    public String tornaIndietro(){
    
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listaContattiFiltrati", null);
       
        return "listaContatti";
    }
    
    
}
