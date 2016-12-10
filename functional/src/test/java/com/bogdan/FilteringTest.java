package com.bogdan;

import org.junit.Test;

import static com.bogdan.Predicates.*;
import static com.bogdan.TestDataProvider.getPowerSet;

/**
 * Created by zoomout on 12/7/16.
 */
public class FilteringTest {


    @Test
    public void test() {

        final int size = 4;

        System.out.println("\nPower set of 4");
        getPowerSet(size).forEach(System.out::println);

        System.out.println("\nPower set of 4 that has 1 and 3");
        getPowerSet(size).filter(hasOne.and(hasThree)).forEach(System.out::println);

        System.out.println("\nPower set of 4 that has odd only");
        getPowerSet(size).filter(oddOnly).forEach(System.out::println);

        System.out.println("\nPower set of 4 that has even only");
        getPowerSet(size).filter(evenOnly).forEach(System.out::println);
    }
}
