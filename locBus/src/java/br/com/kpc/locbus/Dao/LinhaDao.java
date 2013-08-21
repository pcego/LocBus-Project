/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.IRepositorioLinha;
import br.com.kpc.locbus.core.Linha;
import br.com.kpc.locbus.core.Parada;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author César
 */
@Stateless
public class LinhaDao extends DaoGenerico<Linha> implements IRepositorioLinha {

    public LinhaDao() {
        super(Linha.class);
    }

    @Override
    public List<Linha> findAll() {

        Query consulta = getManager().createQuery("select l from Linha l order by l.numeroLinha");
        return consulta.getResultList();

    }

    @Override
    public List<Linha> getByParada(Parada parada) {

        Query consulta = getManager().createQuery("select l from Linha l where l.parada=:parada");
        consulta.setParameter("parada", parada);
        return consulta.getResultList();
    }

    @Override
    public List<Linha> listaLinhasPorEmpresa(Empresa empresa) {

        Query consulta = getManager().createQuery("select l from Linha l JOIN l.veiculo.empresa =:empresa");
        consulta.setParameter("empresa", empresa);
        return consulta.getResultList();
    }
}
