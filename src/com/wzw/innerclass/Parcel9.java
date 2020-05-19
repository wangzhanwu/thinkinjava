package com.wzw.innerclass;

import com.wzw.interfaces.Destination;

public class Parcel9 {
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }
}
