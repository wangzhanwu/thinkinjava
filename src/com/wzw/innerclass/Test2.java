package com.wzw.innerclass;

import com.wzw.interfaces.Destination;

public class Test2 {
    protected class DestinationImpl implements Destination {
        private String label;
        public DestinationImpl(String s) {
            label = s;
        }
        public String readLabel() {
            return label;
        }
    }

    public static void main(String[] args) {
        Test2.DestinationImpl td = new Test2().new DestinationImpl("1321");
        System.out.println(td.label);
    }
}
