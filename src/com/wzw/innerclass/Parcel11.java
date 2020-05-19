package com.wzw.innerclass;

import com.wzw.interfaces.Contents;
import com.wzw.interfaces.Destination;
import sun.security.krb5.internal.crypto.Des;

public class Parcel11 {
    private static class ParcelContents implements Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination {
        private String label;
        private ParcelDestination(String whereTo) {
            label = whereTo;
        }

        public String readLabel(){
            return label;
        }

        public static void f(){}
        static int x = 10;
        static class AnotherLevel{
            public static void f(){}
            static int x = 10;
        }
    }

    public static Destination destination(String dest) {
        return new ParcelDestination(dest);
    }

    public static Contents contents(){
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents contents = contents();
        Destination destination = destination("abc");
    }
}
