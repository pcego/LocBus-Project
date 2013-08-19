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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author César
 */
public abstract class VeiculoFacade extends DaoGenerico<Veiculo> implements IRepositorioVeiculo{
    
    public VeiculoFacade(){
        super(Veiculo.class);
    }

    @Override
    public List<Veiculo> listaTodos() throws NamingException{
        
        Context ctx = (Context) new InitialContext();
        IRepositorioVeiculo rp;
        List<Veiculo> lst = new ArrayList<Veiculo>();

        try {
            rp = (IRepositorioVeiculo) ctx.lookup("java:global/locBus/VeiculoDao");
            lst = rp.listaTodos();

        } catch (NamingException ex) {
            Logger.getLogger(VeiculoResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return lst;
        
    }

    @Override
    public List<Veiculo> listaPorEmpresa(Empresa empresa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Veiculo listaVeiculoPorImei(String imei) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Veiculo> listaVeiculosPorLinha(Linha linha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
