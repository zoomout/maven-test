package com.bogdan;

import java.util.Optional;

/**
 * Created by zoomout on 12/10/16.
 */
public class BodyWithOptional {

    private String name;

    private Optional<Integer> age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Optional<Integer> age) {
        this.age = age;
    }

    public Optional<Integer> getAge() {
        return age;
    }
}
