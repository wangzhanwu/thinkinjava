package com.wzw.classtype;

public class SimpleProxyDemo<main> {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);

        SimpleProxy simpleProxy = new SimpleProxy(realObject);
        consumer(simpleProxy);
        SimpleProxy.invokeCount();
    }
}

interface Interface {
    void doSomething();

    void somethingElse(String args);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("somethingElse "+args);
    }
}

class SimpleProxy implements Interface {
    private static int dsCount = 0;
    private static int seCount = 0;
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        dsCount++;
        System.out.println("SimpleProxy doSomthing");
        proxied.doSomething();
    }

    public void somethingElse(String args) {
        seCount++;
        System.out.println("SimpleProxy somethingElse");
        proxied.somethingElse(args);
    }

    public static void invokeCount() {
        System.out.printf("doSomething(): %d, somethingElse(): %d", dsCount, seCount);
    }
}
