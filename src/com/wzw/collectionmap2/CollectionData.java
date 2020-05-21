package com.wzw.collectionmap2;

import com.wzw.util.Generator;

import java.util.ArrayList;

/**
 * 用注册器填充List容器
 * @param <T>
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen, quantity);
    }
}
