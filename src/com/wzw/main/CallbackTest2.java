package com.wzw.main;

public class CallbackTest2 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(new Wang());
        teacher.askQuestion();
        System.out.println("做点其他事情");
    }
}

interface Callback {
    void tellAnswer(int answer);
}

interface Student {
    void resolveQuestion(Callback callback);
}

class Teacher implements Callback {
    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println("答案是："+answer);
    }
}

class Wang implements Student {

    @Override
    public void resolveQuestion(Callback callback) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.tellAnswer(10);
    }
}


