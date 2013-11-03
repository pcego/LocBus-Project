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
import br.com.kpc.locbus.util.Log;
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
            Log.info(DecProtocoloTk102b.class.getName() + " Falha na Mensagem GPS ");
        }

        if (msgRast.length > 1) {

            for (int i = 1; i < msgRast.length; i++) {

                msgTratada = msgRast[i].split(",");

                if (msgTratada.length > 11) {

                    try {
                        imei = msgTratada[0].substring(5);
                        // Regex para validar IMEI
                        if (imei.matches("\\d{15}")) {

                            try {
                                veiculo = new Veiculo();
                                repoVeiculo = (IRepositorioVeiculo) ContextoInicial.getContext().lookup("java:global/locBus/VeiculoDao");
                                veiculo = repoVeiculo.listaVeiculoPorImei(imei);

                            } catch (NamingException ex) {
                                Log.error(DecProtocoloTk102b.class.getName() + " Erro ao Buscar Veículo " + ex.getCause());
                            }
                        } else {
                            Log.error(DecProtocoloTk102b.class.getName() + " Falha GPS, Mensagem Incompleta ");
                        }
                         // Regex para validar Latitude e Longitude
                        if (msgTratada[7].matches("(\\d{2})(\\d{2}\\.\\d{4})") && msgTratada[9].matches("(\\d{3})(\\d{2}\\.\\d{4})")) {
                            
                            //Recebendo a Latitude em GRAUS
                            int grau = Integer.valueOf(msgTratada[7].substring(0, 2));
                            // Conversão de GRAUS Para MINUTOS
                            Double min = Double.valueOf(msgTratada[7].substring(2)) / 60;
                            latitude = grau + min;
                            // se for S hemisfério Sul, se for N hemisfério Norte 
                            if (msgTratada[8].contentEquals("S")) {
                                latitude *= (-1);
                            }

                            int longGrau = Integer.valueOf(msgTratada[9].substring(0, 3));
                            Double longMin = Double.valueOf(msgTratada[9].substring(3)) / 60;
                            longitude = longGrau + longMin;

                            if (msgTratada[10].contentEquals("W")) {
                                longitude *= (-1);
                            }

                        } else {
                            Log.info(DecProtocoloTk102b.class.getName() + " Sem Sinal GPS... ");
                        }
                    } catch (NumberFormatException ex) {

                        Log.error(DecProtocoloTk102b.class.getName() + " Falha na Parse da Mensagem GPS " + ex.getCause());
                    }


                }

                posicao = new Posicao(latitude, longitude, veiculo);

                if (geraNovaPosicao(posicao)) {
                    Log.info(DecProtocoloTk102b.class.getName() + " Posição Gravada Com Sucesso!!! ");
                } else {
                    Log.info(DecProtocoloTk102b.class.getName() + " Falha ao Gravar Posição!! ");
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
            Log.error(DecProtocoloTk102b.class.getName() + ex.getCause());
            return false;
        }
        return resp;
    }
}
