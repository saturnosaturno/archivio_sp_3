/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studioproject.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import studioproject.entity.Contatti;
import studioproject.entity.RapportiDiLavoro;
import studioproject.entity.TypoTitoliDiStudio;
import studioproject.entity.Utenti;
import studioproject.util.HibernateUtil;

/**
 *
 * 
 */
public class ContattiDao {

    public ContattiDao() {
    }
    
    
    public Contatti getContatto(int sno)
    {
        
        Contatti contatto1=new Contatti();
       
         Transaction trans=null;
         Session session=HibernateUtil.getSessionFactory().openSession();
        try 
        {
            
            trans=session.beginTransaction();
            Query query=session.createQuery("from Contatti where id= :id");
            query.setInteger("id", sno);
            contatto1=(Contatti)query.uniqueResult();
           
            
            trans.commit();
        }
        catch(Exception e)
        {
           System.out.println(e.toString()); 
        }
        return contatto1;
    }
    
    
    
    public List<Contatti> retrieveContatti()
    {
       
        List cont=new ArrayList();
        Contatti cont1=new Contatti();
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Contatti");
            cont=query.list();
           // cont.add(cont1.getNome());
         //   cont.add(cont1.getCognome());
         //   cont.add(cont1.getCellulare());
         //   cont.add(cont1.getEmail());
         
            trans.commit();
            
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return cont;
    }
    
    
    
    
    public List<Contatti> retrieveContattiFiltrati(String filtroAzienda,String filtroMansione, String filtroProfessione)
    {
       
        List cont=new ArrayList();
        Contatti cont1=new Contatti();
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            //Query query=session.createQuery("from Contatti WHERE professione = :filtroProfessione");
          // Query query=session.createQuery("from Contatti c LEFT JOIN RapportiDiLavoro r ON c.id=r.contatti_id WHERE professione = :filtroProfessione AND mansione = :filtroMansione AND filtroAzienda = :nomeAzienda");            
            Query query=session.createQuery("from Contatti c INNER JOIN FETCH RapportiDiLavoro r ON c.id=r.contatti_id WHERE filtroAzienda = :nome_azienda");            
            
           
            
            
            
            //query.setString("filtroProfessione", filtroProfessione);
           // query.setString("filtroMansione", filtroMansione);
            query.setString("filtroAzienda", filtroAzienda);
            cont=query.list();
            
         
            trans.commit();
            
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return cont;
    }
    
    
    
    
     public List<Contatti> retrieveContattiFiltrati2(String filtroAzienda,String filtroMansione, String filtroProfessione)
    {
       
        List cont=new ArrayList();
        
        //Contatti cont1=new Contatti();
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            //Query query=session.createQuery("from Contatti WHERE professione = :filtroProfessione");
          // Query query=session.createQuery("from Contatti c LEFT JOIN RapportiDiLavoro r ON c.id=r.contatti_id WHERE professione = :filtroProfessione AND mansione = :filtroMansione AND filtroAzienda = :nomeAzienda");            
          //  Query query=session.createQuery("from Contatti c INNER JOIN FETCH RapportiDiLavoro r ON c.id=r.contatti_id WHERE filtroAzienda = :nome_azienda");            
            
            Contatti contatto = new Contatti();
            contatto.setProfessione(filtroProfessione+"%");
          
            cont = session.createCriteria(Contatti.class).add(Example.create(contatto).enableLike()).list();
            
            System.out.println("Sto nel retrive2");
            
            //query.setString("filtroProfessione", filtroProfessione);
           // query.setString("filtroMansione", filtroMansione);
           // query.setString("filtroAzienda", filtroAzienda);
           // cont=query.list();
            
         
            trans.commit();
            
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return cont;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void updateContatto(Contatti contatto){
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
       
        
        try
        {
            trans=session.beginTransaction();
                       
            Query query=session.createQuery("UPDATE Contatti SET nome = :nome, cognome = :cognome, data_di_nascita = :data_di_nascita, comune_di_residenza = :comune_di_residenza, indirizzo = :indirizzo, cap = :cap, provincia = :provincia, telefono = :telefono, cellulare = :cellulare, email = :email, professione = :professione, sede_di_servizio = :sede_di_servizio, materia = :materia, note = :note, typo_titoli_di_studio_id = :typo_titoli_di_studio_id WHERE id = :id");             
          
            
            query.setString("nome",contatto.getNome());
            query.setString("cognome",contatto.getCognome());
            query.setDate("data_di_nascita",contatto.getDataDiNascita());
            query.setString("comune_di_residenza",contatto.getComuneDiResidenza());
            query.setString("indirizzo",contatto.getIndirizzo());
            query.setString("cap",contatto.getCap());
            query.setString("provincia",contatto.getProvincia());
            query.setString("telefono",contatto.getTelefono());
            query.setString("cellulare",contatto.getCellulare());
            query.setString("email",contatto.getEmail());
            query.setString("professione",contatto.getProfessione());
            query.setString("sede_di_servizio",contatto.getSedeDiServizio());
            query.setString("materia",contatto.getMateria());
            query.setString("note",contatto.getNote());
            query.setInteger("typo_titoli_di_studio_id", contatto.getTypoTitoliDiStudio().getId());
           
          
           query.setInteger("id", contatto.getId());
            
          int result = query.executeUpdate();
          System.out.println("Rows affected: " + result);
         
          
            
            trans.commit();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
     
        try{
           trans=session.beginTransaction(); 
            
            Set rdl=contatto.getRapportiDiLavoros();
            Object[] oggetti = rdl.toArray();
            System.out.println("lunghezza array rapporti: "+ oggetti.length);
            for (int i=0;i<(oggetti.length);i++)
            {
            
            RapportiDiLavoro rapporto = (RapportiDiLavoro)oggetti[i];
            
            
            
            Query query2=session.createQuery("UPDATE RapportiDiLavoro SET nome_azienda = :nome_azienda, mansione = :mansione WHERE id = :id");
            query2.setString("nome_azienda",rapporto.getNomeAzienda());
            query2.setString("mansione",rapporto.getMansione());
            query2.setInteger("id", rapporto.getId());
            int result2 = query2.executeUpdate();
            System.out.println("Rapporto di lavoro inserito: " + result2);
            System.out.println("Rapporto di lavoro inserito: " + rapporto.getId());
            System.out.println("Rapporto di lavoro inserito: " + rapporto.getNomeAzienda());
            System.out.println("Rapporto di lavoro inserito: " + rapporto.getMansione());
            
            }
            trans.commit();
            
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        
        
        
        
        
    }
    
    
    
    
    
    
    public void inserisciRapportoProvvisorio(Contatti contatto){
        
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        
       try{
        trans=session.beginTransaction();
        RapportiDiLavoro rdl = new RapportiDiLavoro();
        rdl.setMansione("---");
        rdl.setNomeAzienda("---");
        //rdl.getContatti().getRapportiDiLavoros().add(rdl);
        rdl.setContatti(contatto);
        contatto.getRapportiDiLavoros().add(rdl);
        session.save(rdl);
       // session.save(contatto);
        System.out.println("Save effettuato");
        session.getTransaction().commit();
        
        
      }
        catch (Exception e){
           System.out.println(e.toString());
       }
        
        
       
       try{
           trans=session.beginTransaction();
            session.save(contatto);
            session.getTransaction().commit();
       }
       catch (Exception e){
        System.out.println(e.toString());
       }
       
       
    }
    
    
    
    
    public void inserisciRapportoNuovoContatto(Contatti contatto){
        
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        
         try{
           trans=session.beginTransaction();
            Utenti ut = new Utenti();
            ut.setId(1);
            contatto.setUtenti(ut);
            session.save(contatto);
            session.getTransaction().commit();
       }
       catch (Exception e){
        System.out.println(e.toString());
       }
        
        
       try{
        trans=session.beginTransaction();
        RapportiDiLavoro rdl = new RapportiDiLavoro();
        rdl.setMansione("---");
        rdl.setNomeAzienda("---");
        //rdl.getContatti().getRapportiDiLavoros().add(rdl);
        rdl.setContatti(contatto);
        contatto.getRapportiDiLavoros().add(rdl);
        session.save(rdl);
       // session.save(contatto);
        System.out.println("Save effettuato");
        session.getTransaction().commit();
        
        
      }
        catch (Exception e){
           System.out.println(e.toString());
       }
        
        
       
      
       
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     public List<RapportiDiLavoro> retrieveRapportiDiLavoro(Contatti contatto)
    {
       
        List rapp=new ArrayList();
        RapportiDiLavoro rapp1=new RapportiDiLavoro();
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from RapportiDiLavoro WHERE contatti_id = :id ");
            query.setInteger("id", contatto.getId());
            rapp=query.list();         
            trans.commit();
            
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return rapp;
    }
    
    
    
     public void cancellaContatto(int id){
         Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
               

        try
        {
            trans=session.beginTransaction();
           
            Query query=session.createQuery("DELETE from Contatti WHERE id = :id");             
          
           query.setInteger("id",id);
            
          int result = query.executeUpdate();
          System.out.println("Rows affected: " + result);
          
            trans.commit();
            
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
         
         
     }
     
   
     
          public void cancellaRapporto(int id){
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
              
        try
        {
            trans=session.beginTransaction();
           
            Query query=session.createQuery("DELETE from RapportiDiLavoro WHERE id = :id");             
          
           query.setInteger("id",id);
            
          int result = query.executeUpdate();
          System.out.println("Rows affected: " + result);
          
            trans.commit();
            
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
         
         
     }
     
     
     
     
     public List<TypoTitoliDiStudio> retrieveTitoliDiStudio(Contatti contatto)
    {
       
        List titoli=new ArrayList();
        TypoTitoliDiStudio rapp1=new TypoTitoliDiStudio();
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from TypoTitoliDiStudio");
           // query.setInteger("id", contatto.getId());
            titoli=query.list();         
            trans.commit();
            
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        return titoli;
    }
     
     
     
     public void insertContatto(Contatti contatto){
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
       
        try
        {
            trans=session.beginTransaction();
          
            Utenti ut = new Utenti();
            ut.setId(1);
            contatto.setUtenti(ut);
            session.save(contatto);
         // int result = query.executeUpdate();
        //  System.out.println("Rows affected: " + result);
            session.getTransaction().commit();
           // trans.commit();
           
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
       
         
        if (!contatto.getRapportiDiLavoros().isEmpty()){
            
            try {
            
                updateContatto(contatto);
            }
            catch (Exception e){
            System.out.println(e.toString());
            }
            
        }
         
     }
 
     
    
}

    
    
