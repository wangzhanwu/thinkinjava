package com.wzw.collectionmap;

import com.wzw.extend.C;

import java.util.LinkedList;
import java.util.Queue;

public class CommandProducer {
    private Queue<Command> queue = new LinkedList<>();

    public Command add(Command command) {
        queue.add(command);
        return command;
    }
    public Queue<Command> fill() {
        add(new Command("asd"));
        add(new Command("asd1"));
        add(new Command("asd2"));
        add(new Command("asd3"));
        return queue;
    }

}
