package com.bogdan;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.function.UnaryOperator;

public class TestFunc {
    private static final int NUM = 1;
    private static final String STR = "0+1=";

    public static void main(String[] args) {
        System.out.println("Functional");
        UnaryOperator<Integer> add1 = DoStuffFunc::add1;

        Function<Integer, Integer> mul3 = DoStuffFunc::mul3;
        Function<String, String> concat1 = DoStuffFunc::concat1;

        Function<Integer, Function<Integer, Integer>> makeMultiplier = DoStuffFunc::multiplier;
        Integer multiplicationRes = makeMultiplier.apply(2).apply(3);

        Integer x = 10;
        Integer compositeRes = mul3.apply(add1.apply(x));

        BinaryOperator<Integer> sum = (a, b) -> a + b;
        Integer binarySumRes = sum.apply(2, 6);

        BinaryOperator<Function<Integer, Integer>> compose1 = (f, g) -> y -> g.apply(f.apply(y));

        Function<Integer, Integer> h1 = compose1.apply(add1, mul3);
        Integer compositeFunctionRes1 = h1.apply(10);
        System.out.println(compositeFunctionRes1);

        Function<Integer, Integer> h2 = mul3.compose(add1);
        Integer compositeFunctionRes2 = h2.apply(10);
        System.out.println(compositeFunctionRes2);


        Function<Integer, Function<Integer, Integer>> fullFunction = x1 -> {
            System.out.println("Received argument x1=" + x1);
            return y1 -> {
                System.out.println("Received argument y1=" + y1);
                int result = x1 + y1;
                System.out.println("x1 + y1 = " + result);
                return result;
            };
        };
        Function<Integer, Integer> partiallyAppliedFunction = fullFunction.apply(10);
        partiallyAppliedFunction.apply(5);

        UnaryOperator<Integer> add2 = x3 -> x3 + 2; //argument and return type is the same
        System.out.println(add2.apply(5));

        int fact = 10;
        System.out.println(fact + "! = " + factorial(fact));


        final List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"), new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"), new BigDecimal("45"), new BigDecimal("12"));
        final BigDecimal totalOfDiscountedPrices = prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static double factorial(int n) {

        Recursive<IntToDoubleFunction> recursive = new Recursive<>();
        recursive.func = x -> (x == 0) ? 1 : x * recursive.func.applyAsDouble(x - 1);

        return recursive.func.applyAsDouble(n);
    }

    public static class Recursive<I> {
        public I func;
    }
}
