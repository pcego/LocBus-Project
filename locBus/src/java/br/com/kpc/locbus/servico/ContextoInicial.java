/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.servico;

import java.util.logging.Level;
import java.util.logging.Logger;
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
            Logger.getLogger(ContextoInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Context getContext() {

        if (ctx == null) {
            new ContextoInicial();
        }
        return ctx;

    }
}
