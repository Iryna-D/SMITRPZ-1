package com;

import java.util.Objects;

public final class Person {

    final private String name;
    final private int info;

    public Person(String name, int info) {
        this.name = name;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", info=" + info +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, info);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Person that = (Person) other;
        return (Objects.equals(this.name, that.name)) && (this.info == that.info);
    }
}