package com.keyin.rental;

import com.keyin.rental.entity.RentalItem;
import com.keyin.rental.service.CustomerService;
import com.keyin.rental.service.RentalItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RentalItemServiceTest {

    private RentalItemService rentalItemService;
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService();
        rentalItemService = new RentalItemService(customerService);
    }

    @Test
    void testCreateAndRetrieveRentalItem() {
        RentalItem rentalItem = new RentalItem();
        rentalItem.setId("R1");
        rentalItem.setType("Vehicle");
        rentalItem.setRentalShopId(1L);

        customerService.createCustomer(new Customer());
        rentalItemService.createRentalItem(rentalItem, 1L);

        Optional<RentalItem> retrievedRentalItem = rentalItemService.getRentalItemById("R1");
        assertTrue(retrievedRentalItem.isPresent());
        assertEquals("Vehicle", retrievedRentalItem.get().getType());
    }
}
