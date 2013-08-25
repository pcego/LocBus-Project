/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author César
 */
public class SocketConexaoGps {

    public static void main(String[] args) throws IOException {

        try {

            String msgRastreador = null;
            ServerSocket socket = new ServerSocket(9000);

            // loop infinito para ouvir porta
            while (true) {

                Socket connectionSocket = socket.accept();
                System.out.println("IP CLIENTE: "
                        + connectionSocket.getInetAddress().getHostAddress());

                BufferedReader rastreador = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

                msgRastreador = rastreador.readLine();
                System.out.println(msgRastreador);
                System.out.println("");

                connectionSocket.close();
                rastreador.close();

            }
        } catch (IOException ex) {
            System.out.println("Problemas ao ouvir porta!!" + ex.getMessage());
        }
    }
}
