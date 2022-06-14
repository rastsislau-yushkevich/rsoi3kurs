package com.example.laba4rsoi;

import java.util.Objects;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    

    @Override
    public boolean equals(Person p) {
       return p.name.equals(this.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}
