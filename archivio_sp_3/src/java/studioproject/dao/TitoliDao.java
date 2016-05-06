/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studioproject.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import studioproject.entity.Contatti;
import studioproject.entity.TypoTitoliDiStudio;
import studioproject.util.HibernateUtil;

/**
 *
 * @author Ingegnere
 */
public class TitoliDao {

    public TitoliDao() {
    }
    
    
    
    public List<TypoTitoliDiStudio> retrieveTitoliDiStudio()
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
