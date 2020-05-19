package com.wzw.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingExceptions {

    private static Logger logger = Logger.getLogger("LoggingExceptions");
    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String[] args) {
        try{
            throw new NullPointerException();
        } catch (NullPointerException e) {
            logException(e);
            System.out.println("Caught "+e);
        }
    }
}

class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingException() {
        StringWriter st = new StringWriter();
        PrintWriter pw = new PrintWriter(st);
        printStackTrace(pw);
        logger.severe(st.toString());

    }
}
