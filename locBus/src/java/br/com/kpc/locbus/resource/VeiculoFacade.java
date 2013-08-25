/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.Dao.DaoGenerico;
import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.IRepositorioVeiculo;
import br.com.kpc.locbus.core.Linha;
import br.com.kpc.locbus.core.Veiculo;
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
            Logger.getLogger(VeiculoResource.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VeiculoResource.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VeiculoResource.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VeiculoResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return lst;
    }
}
