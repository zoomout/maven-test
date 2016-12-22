package com.bogdan.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

/**
 * Created by zoomout on 12/22/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnotherObject {
    private String name;

    private Integer age;

    private Boolean isOk;

    public AnotherObject() {

    }


    public String getName() {
        return name;
    }

    public AnotherObject setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public AnotherObject setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Boolean getOk() {
        return isOk;
    }

    public AnotherObject setOk(Boolean ok) {
        isOk = ok;
        return this;
    }

    @Override
    public String toString() {
        return "AnotherObject{" + "name='" + name + '\'' + ", age=" + age + ", isOk=" + isOk
          + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AnotherObject that = (AnotherObject) o;
        return Objects.equals(name, that.name) && Objects.equals(age, that.age) && Objects
          .equals(isOk, that.isOk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, isOk);
    }
}
