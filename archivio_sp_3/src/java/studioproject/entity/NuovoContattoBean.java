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
import javax.faces.bean.ManagedProperty;
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
     
   @ManagedProperty("#{dettaglioContatto}")
   private DettaglioContatto dettaglioContatto;

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
        return "nuovoContatto";
    }
    
    
    
      public List <TypoTitoliDiStudio> getAllTitoli()
      {
            TitoliDao tdao = new TitoliDao();
            List <TypoTitoliDiStudio> titoli = tdao.retrieveTitoliDiStudio();
         
          return titoli;
      }
    
      
      
      public String aggiornaContatto (){
        ContattiDao contdao = new ContattiDao();
        contdao.updateContatto(contatto);
        System.out.println("Ho aggiornato il contatto nuovo");
        dettaglioContatto.setContatto(contatto);
        return "dettaglioContatto";
    }
      
      
          public String tornaIndietro (){
        
        return "dettaglioContatto";
    }

      

    public DettaglioContatto getDettaglioContatto() {
        return dettaglioContatto;
    }

    public void setDettaglioContatto(DettaglioContatto dettaglioContatto) {
        this.dettaglioContatto = dettaglioContatto;
    }
      
      public String deleteRapportoSelezionato (int id){
       
       ContattiDao cdao=new ContattiDao();
        cdao.cancellaRapporto(id);
        contatto=cdao.getContatto(contatto.getId());
        return "dettaglioContatto";
    }  
      
    
}
