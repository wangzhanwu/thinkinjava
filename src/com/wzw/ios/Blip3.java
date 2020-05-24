package com.wzw.ios;

import java.io.*;

public class Blip3 implements Externalizable {
    private transient int i;
    private String s;
    public Blip3(){
        System.out.println("Blip3 Constructor");
    }

    public Blip3(String x, int a) {
        s = x;
        i = a;
    }

    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects");
        Blip3 b = new Blip3("A String", 47);
        System.out.println(b);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(b);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Blip3 b3 = (Blip3) in.readObject();
        System.out.println(b3);
    }
}
