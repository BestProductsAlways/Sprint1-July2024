package com.keyin.rental.service;

import com.keyin.entity.RentalShop;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentalShopService {

    private final List<RentalShop> rentalShops = new ArrayList<>();

    public List<RentalShop> getAllRentalShops() {
        return rentalShops;
    }

    public Optional<RentalShop> getRentalShopById(Long id) {
        return rentalShops.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public RentalShop createRentalShop(RentalShop rentalShop) {
        rentalShops.add(rentalShop);
        return rentalShop;
    }

    public Optional<RentalShop> updateRentalShop(Long id, RentalShop rentalShopDetails) {
        return getRentalShopById(id).map(rentalShop -> {
            rentalShop.setName(rentalShopDetails.getName());
            rentalShop.setCityId(rentalShopDetails.getCityId());
            return rentalShop;
        });
    }

    public boolean deleteRentalShop(Long id) {
        return rentalShops.removeIf(r -> r.getId().equals(id));
    }
}
