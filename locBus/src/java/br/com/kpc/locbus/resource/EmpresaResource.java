/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.IRepositorioEmpresa;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author César
 */
@Path("/empresas")
public class EmpresaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{listaTodas}")
    public List<Empresa> listaTodas() throws NamingException {

        Context ctx = (Context) new InitialContext();
        IRepositorioEmpresa rp = (IRepositorioEmpresa) ctx.lookup("java:global/locBus/EmpresaDao");
        List<Empresa> lst = rp.listaTodas();

        return lst;
    }
}
