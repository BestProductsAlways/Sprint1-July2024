package com.keyin.rental.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {

    @Id
    private String id;
    private String name;

    // Getters and Setters
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
}


