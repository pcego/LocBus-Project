/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.socket;

import br.com.kpc.locbus.protocolo.DecProtocoloTk102b;
import br.com.kpc.locbus.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author César
 */
public class SocketConexaoGps implements Runnable {

    private BufferedReader rastreador;
    private String msgRastreador;
    private ServerSocket socket;
    private Socket connectionSocket;
    private DecProtocoloTk102b decoder;
    private static final int PORTA = 9000;

    @Override
    public void run() {

        try {

            socket = new ServerSocket(PORTA);

            // loop infinito para ouvir porta
            Log.debug(SocketConexaoGps.class.getName() + "Ouvindo Porta " + PORTA);
            while (true) {

                connectionSocket = socket.accept();
                msgRastreador = null;

                Log.debug(IniciaThreadSocket.class.getName() + "IP Cliente: "
                        + connectionSocket.getInetAddress().getHostAddress());

                rastreador = null;
                rastreador = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                msgRastreador = rastreador.readLine();

                decoder = new DecProtocoloTk102b();
                decoder.decodificadorTk102(msgRastreador);

            }

        } catch (IOException ex) {

            Log.debug(SocketConexaoGps.class.getName() + "Falha no Socket: " + ex.getCause());
        } finally {
            try {
                rastreador.close();
                connectionSocket.close();
            } catch (IOException ex) {
                Log.debug(SocketConexaoGps.class.getName() + "Erro ao Fechar Conexão..!");
            }

        }
    }
}
