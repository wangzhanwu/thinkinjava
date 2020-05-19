package com.wzw.innerclass;

import com.wzw.interfaces.Contents;
import com.wzw.interfaces.Destination;

public class TestParcel {
    Parcel4 p = new Parcel4();
    Contents c = p.contents();
    Destination d = p.destination("");
}

class Parcel4{
    protected class PDestination implements Destination {
        private String label;
        private PDestination(String whereTo) {
            label = whereTo;
        }
        public String readLabel() {
            return label;
        }
    }

    private class PContents implements Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    public Destination destination(String dest) {
        return new PDestination(dest);
    }

    public Contents contents() {
        return new PContents();
    }
}
