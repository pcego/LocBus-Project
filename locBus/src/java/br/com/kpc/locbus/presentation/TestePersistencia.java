/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.presentation;

import br.com.kpc.locbus.core.Empresa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author César
 */
public class TestePersistencia {
    
    public static void main(String[] args){
        
        EntityManagerFactory factory = 
                Persistence.createEntityManagerFactory("locBusPU");
        EntityManager manager = factory.createEntityManager();
       
        Empresa e= new Empresa();
        e.setNome("KPC DEV");
                        
        EntityTransaction tran = manager.getTransaction();
        
        tran.begin();
    
    
     try {
        
            manager.persist(e);
        
            tran.commit();
        }catch(Exception ex){
            tran.rollback();
        }
    }
    
}
