package com.wzw.classtype;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("hahaha");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);


        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler(Object obj) {
        proxied = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*** proxy: "+proxy.getClass() +
                ", method: "+ method + ", args: "+ args);
        Object obj = method.invoke(proxied, args);
        System.out.println("--------------------------------------------");
        return obj;
    }
}
