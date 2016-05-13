/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studioproject.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import studioproject.entity.Contatti;
import studioproject.entity.Utenti;
import studioproject.util.HibernateUtil;

/**
 *
 *
 */
public class UtentiDao {

    public UtentiDao() {
    }
    
    public static boolean checkLogin(String username, String password){
        
        Utenti utente1=new Utenti();
       
         Transaction trans=null;
         Session session=HibernateUtil.getSessionFactory().openSession();
        try 
        {
        
            trans=session.beginTransaction();
            Query query=session.createQuery("from Utenti where username= :username AND password = :password");
            
            query.setString("username", username);
            query.setString("password", password);
            utente1=(Utenti)query.uniqueResult();
               
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        
        
        if(utente1.getPassword().isEmpty()){
            return false;
        }
        
        return true;
        
    }
    
    
}
