/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studioproject.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import studioproject.dao.ContattiDao;
import studioproject.dao.TitoliDao;

/**
 *
 * @author Ingegnere
 */
@ManagedBean
@SessionScoped
public class NuovoContattoBean implements Serializable {
    
    
     
     private Contatti contatto;

    public NuovoContattoBean() {
      
        contatto = new Contatti();
     
    }

    public Contatti getContatto() {
        return contatto;
    }

    public void setContatto(Contatti contatto) {
        this.contatto = contatto;
    }

  

    
    
    
   
     
     
    public String inserisciContatto(){
        ContattiDao cdao = new ContattiDao();
        //Utenti u= new Utenti ();
        //u.setId(1);
        //contatto.setUtenti(u);
        System.out.println(contatto.getTypoTitoliDiStudio().getId());
        System.out.println(contatto.getTypoTitoliDiStudio().getTitolo());
        cdao.insertContatto(contatto);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nuovoContattoBean", null);
       
        return "listaContatti";
    }
    
    
    
     public String inserisciRapportoNuovoContatto(){
        
        ContattiDao contdao = new ContattiDao();
        contdao.inserisciRapportoNuovoContatto(contatto);
        System.out.println("Inserito rapporto al nuovo contatto, ora ve ne sono: "+ contatto.getRapportiDiLavoros().size());
        return "nuovoRapporto";
    }
    
    
    
      public List <TypoTitoliDiStudio> getAllTitoli()
      {
            TitoliDao tdao = new TitoliDao();
            List <TypoTitoliDiStudio> titoli = tdao.retrieveTitoliDiStudio();
         
          return titoli;
      }
    
    
}
