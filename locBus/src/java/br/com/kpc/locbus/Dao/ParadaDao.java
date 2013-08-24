/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.Endereco;
import br.com.kpc.locbus.core.IRepositorioParada;
import br.com.kpc.locbus.core.Parada;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author César
 */
@Stateless
public class ParadaDao extends DaoGenerico<Parada> implements IRepositorioParada {

    public ParadaDao() {
        super(Parada.class);
    }

    @Override
    public List<Parada> getAll() {
        Query consulta = getManager().createQuery("select p from Parada p order by p.id");
        return consulta.getResultList();
    }

    @Override
    public List<Parada> buscaPorRua(Endereco end) {

        Query consulta = getManager().createQuery("select p from Parada p where p.endereco = :end");
        consulta.setParameter("end", end);
        return consulta.getResultList();
    }
}
