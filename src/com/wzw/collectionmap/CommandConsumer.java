package com.wzw.collectionmap;

import java.util.Queue;

public class CommandConsumer {
    public static void consume() {
        CommandProducer cpp = new CommandProducer();
        Queue<Command> queue = cpp.fill();
        while(!queue.isEmpty()) {
            Command command = queue.poll();
            command.operation();
        }
        System.out.println(queue.size());
    }

    public static void main(String[] args) {
        consume();
    }
}
