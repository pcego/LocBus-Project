/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

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
    public List<Veiculo> listaTodos() throws NamingException {
        return super.listaTodos();
    }

    @Override
    public List<Veiculo> listaPorEmpresa(String empresa) {
        return super.listaPorEmpresa(empresa);
    }

    @Override
    public Veiculo listaVeiculoPorImei(String imei) throws NamingException {
        return super.listaVeiculoPorImei(imei);
    }

    @Override
    public List<Veiculo> listaVeiculosPorLinha(int linha) {
        return super.listaVeiculosPorLinha(linha);
    }
}
