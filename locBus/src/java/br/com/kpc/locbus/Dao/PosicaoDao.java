/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.IRepositorioPosicao;
import br.com.kpc.locbus.core.Posicao;
import br.com.kpc.locbus.core.Veiculo;
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
    public Long getCodigo(Posicao obj) {
        return obj.getId();
    }

    @Override
    public Posicao getUltimaPosicao(Veiculo veiculo) {
        Query consulta = getManager().createQuery("select p MAX(p.id) from Posicao p where p.veiculo =:veiculo");
        consulta.setParameter("veiculo", veiculo);
        return (Posicao) consulta.getSingleResult();
    }

    @Override
    public List<Posicao> getPosiçoesPorVeiculo(Veiculo veiculo) {

        Query consulta = getManager().createQuery("select p from Posicao p where p.veiculo =:veiculo ");
        consulta.setParameter("veiculo", veiculo);
        return consulta.getResultList();
    }
}
