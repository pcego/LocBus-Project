/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.Empresa;
import br.com.kpc.locbus.core.IRepositorioVeiculo;
import br.com.kpc.locbus.core.Linha;
import br.com.kpc.locbus.core.Veiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author César
 */
@Stateless
public class VeiculoDao extends DaoGenerico<Veiculo> implements IRepositorioVeiculo {

    public VeiculoDao() {
        super(Veiculo.class);
    }

    @Override
    public List<Veiculo> listaTodos() {

        Query consulta = getManager().createQuery("select v from Veiculo v order by v.id");
        return consulta.getResultList();
    }

    @Override
    public List<Veiculo> listaPorEmpresa(Empresa empresa) {

        Query consulta = getManager().createQuery("");
        return consulta.getResultList();
    }

    @Override
    public Veiculo listaVeiculoPorImei(String imei) {

        Query consulta = getManager().createQuery("select v from Veiculo v where v.imei = :imei");
        consulta.setParameter("imei", imei);
        return (Veiculo) consulta.getSingleResult();
    }

    @Override
    public List<Veiculo> listaVeiculosPorLinha(Linha linha) {

        Query consulta = getManager().createQuery("");
        return consulta.getResultList();
    }
}
