/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kpc.locbus.util;

import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Appender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 *
 * @author César
 */
public class Log {

    private static final String NOME_LOG = "locbus_log";
    private static Logger logger = null;

    public static void configLog(Properties propriedades) throws IOException {

        Layout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %5p: %m%n");
        Appender appender = new DailyRollingFileAppender(layout, propriedades.getProperty("arquivoLog.file"), "'.'yyyyMMdd");

        LogManager.resetConfiguration();
        logger = Logger.getLogger(NOME_LOG);
        logger.addAppender(appender);
        logger.setLevel(Level.ALL);

    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger(NOME_LOG);
            logger.setLevel(Level.OFF);
        }
        return logger;
    }

    public static void erro(String msg) {
        getLogger().error(msg);
    }

    public static void aviso(String msg) {
        getLogger().warn(msg);
    }

    public static void aviso(Throwable exception) {
        aviso(null, exception);
    }

    public static void aviso(String msg, Throwable exception) {
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
