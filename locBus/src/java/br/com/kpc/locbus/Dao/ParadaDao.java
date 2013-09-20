/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.IRepositorioParada;
import br.com.kpc.locbus.core.Parada;
import java.util.List;
import javax.ejb.Stateless;
import javax.naming.NamingException;
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

        Query consulta = getManager().createQuery("select p from Parada p "
                + "where p.status = true order by p.id");
        return consulta.getResultList();
    }

    @Override
    public List<Parada> buscaPorRua(String rua) {

        Query consulta = getManager().createQuery("select p from Parada p "
                + "where p.rua LIKE :rua AND "
                + "p.status = true");
        consulta.setParameter("rua", "%" + rua + "%");
        return consulta.getResultList();
    }

    @Override
    public List<Parada> buscaPorBairro(String bairro) throws NamingException {

        Query consulta = getManager().createQuery("select p from Parada p "
                + "where p.bairro LIKE :bairro AND "
                + "p.status = true");
        consulta.setParameter("bairro", "%" + bairro + "%");
        return consulta.getResultList();
    }
}
