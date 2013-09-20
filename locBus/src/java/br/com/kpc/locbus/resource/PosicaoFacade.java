/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.Dao.DaoGenerico;
import br.com.kpc.locbus.core.IRepositorioPosicao;
import br.com.kpc.locbus.core.Posicao;
import br.com.kpc.locbus.servico.ContextoInicial;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author César
 */
public abstract class PosicaoFacade extends DaoGenerico<Posicao> implements IRepositorioPosicao {

    private IRepositorioPosicao rp;
    private List<Posicao> lst = new ArrayList<Posicao>();
    private Posicao pos = new Posicao();

    public PosicaoFacade() {
        super(Posicao.class);
    }

    @Override
    public Posicao getUltimaPosicao(String imei) {

        try {

            rp = (IRepositorioPosicao) ContextoInicial.getContext().lookup("java:global/locBus/PosicaoDao");
            pos = rp.getUltimaPosicao(imei);

        } catch (NamingException ex) {
            Logger.getLogger(PosicaoResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return pos;
    }

    @Override
    public List<Posicao> getPosicoesPorVeiculo(String id) {

        try {

            lst.clear();
            rp = (IRepositorioPosicao) ContextoInicial.getContext().lookup("java:global/locBus/PosicaoDao");
            lst = rp.getPosicoesPorVeiculo(id);

        } catch (NamingException ex) {
            Logger.getLogger(PosicaoResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return lst;

    }
}
