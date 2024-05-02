package com.demo.java.flow.foreach;

import java.util.ArrayList;
import java.util.List;

public class TestCollection {
    private String name;
    private List<TestCollection> subCollections;

    public TestCollection(String name) {
        this.name = name;
        subCollections = new ArrayList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestCollection> getSubCollections() {
        return subCollections;
    }

    public void setSubCollections(List<TestCollection> subCollections) {
        this.subCollections = subCollections;
    }

    @Override
    public String toString() {
        return "TestCollection{" +
                "name='" + name + '\'' +
                '}';
    }
}
