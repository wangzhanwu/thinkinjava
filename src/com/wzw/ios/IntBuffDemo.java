package com.wzw.ios;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBuffDemo {
    public static void main(String[] args) {
        ByteBuffer buff = ByteBuffer.allocate(1024);
        IntBuffer ib = buff.asIntBuffer();
        ib.put(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(ib.get(2));

        ib.put(2, 2);
        ib.flip();
        while (ib.hasRemaining()) {
            System.out.println(ib.get());
        }
    }
}
