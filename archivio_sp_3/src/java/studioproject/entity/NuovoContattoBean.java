/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studioproject.entity;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import studioproject.dao.ContattiDao;

/**
 *
 * @author Ingegnere
 */
@ManagedBean
@SessionScoped
public class NuovoContattoBean implements Serializable {
    
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
     private TypoTitoliDiStudio typoTitoliDiStudio;
     
     private Contatti contatto;

    public NuovoContattoBean() {
    }

    public Contatti getContatto() {
        return contatto;
    }

    public void setContatto(Contatti contatto) {
        this.contatto = contatto;
    }

    public TypoTitoliDiStudio getTypoTitoliDiStudio() {
        return typoTitoliDiStudio;
    }

    public void setTypoTitoliDiStudio(TypoTitoliDiStudio typoTitoliDiStudio) {
        this.typoTitoliDiStudio = typoTitoliDiStudio;
    }

    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getComuneDiResidenza() {
        return comuneDiResidenza;
    }

    public void setComuneDiResidenza(String comuneDiResidenza) {
        this.comuneDiResidenza = comuneDiResidenza;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfessione() {
        return professione;
    }

    public void setProfessione(String professione) {
        this.professione = professione;
    }

    public String getSedeDiServizio() {
        return sedeDiServizio;
    }

    public void setSedeDiServizio(String sedeDiServizio) {
        this.sedeDiServizio = sedeDiServizio;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
     
     
    public void inserisciContatto(){
        ContattiDao cdao = new ContattiDao();
        cdao.insertContatto(contatto);
    }
    
}
