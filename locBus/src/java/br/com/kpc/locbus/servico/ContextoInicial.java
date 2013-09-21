/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.servico;

import br.com.kpc.locbus.util.Log;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author César
 */
public class ContextoInicial {

    private static Context ctx;

    private ContextoInicial() {
        try {
            ctx = (Context) new InitialContext();
        } catch (NamingException ex) {
            Log.debug(ContextoInicial.class.getName() + "Falha ao Instanciar Contexto " + ex.getCause());
        }
    }

    public static Context getContext() {

        if (ctx == null) {
            new ContextoInicial();
        }
        return ctx;

    }
}
