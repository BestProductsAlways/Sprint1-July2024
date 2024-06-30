package com.keyin.rental.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RentalItem {

    @Id
    private String id;
    private String type;
    private Long rentalShopId;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getRentalShopId() {
        return rentalShopId;
    }

    public void setRentalShopId(Long rentalShopId) {
        this.rentalShopId = rentalShopId;
    }
}
