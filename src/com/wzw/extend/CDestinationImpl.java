package com.wzw.extend;

import com.wzw.innerclass.Test2;
import com.wzw.interfaces.Destination;

public class CDestinationImpl extends Test2 {
    public Destination getD() {
        return new DestinationImpl("Hello");
    }

    public static void main(String[] args) {
        CDestinationImpl c = new CDestinationImpl();
        Destination d = c.getD();
        System.out.println(d.readLabel());
    }
}
