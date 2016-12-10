package com.bogdan;

import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by zoomout on 12/7/16.
 */
public interface Predicates {

    Predicate<Set<Integer>> hasOne = x -> x.contains(1);

    Predicate<Set<Integer>> hasThree = x -> x.contains(3);

    Predicate<Set<Integer>> evenOnly = x -> x.stream().allMatch(t -> t % 2 == 0);

    Predicate<Set<Integer>> oddOnly = x -> x.stream().allMatch(y -> y % 2 != 0);
}
