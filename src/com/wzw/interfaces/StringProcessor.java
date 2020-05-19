package com.wzw.interfaces;

public abstract class StringProcessor implements Processor, Processor2{
    public String name() {
        return getClass().getSimpleName();
    }
     @Override
     public abstract Object process(Object input);

    public static String s = "didadia kdfjaiodjaidiijdsaio";
    public static void main(String[] args) {
        Apply.process(new UpCase(), s);
        Apply.process(new DownCase(), s);
    }
}

class UpCase extends StringProcessor {
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class DownCase extends StringProcessor {
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}
interface Processor {
    String name();
    Object process(Object input);
}

interface Processor2{
    String name();
}
