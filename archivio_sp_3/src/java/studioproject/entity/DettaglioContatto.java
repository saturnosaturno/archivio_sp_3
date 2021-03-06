package studioproject.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import studioproject.dao.ContattiDao;



@ManagedBean
@SessionScoped
public class DettaglioContatto implements Serializable{
    
    private Contatti contatto;

    public DettaglioContatto(Contatti contatto) {
        this.contatto = contatto;
    }
    
    public DettaglioContatto() {
    }

    public Contatti getContatto() {
        return contatto;
    }

    public void setContatto(Contatti contatto) {
        this.contatto = contatto;
    }
    
    public String aggiornaContatto (){
        ContattiDao contdao = new ContattiDao();
        contdao.updateContatto(contatto);
        System.out.println("Ho aggiornato il contatto nuovo");
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listaContattiFiltrati", null);
        return "listaContatti";
    }
    
    
    public String deleteRapportoSelezionato (int id){
       
       ContattiDao cdao=new ContattiDao();
       cdao.updateContatto(contatto);
        cdao.cancellaRapporto(id);
        contatto=cdao.getContatto(contatto.getId());
        return "dettaglioContatto";
    }
    
    
   
    
    public String inserisciRapporto(){
        
        ContattiDao contdao = new ContattiDao();
        contdao.inserisciRapportoProvvisorio(contatto);
        System.out.println("rapporto provvisiorio inserito, ora ve ne sono: "+ contatto.getRapportiDiLavoros().size());
        return "dettagliContatto";
    }
    
    
      public List<RapportiDiLavoro> getallrapporti()
{
    ContattiDao cdao=new ContattiDao();
    List<RapportiDiLavoro> cont=cdao.retrieveRapportiDiLavoro(contatto);
    return cont;
}
      
      
      
      public List <TypoTitoliDiStudio> getAllTitoli()
      {
            ContattiDao cdao=new ContattiDao();
            List <TypoTitoliDiStudio> titoli = cdao.retrieveTitoliDiStudio(contatto);
         
          return titoli;
          
      }
      
      
         public String tornaIndietro (){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("listaContattiFiltrati", null);
        return "listaContatti";
    }
      
     public void filtraRapporti(){
         
     }
         
         
     
 
    
         
    
}