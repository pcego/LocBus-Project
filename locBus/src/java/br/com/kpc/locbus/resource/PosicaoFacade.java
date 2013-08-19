/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.Dao.DaoGenerico;
import br.com.kpc.locbus.core.IRepositorioPosicao;
import br.com.kpc.locbus.core.Posicao;
import br.com.kpc.locbus.core.Veiculo;
import java.util.List;
import javax.ws.rs.PathParam;

/**
 *
 * @author César
 */
public abstract class PosicaoFacade extends DaoGenerico<Posicao> implements IRepositorioPosicao{
    
    public PosicaoFacade(){
        super(Posicao.class);
    }

    @Override
    public Long getCodigo(@PathParam("{getCodigo}")Posicao obj) {
        return obj.getId();
    }

    @Override
    public Posicao getUltimaPosicao(Veiculo veiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Posicao> getPosiçoesPorVeiculo(Veiculo veiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
