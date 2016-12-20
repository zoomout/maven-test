package com.bogdan.domain;

/**
 * Created by zoomout on 12/10/16.
 */
public class Body {

    private String name;

    private Integer age;

    public Body(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Body() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Body [name=" + name + ", age= " + age + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Body) && obj.toString().equals(this.toString());
    }
}
