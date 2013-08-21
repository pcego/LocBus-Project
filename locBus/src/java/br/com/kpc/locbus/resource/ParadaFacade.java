/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.Dao.DaoGenerico;
import br.com.kpc.locbus.core.Endereco;
import br.com.kpc.locbus.core.IRepositorioParada;
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
public abstract class ParadaFacade extends DaoGenerico<Parada> implements IRepositorioParada {

    public ParadaFacade() {
        super(Parada.class);
    }

    @Override
    public List<Parada> getAll() throws NamingException {

        IRepositorioParada rp;
        List<Parada> lst = new ArrayList<Parada>();

        try {
            rp = (IRepositorioParada) ContextoInicial.getContext().lookup("java:global/locBus/ParadaDao");
            lst = rp.getAll();

        } catch (NamingException ex) {
            Logger.getLogger(ParadaResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return lst;
    }

    @Override
    public List<Parada> buscaPorRua(Endereco end) throws NamingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
