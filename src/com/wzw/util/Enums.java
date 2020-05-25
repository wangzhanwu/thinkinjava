package com.wzw.util;

import java.util.Random;

public class Enums {
    private static Random random = new Random(47);

    /**
     * 获取随机的枚举值
     * 使用自限定的泛型类型 强制该方法的参数必须是一个枚举类型
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Enum<T>> T random(Class<T> clazz) {
        return random(clazz.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}
