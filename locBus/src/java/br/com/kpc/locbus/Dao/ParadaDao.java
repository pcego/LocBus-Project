/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.Endereco;
import br.com.kpc.locbus.core.IRepositorioParada;
import br.com.kpc.locbus.core.Parada;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author César
 */
public class ParadaDao extends DaoGenerico<Parada> implements IRepositorioParada{
    
    public ParadaDao(){
        super(Parada.class);
    }

    @Override
    protected Long getCodigo(Parada obj) {
        return obj.getId();
    }

    @Override
    public List<Parada> listaTodas() {
        Query consulta = getManager().createQuery("select from Parada order by id");
        return consulta.getResultList();
    }

    @Override
    public List<Parada> paradasPorRua(Endereco end) {
        
        Query consulta = getManager().createQuery("");
        return consulta.getResultList();
    }
}
