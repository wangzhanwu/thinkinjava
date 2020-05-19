package com.wzw.extend;

public class ReferenceCounting {
    static Shared shared = new Shared();
    public static void main(String[] args) {

        Composing[] composings = {new Composing(shared), new Composing(shared)};
        for (Composing composing: composings
             ) {
            composing.dispose();
        }
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        if (shared.getRefcount()==0) {
            super.finalize();
            System.out.println("finalize");
        }

    }
}

class Shared {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared() {
        System.out.println("Creating " + this);
    }

    public void addRef() {
        refcount++;
    }

    public String toString() {
        return "Shared "+ id;
    }

    protected void dispose() {
        if(--refcount == 0) {
            System.out.println("Disposing "+ this);
        }
    }

    protected int getRefcount() {
        return refcount;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    public Composing(Shared shared) {
        System.out.println("Creating "+this);
        this.shared = shared;
        shared.addRef();
    }
    public String toString() {
        return "Composing "+id;
    }

    protected void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }
}
