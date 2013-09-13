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
            Log.info("SocketConexaoGps.class - Ouvindo Porta: " + PORTA);

            while (true) {

                connectionSocket = socket.accept();
                msgRastreador = null;

                Log.info("IP CLIENTE: " + connectionSocket.getInetAddress().getHostAddress());
                System.out.println("ip " + connectionSocket.getInetAddress().getHostAddress());
                
                rastreador = null;
                rastreador = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                msgRastreador = rastreador.readLine();
                                
                System.out.println("mensagem " + msgRastreador);

                decoder = new DecProtocoloTk102b();

                decoder.decodificadorTk102(msgRastreador);

            }

        } catch (IOException ex) {
            Log.erro("Falha ao ouvir porta!!" + ex.getCause());
        } finally {
            try {
                rastreador.close();
                connectionSocket.close();
            } catch (IOException ex) {
                System.out.println("conexão fechada");
            }

        }
    }
}
    
