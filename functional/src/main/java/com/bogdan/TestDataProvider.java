package com.bogdan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by zoomout on 12/7/16.
 */

class TestDataProvider {

    static Stream<Set<Integer>> getPowerSet(final int size) {
        return setToStream(powerSet(getSet(size))).filter(x -> !x.isEmpty());
    }

    private static Set<Integer> getSet(final int size) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= size; i++) {
            set.add(i);
        }
        return set;
    }

    private static <T> Stream<T> setToStream(Set<T> set) {
        return set.stream();
    }

    private static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }
        List<T> list = new ArrayList<>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<>(list.subList(1, list.size()));
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
