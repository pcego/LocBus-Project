/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.core;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author César
 */
@Remote
public interface IRepositorioPosicao extends IRepositorio<Posicao> {

    Posicao getUltimaPosicao(Veiculo veiculo);

    List<Posicao> getPosiçoesPorVeiculo(int i, Veiculo veiculo);
}
