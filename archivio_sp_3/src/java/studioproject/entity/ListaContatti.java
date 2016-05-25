package studioproject.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import studioproject.dao.ContattiDao;



@ManagedBean(name = "listaContatti")
@SessionScoped
public class ListaContatti implements java.io.Serializable {

   @ManagedProperty("#{dettaglioContatto}")
   private DettaglioContatto dettaglioContatto;
    
    
   @ManagedProperty("#{listaContattiFiltrati}")
   private ListaContattiFiltrati contattiFiltrati;
   
   
   CurrentUserBean usercorrente;
   

    public ListaContatti() {
    }

    public DettaglioContatto getDettaglioContatto() {
        return dettaglioContatto;
    }

    public void setDettaglioContatto(DettaglioContatto dettaglioContatto) {
        this.dettaglioContatto = dettaglioContatto;
    }

    public ListaContattiFiltrati getContattiFiltrati() {
        return contattiFiltrati;
    }

    public void setContattiFiltrati(ListaContattiFiltrati contattiFiltrati) {
        this.contattiFiltrati = contattiFiltrati;
    }

   
  

    

    
    public List<Contatti> getallrecords()
{
    ContattiDao cdao=new ContattiDao();
    List<Contatti> cont=cdao.retrieveContatti();
    return cont;
}
    
    
 
    
 public String editSelezionato (int id){
        
       ContattiDao cdao=new ContattiDao();
        
        dettaglioContatto.setContatto(cdao.getContatto(id));
        return "dettaglioContatto";
    }
    
public String deleteSelezionato (int id){
       
       ContattiDao cdao=new ContattiDao();
        cdao.cancellaContatto(id);
        
        return "listaContatti";
    }

    public CurrentUserBean getUsercorrente() {
        return usercorrente;
    }

    public void setUsercorrente(CurrentUserBean usercorrente) {
        this.usercorrente = usercorrente;
    }





public String inserisci (){
        
      FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nuovoContattoBean", null);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contatti", null);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("dettaglioContatto", null);
        return "nuovoContatto";
    }
 
}