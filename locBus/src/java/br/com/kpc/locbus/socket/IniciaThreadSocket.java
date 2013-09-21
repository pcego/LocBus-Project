/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.socket;

import br.com.kpc.locbus.util.Log;

/**
 *
 * @author César
 */
public class IniciaThreadSocket {

    public static void main(String[] args) {
         
        Log.debug(IniciaThreadSocket.class.getName() + "SocketConexaoGps... OK");
        
        try{        
        Thread th = new Thread(new SocketConexaoGps());        
        th.start();
        }catch(ExceptionInInitializerError exi){
            Log.error(IniciaThreadSocket.class.getName() + "Falha ao Iniciar SocketConexaoGps...");
        }
    }
}
