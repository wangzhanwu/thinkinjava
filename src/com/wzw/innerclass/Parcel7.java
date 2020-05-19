package com.wzw.innerclass;

import com.wzw.interfaces.Contents;

public class Parcel7 {
    public Contents contents() {
        return new Contents() {
            @Override
            public int value() {
                return 0;
            }
        };
    }
}
