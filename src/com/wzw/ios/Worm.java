package com.wzw.ios;

import java.io.*;
import java.util.Random;

public class Worm implements Serializable {
    private Random random = new Random(47);
    private Data[] d = {
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10)),
            new Data(random.nextInt(10))
    };
    private Worm next;
    private char c;

    public Worm(int i, char x) {
        System.out.println("Worm Constructor ： "+ i);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char)(x+1));
        }
    }

    public Worm() {
        System.out.println("default Worm Constructor");
    }

    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data data : d) {
            result.append(data);
        }
        result.append(")");
        if(next!=null) {
            result.append(next);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "D:\\work\\wzw\\workspace\\idea\\thinkinjava\\src\\com\\wzw\\ios\\worm.out";
        Worm w = new Worm(6, 'a');
        System.out.println("w="+w);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath));
        os.writeObject("Worm storage\n");
        os.writeObject(w);
        os.close();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
        String s = (String) is.readObject();
        Worm w1 = (Worm) is.readObject();
        System.out.println(s);
        System.out.println("w1="+w1);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream os2 = new ObjectOutputStream(baos);
        os2.writeObject(w);
        os2.flush();
        ObjectInputStream oi = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        Worm w2 = (Worm) oi.readObject();
        System.out.println("w2="+w2);


    }
}

class Data implements Serializable {
    private int n;
    public Data(int n) {
        this.n = n;
    }

    public String toString() {
        return Integer.toString(n);
    }
}

