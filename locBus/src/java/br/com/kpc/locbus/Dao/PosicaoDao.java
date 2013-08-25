/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.IRepositorioPosicao;
import br.com.kpc.locbus.core.Posicao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author César
 */
@Stateless
public class PosicaoDao extends DaoGenerico<Posicao> implements IRepositorioPosicao {

    public PosicaoDao() {
        super(Posicao.class);
    }

    @Override
    public Posicao getUltimaPosicao(String imei) {
        Query consulta = getManager().createQuery("select p from Posicao "
                + "p where p.veiculo.imei = :imei AND "
                + "p.id = (select MAX(p.id) from Posicao p where p.veiculo.imei = :imei)");
        consulta.setParameter("imei", imei);
        return (Posicao) consulta.getSingleResult();
    }

    @Override
    public List<Posicao> getPosicoesPorVeiculo(String imei) {

        Query consulta = getManager().createQuery("select p from Posicao p where"
                + " p.veiculo.imei = :imei order by p.id");
        consulta.setParameter("imei", imei);
        return consulta.getResultList();
    }
}
