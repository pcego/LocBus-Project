/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.resource;

import br.com.kpc.locbus.core.Posicao;
import br.com.kpc.locbus.core.Veiculo;
import java.util.List;
import javax.ws.rs.Path;

/**
 *
 * @author César
 */
@Path("/posicoes")
public class PosicaoResource extends PosicaoFacade {

    @Override
    public Posicao getUltimaPosicao(String imei) {
        return super.getUltimaPosicao(imei);
    }

    @Override
    public List<Posicao> getPosicoesPorVeiculo(String imei) {
        return super.getPosicoesPorVeiculo(imei);
    }
}
