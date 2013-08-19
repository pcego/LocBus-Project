/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.core.Empresa;
import java.util.List;
import javax.naming.NamingException;
import javax.ws.rs.Path;

/**
 *
 * @author César
 */
// anotation @Path define o caminho base para o recurso
@Path("/empresas")
public class EmpresaResource extends EmpresaFacade {

    @Override
    public List<Empresa> listaTodas() throws NamingException {
        return super.listaTodos();
    }
}
