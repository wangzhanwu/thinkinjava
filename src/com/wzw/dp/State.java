package com.wzw.dp;

import com.wzw.innerclass.Mine;
import com.wzw.ios.Worm;
import com.wzw.strings.ScannerTest;

public abstract class State {
    public abstract void writeProgram(Work work);

    public static void main(String[] args) {
        Work work = new Work();
        work.setHour(12);
        work.writeProgram();
    }
}

class ForenooState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 12) {
            System.out.printf("当前时间%f点，上午工作，精神百倍。", work.getHour());
        } else {
            work.setCurrent(new NoonState());
            work.writeProgram();
        }
    }
}

class NoonState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13) {
            System.out.printf("当前时间%f,饿了，午休。", work.getHour());
        } else {

        }
    }
}

class Work {
    private State current;
    private double hour;
    private boolean finish = false;

    public Work() {
        current = new ForenooState();
    }

    public void writeProgram() {
        current.writeProgram(this);
    }

    public State getCurrent() {
        return current;
    }

    public void setCurrent(State current) {
        this.current = current;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
