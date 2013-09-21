/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.util;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author César
 */
public class Log {

    private static final String LOGGER_NAME = "locbus";
    private static Logger logger = null;

    public static Logger getLogger() {

        if (logger == null) {

            BasicConfigurator.configure();
            logger = Logger.getLogger(LOGGER_NAME);
            logger.setLevel(Level.ALL);
        }
        return logger;
    }

    public static void error(String msg) {
        getLogger().error(msg);
    }

    public static void warning(String msg) {
        getLogger().warn(msg);
    }

    public static void warning(Throwable exception) {
        warning(null, exception);
    }

    public static void warning(String msg, Throwable exception) {
        StringBuilder s = new StringBuilder();
        if (msg != null) {
            s.append(msg);
            s.append(" - ");
        }
        if (exception != null) {
            String exceptionMsg = exception.getMessage();
            if (exceptionMsg != null) {
                s.append(exceptionMsg);
                s.append(" - ");
            }
            s.append(exception.getClass().getName());
            StackTraceElement[] stack = exception.getStackTrace();
            if (stack.length > 0) {
                s.append(" (");
                s.append(stack[0].getFileName());
                s.append(":");
                s.append(stack[0].getLineNumber());
                s.append(")");
            }
        }
        getLogger().warn(s.toString());
    }

    public static void info(String msg) {
        getLogger().info(msg);
    }

    public static void debug(String msg) {
        getLogger().debug(msg);
    }
}
