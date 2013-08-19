/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.Linha;
import br.com.kpc.locbus.core.Veiculo;
import java.util.List;
import javax.naming.NamingException;
import javax.ws.rs.Path;

/**
 *
 * @author César
 */
// anotation @Path define o caminho base para o recurso
@Path("/veiculos")
public class VeiculoResource extends VeiculoFacade {

    @Override
    public Long getCodigo(Veiculo obj) {
        return obj.getId();
        
    }

    @Override
    public List<Veiculo> listaTodos() throws NamingException{
        return super.listaTodos(); 
    }

    @Override
    public List<Veiculo> listaPorEmpresa(Empresa empresa) {
        return super.listaPorEmpresa(empresa); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Veiculo listaVeiculoPorImei(String imei) {
        return super.listaVeiculoPorImei(imei); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Veiculo> listaVeiculosPorLinha(Linha linha) {
        return super.listaVeiculosPorLinha(linha); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
