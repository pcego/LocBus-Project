/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.Dao.DaoGenerico;
import br.com.kpc.locbus.core.IRepositorioVeiculo;
import br.com.kpc.locbus.core.Veiculo;
import br.com.kpc.locbus.servico.ContextoInicial;
import br.com.kpc.locbus.util.Log;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author César
 */
public abstract class VeiculoFacade extends DaoGenerico<Veiculo> implements IRepositorioVeiculo {

    private IRepositorioVeiculo rp;
    private List<Veiculo> lst = new ArrayList<Veiculo>();
    private Veiculo v = new Veiculo();

    public VeiculoFacade() {
        super(Veiculo.class);
    }

    @Override
    public List<Veiculo> listaTodos() throws NamingException {

        try {

            lst.clear();
            rp = (IRepositorioVeiculo) ContextoInicial.getContext().lookup("java:global/locBus/VeiculoDao");
            lst = rp.listaTodos();

        } catch (NamingException ex) {
            Log.debug(VeiculoFacade.class.getName() + " Falha método listaTodos() " + ex.getCause());
            return null;
        }

        return lst;

    }

    @Override
    public List<Veiculo> listaPorEmpresa(String empresa) {

        try {

            lst.clear();
            rp = (IRepositorioVeiculo) ContextoInicial.getContext().lookup("java:global/locBus/VeiculoDao");
            lst = rp.listaPorEmpresa(empresa);

        } catch (NamingException ex) {
            Log.debug(VeiculoFacade.class.getName() + " Falha método listaPorEmpresa() " + ex.getCause());
            return null;
        }

        return lst;
    }

    @Override
    public Veiculo listaVeiculoPorImei(String imei) throws NamingException {

        try {
            rp = (IRepositorioVeiculo) ContextoInicial.getContext().lookup("java:global/locBus/VeiculoDao");
            v = rp.listaVeiculoPorImei(imei);

        } catch (NamingException ex) {
            Log.debug(VeiculoFacade.class.getName() + " Falha método listaVeiculoPorImei() " + ex.getCause());
            return null;
        }
        return v;
    }

    @Override
    public List<Veiculo> listaVeiculosPorLinha(int linha) {

        try {

            lst.clear();
            rp = (IRepositorioVeiculo) ContextoInicial.getContext().lookup("java:global/locBus/VeiculoDao");
            lst = rp.listaVeiculosPorLinha(linha);

        } catch (NamingException ex) {
            Log.debug(VeiculoFacade.class.getName() + " Falha método listaVeiculosPorLinha() " + ex.getCause());
            return null;
        }

        return lst;
    }
}
