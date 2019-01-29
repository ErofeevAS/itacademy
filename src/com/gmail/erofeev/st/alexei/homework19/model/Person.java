package com.gmail.erofeev.st.alexei.homework19.model;

public class Person {
    private String name;
    private String surName;
    private int year;

    private Person(Builder builder) {
        name = builder.name;
        surName = builder.surName;
        year = builder.year;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getYear() {
        return year;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private String surName;
        private int year;

        private Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder surName(String val) {
            surName = val;
            return this;
        }

        public Builder year(int val) {
            year = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", year=" + year +
                '}';
    }
}
