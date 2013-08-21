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
public interface IRepositorioVeiculo extends IRepositorio<Veiculo> {

    // anotation @GET define o método HTTP ao qual o recurso responde
    @GET
    // anotation @Produces define o tipo de retorno do recurso
    @Produces(MediaType.APPLICATION_JSON)
    // anotation @Path define o caminho para o recurso
    @Path("/findAll")
    List<Veiculo> listaTodos() throws NamingException;

    // anotation @GET define o método HTTP ao qual o recurso responde
    @GET
    // anotation @Produces define o tipo de retorno do recurso
    @Produces(MediaType.APPLICATION_JSON)
    // anotation @Path define o caminho para o recurso   
    @Path("/listaPorEmpresa/{paramEmpresa}")    
    List<Veiculo> listaPorEmpresa(@PathParam("paramEmpresa") Empresa empresa);

    // anotation @GET define o método HTTP ao qual o recurso responde
    @GET
    // anotation @Produces define o tipo de retorno do recurso
    @Produces(MediaType.APPLICATION_JSON)
    // anotation @Path define o caminho para o recurso    
    @Path("/buscaPorImei/{paramImei}")
    Veiculo listaVeiculoPorImei(@PathParam("paramImei") String imei) throws NamingException;
    
    // anotation @GET define o método HTTP ao qual o recurso responde
    @GET
    // anotation @Produces define o tipo de retorno do recurso
    @Produces(MediaType.APPLICATION_JSON)
    // anotation @Path define o caminho para o recurso    
    @Path("/buscaPorLinha/{paramLinha}")
    List<Veiculo> listaVeiculosPorLinha(@PathParam("paramLinha")Linha linha);
}
