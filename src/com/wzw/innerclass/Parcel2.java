package com.wzw.innerclass;

import sun.security.krb5.internal.crypto.Des;

public class Parcel2 {
    class Contents {
        private int i = 1;
        int value() {
            return i;
        }
    }

    class Destination{
        private String label;
        Destination(String whereTo) {
            this.label = whereTo;
        }
        public String readLabel() {
            return label;
        }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Ball Lighting");
        Parcel2.Contents c = new Parcel2().new Contents();
        Parcel2.Destination d = new Parcel2().new Destination("Ball Lightning");
        d.readLabel();
    }
}
