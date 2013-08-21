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
import javax.ws.rs.PathParam;

/**
 *
 * @author César
 */
public abstract class LinhaFacade extends DaoGenerico<Linha> implements IRepositorioLinha {

    public LinhaFacade() {
        super(Linha.class);
    }

    @Override
    public List<Linha> findAll() throws NamingException {

        IRepositorioLinha rp;
        List<Linha> lst = new ArrayList<Linha>();

        try {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Linha> listaLinhasPorEmpresa(Empresa empresa) throws NamingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
