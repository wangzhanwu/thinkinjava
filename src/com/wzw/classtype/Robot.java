package com.wzw.classtype;

import java.util.List;

public interface Robot {
    String name();

    String model();

    List<Operation> operations();

    class Test {
        public static void test(Robot robot) {
            if (robot instanceof Null) {
                System.out.println("[Null Robot]");
            }
            System.out.println(robot.name());
            System.out.println(robot.model());
            for (Operation operation : robot.operations()) {
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}
