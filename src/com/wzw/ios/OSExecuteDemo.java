package com.wzw.ios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSExecuteDemo {

    public static void main(String[] args) {
        OSExecute.command("javap OSExecuteDemo");
    }
}

class OSExecuteException extends RuntimeException {
    public OSExecuteException(String why) {
        super(why);
    }
}
class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s=results.readLine())!=null) {
                System.out.println(s);
            }

            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while((s=errors.readLine())!=null) {
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(err) {
            throw new OSExecuteException(command);
        }
    }
}
