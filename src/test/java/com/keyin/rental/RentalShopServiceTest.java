package com.keyin.rental;


import com.keyin.entity.RentalShop;
import com.keyin.service.RentalShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RentalShopServiceTest {

    private RentalShopService rentalShopService;

    @BeforeEach
    void setUp() {
        rentalShopService = new RentalShopService();
    }

    @Test
    void testCreateAndRetrieveRentalShop() {
        RentalShop rentalShop = new RentalShop();
        rentalShop.setId(1L);
        rentalShop.setName("Shop1");
        rentalShop.setCityId("C1");

        rentalShopService.createRentalShop(rentalShop);

        Optional<RentalShop> retrievedRentalShop = rentalShopService.getRentalShopById(1L);
        assertTrue(retrievedRentalShop.isPresent());
        assertEquals("Shop1", retrievedRentalShop.get().getName());
    }
}
