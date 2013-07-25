/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.IRepositorio;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author César
 */
public abstract class DaoGenerico<T> implements IRepositorio<T> {

    private Class type;
    @PersistenceContext(unitName = "locBusPU")
    protected EntityManager manager;

    protected EntityManager getManager() {
        return manager;
    }

    public DaoGenerico(Class tipo) {
        type = tipo;
    }

    protected abstract Long getCodigo(T obj);

    @Override
    public boolean salvar(Object obj) {
        
        try {
            getManager().persist(obj);
            getManager().flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean apagar(Object obj) {
        
        try {
            getManager().remove(getManager().getReference(type, obj));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean atualizar(Object obj) {
        
        try {
            getManager().refresh(obj);
            getManager().flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
}
