package com.keyin.rental.service;

import com.keyin.entity.RentalItem;
import com.keyin.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentalItemService {

    private final List<RentalItem> rentalItems = new ArrayList<>();

    private final CustomerService customerService;

    public RentalItemService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<RentalItem> getAllRentalItems() {
        return rentalItems;
    }

    public Optional<RentalItem> getRentalItemById(String id) {
        return rentalItems.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public RentalItem createRentalItem(RentalItem rentalItem, Long customerId) {
        if (!customerService.isEligibleForRental(customerId, rentalItem.getType())) {
            throw new IllegalArgumentException("Customer is not eligible to rent this item.");
        }
        rentalItems.add(rentalItem);
        return rentalItem;
    }

    public Optional<RentalItem> updateRentalItem(String id, RentalItem rentalItemDetails) {
        return getRentalItemById(id).map(rentalItem -> {
            rentalItem.setType(rentalItemDetails.getType());
            rentalItem.setRentalShopId(rentalItemDetails.getRentalShopId());
            return rentalItem;
        });
    }

    public boolean deleteRentalItem(String id) {
        return rentalItems.removeIf(r -> r.getId().equals(id));
    }
}
