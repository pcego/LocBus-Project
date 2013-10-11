/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.core.Linha;
import java.util.List;
import javax.naming.NamingException;
import javax.ws.rs.Path;

/**
 *
 * @author César
 */
// anotation @Path define o caminho base para o recurso
@Path("/linhas")
public class LinhaResource extends LinhaFacade {

    @Override
    public List<Linha> getByParada(String descricao) throws NamingException {
        return super.getByParada(descricao);
    }

    @Override
    public List<Linha> listaLinhasPorEmpresa(String nome) throws NamingException {
        return super.listaLinhasPorEmpresa(nome);
        
    }

    
}
