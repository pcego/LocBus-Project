/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.Endereco;
import br.com.kpc.locbus.core.IRepositorioEndereco;
import javax.ejb.Stateless;

/**
 *
 * @author César
 */
@Stateless
public class EnderecoDao extends DaoGenerico<Endereco> implements IRepositorioEndereco {

    public EnderecoDao() {
        super(Endereco.class);
    }

    @Override
    public Long getCodigo(Endereco obj) {
        return obj.getId();
    }
}
