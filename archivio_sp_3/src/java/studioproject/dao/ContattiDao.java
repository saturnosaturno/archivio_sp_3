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
import studioproject.entity.Contatti;
import studioproject.entity.RapportiDiLavoro;
import studioproject.entity.TypoTitoliDiStudio;
import studioproject.util.HibernateUtil;

/**
 *
 * @author Ingegnere
 */
public class ContattiDao {

    public ContattiDao() {
    }
    
    
    public Contatti getContatto(int sno)
    {
        //Contatto contatto=new Contatto();
        Contatti contatto1=new Contatti();
       
         Transaction trans=null;
         Session session=HibernateUtil.getSessionFactory().openSession();
        try 
        {
            //sno=1;
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
    
    
    
    
    
    public void updateContatto(Contatti contatto){
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
       
        try
        {
            trans=session.beginTransaction();
           
           //Query query=session.createQuery("UPDATE Contatti SET nome = :nome, cognome = :cognome, comune_di_residenza = :comune_di_residenza, indirizzo = :indirizzo, cap = :cap, provincia = :provincia, telefono = :telefono, cellulare = :cellulare, email = :email, professione = :professione, sede_di_servizio = :sede_di_servizio, materia = :materia, note = :note WHERE id = :id");             
            //cont=query.list();
            
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
            
            List <Object> rdl = new ArrayList();
            rdl=(Object) contatto.getRapportiDiLavoros().toArray();
            
            
            Query query2=session.createQuery("UPDATE RapportiDiLavoro SET nome_azienda = :nome_azienda WHERE contatti_id = :id");
            query2.setString("nome_azienda",);
            query2.setInteger("id", contatto.getId());
            int result2 = query2.executeUpdate();
            System.out.println("Rapporto di lavoro inserito: " + result2);
            trans.commit();
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
     
   
     
     
     public void insertContatto(Contatti contatto){
        Transaction trans=null;
        Session session=HibernateUtil.getSessionFactory().openSession();
        
        try
        {
            trans=session.beginTransaction();
           
            /*Query query=session.createQuery("INSERT INTO Contatti (nome, cognome) VALUES(nome,cognome)");             
           query.setString("nome", contatto.getNome()); 
           query.setString("cognome", contatto.getCognome());*/
          session.save(contatto);
         // int result = query.executeUpdate();
        //  System.out.println("Rows affected: " + result);
          
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
     
     
     
    
}

    
    
