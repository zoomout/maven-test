package generics;

import annotations.MyAnnotation;
import generics.AnotherClass;
import generics.GenericContainer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoomout on 11/2/16.
 */
public class GenericContainerTest {

    @MyAnnotation
    String hi;

    @Test
    public void testGenerics() {
        GenericContainer<AnotherClass> con1 = new GenericContainer<>(5);
        con1.add(new AnotherClass());
        con1.add(new AnotherClass());
        for (int i = 0; i < con1.size(); i++) {
            if (!(con1.get(i) instanceof AnotherClass)) {
                Assert.fail("Not a generics.AnotherClass");
            }
        }
    }

    @Test
    public void testGenericMethod() {
        GenericContainer<AnotherClass> con = new GenericContainer<>(5);

        List<String> list1 = new ArrayList<>();
        list1.add("hello");
        List<String> list2 = new ArrayList<>();

        con.copy(list1, list2);


        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        List<Integer> list4 = new ArrayList<>();

        con.copy(list3, list4);

        Assert.assertEquals(list3.get(0), list4.get(0));

    }
}
