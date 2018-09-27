package com.prostoede.model;

/**
 * @author ProstoEde 27.09.2018
 * Класс Model
 */

public class Model {

    private int id;
    private String name;

    public Model(String name) {
        this.name = name;
    }

    public Model(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Model() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
