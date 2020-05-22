package com.wzw.collectionmap2;

public interface Human {
    public void run();
    class Test {
        public static void main(String[] args) {
            Human human = new Man();
            Human manDecorator = new ManDecorator(human);
            Human manDecorator2 = new ManDecorator2(manDecorator);
            manDecorator2.run();
        }
    }
}

class Man implements Human {
    @Override
    public void run() {
        System.out.println("人会走");
    }
}

abstract class AbstractDecorator implements Human {
    private Human human;
    public AbstractDecorator(Human human) {
        this.human = human;
    }

    public void run() {
        human.run();
    }
}

class ManDecorator extends AbstractDecorator {
    public ManDecorator(Human human) {
        super(human);
    }

    private void fly() {
        System.out.println("人会飞");
    }

    @Override
    public void run() {
        super.run();
        fly();
    }
}

class ManDecorator2 extends AbstractDecorator {
    public ManDecorator2(Human human) {
        super(human);
    }

    private void space() {
        System.out.println("飞入太空");
    }

    @Override
    public void run() {
        super.run();
        space();
    }
}