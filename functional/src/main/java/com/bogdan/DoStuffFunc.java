package com.bogdan;

import java.util.function.Function;

public class DoStuffFunc {
    public static Integer add1(Integer x) {
        return x + 1;
    }

    public static Integer mul3(Integer x) {
        return x * 3;
    }

    public static String concat1(String x) {
        return x + 1;
    }

    public static Function<Integer, Integer> multiplier(Integer x) {
        return y -> x * y;
    }

}
