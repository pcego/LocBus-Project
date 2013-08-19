/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.core;

import java.util.List;
import javax.ejb.Remote;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author César
 */
@Remote
public interface IRepositorioParada extends IRepositorio<Parada> {

    // anotation @GET define o método HTTP ao qual o recurso responde
    @GET
    // anotation @Produces define o tipo de retorno do recurso
    @Produces(MediaType.APPLICATION_JSON)
    // anotation @Path define o caminho para o recurso
    @Path("/findAll")
    List<Parada> getAll() throws NamingException;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getPorRua/{paramEnd}")
    // anotation @PathParam define a variável para receber parametro do método        
    List<Parada> buscaPorRua(@PathParam("/getPorRua/{paramEnd}") Endereco end) throws NamingException;
}
