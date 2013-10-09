/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.socket;

import br.com.kpc.locbus.util.Log;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author César
 */
public class IniciaThreadSocket implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    public static void init() {

        Log.debug(IniciaThreadSocket.class.getName() + " SocketConexaoGps... OK");

        try {
            Thread th = new Thread(new SocketConexaoGps());
            th.start();
        } catch (ExceptionInInitializerError exi) {
            Log.error(IniciaThreadSocket.class.getName() + "Falha ao Iniciar SocketConexaoGps...");
        }
    }
}
