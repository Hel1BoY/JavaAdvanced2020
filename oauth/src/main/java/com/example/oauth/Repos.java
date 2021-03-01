package com.example.oauth;

public class Repos {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Repos(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Repos{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
