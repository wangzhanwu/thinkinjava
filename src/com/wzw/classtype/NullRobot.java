package com.wzw.classtype;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

public class NullRobot {
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(),
                new Class[]{Null.class, Robot.class},
                new NullRobotProxyHandler(type));
    }

    public static void main(String[] args) {
        Robot[] robots = {new SnowRemovalRobot("wahaha"), newNullRobot(SnowRemovalRobot.class)};
        for (Robot robot : robots) {
            Robot.Test.test(robot);
        }
    }
}

class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    private NRobot proxied = new NRobot();
    public NullRobotProxyHandler(Class<? extends Robot> type) {
        this.nullName = type.getSimpleName() + " NullRobot";
    }

    private class NRobot implements Null, Robot {
        public String name() {
            return nullName;
        }
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }
}
