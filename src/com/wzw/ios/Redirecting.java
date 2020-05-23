package com.wzw.ios;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\Redirecting.java";
        String filePath2 = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\RedirectingOut.txt";
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(filePath).getAbsoluteFile()));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(filePath2)));

        System.setIn(in);
        System.setOut(out);
        System.setErr(out);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s=br.readLine()) != null) {
            System.out.println(s);
        }
        out.close();
        System.setOut(console);
        System.setErr(console);
    }
}
