/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.core.Parada;
import java.util.List;
import javax.naming.NamingException;
import javax.ws.rs.Path;

/**
 *
 * @author César
 */
// anotation @Path define o caminho base para o recurso
@Path("/paradas")
public class ParadaResource extends ParadaFacade {

    @Override
    public List<Parada> getAll() throws NamingException {
        return super.getAll();
    }

    @Override
    public List<Parada> buscaPorRua(String rua) throws NamingException {
        return super.buscaPorRua(rua);
    }

    @Override
    public List<Parada> buscaPorBairro(String bairro) throws NamingException {
        return super.buscaPorBairro(bairro);
    }
    
    
    
}
