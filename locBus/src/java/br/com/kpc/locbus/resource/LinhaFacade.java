/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.Dao.DaoGenerico;
import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.IRepositorioLinha;
import br.com.kpc.locbus.core.Linha;
import br.com.kpc.locbus.core.Parada;
import br.com.kpc.locbus.servico.ContextoInicial;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author César
 */
public abstract class LinhaFacade extends DaoGenerico<Linha> implements IRepositorioLinha {

    private IRepositorioLinha rp;
    private List<Linha> lst = new ArrayList<Linha>();

    public LinhaFacade() {
        super(Linha.class);
    }

    @Override
    public List<Linha> findAll() throws NamingException {

        try {

            lst.clear();
            rp = (IRepositorioLinha) ContextoInicial.getContext().lookup("java:global/locBus/LinhaDao");
            lst = rp.findAll();

        } catch (NamingException ex) {
            Logger.getLogger(LinhaResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return lst;
    }

    @Override
    public List<Linha> getByParada(Parada parada) throws NamingException {

        try {

            lst.clear();
            rp = (IRepositorioLinha) ContextoInicial.getContext().lookup("java:global/locBus/LinhaDao");
            lst = rp.getByParada(parada);

        } catch (NamingException ex) {
            Logger.getLogger(LinhaResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return lst;

    }

    @Override
    public List<Linha> listaLinhasPorEmpresa(Empresa empresa) throws NamingException {

        try {

            lst.clear();
            rp = (IRepositorioLinha) ContextoInicial.getContext().lookup("java:global/locBus/LinhaDao");
            lst = rp.listaLinhasPorEmpresa(empresa);

        } catch (NamingException ex) {
            Logger.getLogger(LinhaResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return lst;
    }
}
