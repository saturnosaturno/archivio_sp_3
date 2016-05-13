package studioproject.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import studioproject.dao.ContattiDao;



@ManagedBean
@SessionScoped
public class Contatti implements java.io.Serializable {


     private Integer id;
     private TypoTitoliDiStudio typoTitoliDiStudio;
     private Utenti utenti;
     private String nome;
     private String cognome;
     private Date dataDiNascita;
     private String comuneDiResidenza;
     private String indirizzo;
     private String cap;
     private String provincia;
     private String telefono;
     private String cellulare;
     private String email;
     private String professione;
     private String sedeDiServizio;
     private String materia;
     private String note;
     private Set rapportiDiLavoros = new HashSet(0);

    public Contatti() {
        
        typoTitoliDiStudio = new TypoTitoliDiStudio();
        
        
                
                }

 
    public Contatti(TypoTitoliDiStudio typoTitoliDiStudio, Utenti utenti, String nome, String cognome) {
        this.typoTitoliDiStudio = typoTitoliDiStudio;
        this.utenti = utenti;
        this.nome = nome;
        this.cognome = cognome;
    }
    public Contatti(TypoTitoliDiStudio typoTitoliDiStudio, Utenti utenti, String nome, String cognome, Date dataDiNascita, String comuneDiResidenza, String indirizzo, String cap, String provincia, String telefono, String cellulare, String email, String professione, String sedeDiServizio, String materia, String note, Set rapportiDiLavoros) {
       this.typoTitoliDiStudio = typoTitoliDiStudio;
       this.utenti = utenti;
       this.nome = nome;
       this.cognome = cognome;
       this.dataDiNascita = dataDiNascita;
       this.comuneDiResidenza = comuneDiResidenza;
       this.indirizzo = indirizzo;
       this.cap = cap;
       this.provincia = provincia;
       this.telefono = telefono;
       this.cellulare = cellulare;
       this.email = email;
       this.professione = professione;
       this.sedeDiServizio = sedeDiServizio;
       this.materia = materia;
       this.note = note;
       this.rapportiDiLavoros = rapportiDiLavoros;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public TypoTitoliDiStudio getTypoTitoliDiStudio() {
        return this.typoTitoliDiStudio;
    }
    
    public void setTypoTitoliDiStudio(TypoTitoliDiStudio typoTitoliDiStudio) {
        this.typoTitoliDiStudio = typoTitoliDiStudio;
    }
    public Utenti getUtenti() {
        return this.utenti;
    }
    
    public void setUtenti(Utenti utenti) {
        this.utenti = utenti;
    }
    public String getNome() {
        
        return this.nome;
             }
    
    public void setNome(String nome) {
        this.nome = nome;
        
    }
    public String getCognome() {
        return this.cognome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public Date getDataDiNascita() {
        return this.dataDiNascita;
    }
    
    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
    
    public String getComuneDiResidenza() {
        return this.comuneDiResidenza;
    }
    
    public void setComuneDiResidenza(String comuneDiResidenza) {
        this.comuneDiResidenza = comuneDiResidenza;
    }
    public String getIndirizzo() {
        return this.indirizzo;
    }
    
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public String getCap() {
        return this.cap;
    }
    
    public void setCap(String cap) {
        this.cap = cap;
    }
    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCellulare() {
        return this.cellulare;
    }
    
    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getProfessione() {
        return this.professione;
    }
    
    public void setProfessione(String professione) {
        this.professione = professione;
    }
    public String getSedeDiServizio() {
        return this.sedeDiServizio;
    }
    
    public void setSedeDiServizio(String sedeDiServizio) {
        this.sedeDiServizio = sedeDiServizio;
    }
    public String getMateria() {
        return this.materia;
    }
    
    public void setMateria(String materia) {
        this.materia = materia;
    }
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    public Set getRapportiDiLavoros() {
        return this.rapportiDiLavoros;
    }
    
    public void setRapportiDiLavoros(Set rapportiDiLavoros) {
        this.rapportiDiLavoros = rapportiDiLavoros;
    }
    
   public String inserisciNuovoRapporto(){
          RapportiDiLavoro rapp = new RapportiDiLavoro();
          rapp.setMansione("----");
          rapp.setNomeAzienda("----");
          
          this.rapportiDiLavoros.add(rapp);
          System.out.println("ho aggiunto un nuovo rapporto di lavoro");
          return "listaContatti";
      }  
    
   
  
   
   

}