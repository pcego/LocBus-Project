/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.protocolo;

import br.com.kpc.locbus.core.IRepositorioPosicao;
import br.com.kpc.locbus.core.IRepositorioVeiculo;
import br.com.kpc.locbus.core.Posicao;
import br.com.kpc.locbus.core.Veiculo;
import br.com.kpc.locbus.servico.ContextoInicial;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author César
 */
public class DecProtocoloTk102b {

    private Veiculo veiculo;
    private Posicao posicao;
    private IRepositorioVeiculo repoVeiculo;
    private IRepositorioPosicao repoPosicao;
    private String imei;
    private Double latitude;
    private Double longitude;

    public void decodificadorTk102(String msg) {

        String[] msgRast = null, msgTratada = null;

        if (msg != null) {
            msgRast = msg.split(";");
        } else {
            System.out.println("falha na mensagem");
        }

        if (msgRast.length > 1) {

            for (int i = 1; i < msgRast.length; i++) {

                msgTratada = msgRast[i].split(",");

                if (msgTratada.length > 11) {

                    try {
                        imei = msgTratada[0].substring(5);

                        if (imei.matches("\\d{15}")) {

                            try {
                                veiculo = new Veiculo();
                                repoVeiculo = (IRepositorioVeiculo) ContextoInicial.getContext().lookup("java:global/locBus/VeiculoDao");
                                veiculo = repoVeiculo.listaVeiculoPorImei(imei);

                                System.out.println("veiculo " + veiculo.getId());

                            } catch (NamingException ex) {
                                Logger.getLogger(DecProtocoloTk102b.class.getName()).log(Level.SEVERE, "Problemas ao buscar veiculo!", ex);
                            }
                        } else {
                            System.out.println("problemas");
                            // definir código de erro
                        }

                        if (msgTratada[7].matches("(\\d{2})(\\d{2}\\.\\d{4})") && msgTratada[9].matches("(\\d{3})(\\d{2}\\.\\d{4})")) {

                            int grau = Integer.valueOf(msgTratada[7].substring(0, 2));
                            Double min = Double.valueOf(msgTratada[7].substring(2)) / 60;
                            latitude = grau + min;

                            if (msgTratada[8].contentEquals("S")) {
                                latitude *= (-1);
                            }

                            System.out.println("latitude " + latitude);

                            int longGrau = Integer.valueOf(msgTratada[9].substring(0, 3));
                            Double longMin = Double.valueOf(msgTratada[9].substring(3)) / 60;
                            longitude = longGrau + longMin;

                            if (msgTratada[10].contentEquals("W")) {
                                longitude *= (-1);
                            }

                            System.out.println("longitude " + longitude);

                        } else {
                            System.out.println("sem sinal gps!");
                        }
                    } catch (NumberFormatException ex) {

                        System.out.println("erro no parse da msgRastreador " + ex.getMessage());
                    }


                }

                posicao = new Posicao(latitude, longitude, veiculo);

                if (geraNovaPosicao(posicao)) {
                    System.out.println("posição gravada com sucesso!!!!");
                } else {
                    System.out.println("falha ao gravar posição");
                }
            }
        }
    }

    private boolean geraNovaPosicao(Posicao posicao) {

        boolean resp;
        try {

            repoPosicao = (IRepositorioPosicao) ContextoInicial.getContext().lookup("java:global/locBus/PosicaoDao");
            resp = repoPosicao.salvar(posicao);

        } catch (NamingException ex) {
            Logger.getLogger(DecProtocoloTk102b.class.getName()).log(Level.SEVERE, "Falha ao gravar posição!", ex);
            return false;
        }
        return resp;
    }
}
