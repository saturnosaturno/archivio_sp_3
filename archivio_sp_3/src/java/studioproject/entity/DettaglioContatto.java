package studioproject.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import studioproject.dao.ContattiDao;

/**
 *
 * @author dirkgain
 */

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
        
        return "listaContatti";
    }
    
    
     public String aggiornaContatto2 (){
        ContattiDao contdao = new ContattiDao();
        RapportiDiLavoro rapp = new RapportiDiLavoro();
        rapp.setMansione("----");
        rapp.setNomeAzienda("----");
        contatto.getRapportiDiLavoros().add(rapp);
        contdao.updateContatto(contatto);
        return "nuovoRapporto";
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
      
      
     
    
}