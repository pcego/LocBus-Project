/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.core;

import java.util.List;
import javax.ejb.Remote;
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
public interface IRepositorioPosicao extends IRepositorio<Posicao> {

    // anotation @GET define o método HTTP ao qual o recurso responde
    @GET
    // anotation @Produces define o tipo de retorno do recurso
    @Produces(MediaType.APPLICATION_JSON)
    // anotation @Path define o caminho para o recurso
    @Path("/getUltimaPosicao")
    Posicao getUltimaPosicao(Veiculo veiculo);

    // anotation @GET define o método HTTP ao qual o recurso responde
    @GET
    // anotation @Produces define o tipo de retorno do recurso
    @Produces(MediaType.APPLICATION_JSON)
    // anotation @Path define o caminho para o recurso
    @Path("/getPosicaoPorVeiculo/{paramPosicao}")
    List<Posicao> getPosiçoesPorVeiculo(@PathParam("/getPosicaoPorVeiculo/{paramPosicao}") Veiculo veiculo);
}
