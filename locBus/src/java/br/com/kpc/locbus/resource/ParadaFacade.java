/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.Dao.DaoGenerico;
import br.com.kpc.locbus.core.IRepositorioParada;
import br.com.kpc.locbus.core.Parada;
import br.com.kpc.locbus.servico.ContextoInicial;
import br.com.kpc.locbus.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author César
 */
public abstract class ParadaFacade extends DaoGenerico<Parada> implements IRepositorioParada {

    private IRepositorioParada rp;
    private List<Parada> lst = new ArrayList<Parada>();

    public ParadaFacade() {
        super(Parada.class);
    }

    @Override
    public List<Parada> getAll() throws NamingException {

        try {

            lst.clear();
            rp = (IRepositorioParada) ContextoInicial.getContext().lookup("java:global/locBus/ParadaDao");
            lst = rp.getAll();

        } catch (NamingException ex) {
            Log.debug(ParadaFacade.class.getName() + " Falha método getAll() " + ex.getCause());
            return null;
        }

        return lst;
    }

    @Override
    public List<Parada> buscaPorRua(String rua) throws NamingException {

        try {

            lst.clear();
            rp = (IRepositorioParada) ContextoInicial.getContext().lookup("java:global/locBus/ParadaDao");
            lst = rp.buscaPorRua(rua);

        } catch (NamingException ex) {
            Log.debug(ParadaFacade.class.getName() + " Falha método buscaPorRua() " + ex.getCause());
            return null;
        }

        return lst;

    }

    @Override
    public List<Parada> buscaPorBairro(String bairro) throws NamingException {

        try {

            lst.clear();
            rp = (IRepositorioParada) ContextoInicial.getContext().lookup("java:global/locBus/ParadaDao");
            lst = rp.buscaPorBairro(bairro);

        } catch (NamingException ex) {
            Log.debug(ParadaFacade.class.getName() + " Falha método buscaPorBairro() " + ex.getCause());
            return null;
        }

        return lst;

    }
}
