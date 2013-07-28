/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.Dao;

import br.com.kpc.locbus.core.IRepositorioPosicao;
import br.com.kpc.locbus.core.Posicao;
import br.com.kpc.locbus.core.Veiculo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author César
 */
public class PosicaoDao extends DaoGenerico<Posicao> implements IRepositorioPosicao {

    public PosicaoDao() {
        super(Posicao.class);
    }

    @Override
    protected Long getCodigo(Posicao obj) {
        
        return obj.getId();
    }

    @Override
    public Posicao getUltimaPosicao(Veiculo veiculo) {
        Query consulta = getManager().createQuery("");
        return (Posicao) consulta.getSingleResult();
    }

    @Override
    public List<Posicao> getPosiçoesPorVeiculo(int i, Veiculo veiculo) {
        
        Query consulta = getManager().createQuery("");
        return consulta.getResultList();
    }
}
