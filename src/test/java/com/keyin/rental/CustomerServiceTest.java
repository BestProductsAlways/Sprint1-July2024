package com.keyin.rental;

import com.keyin.rental.entity.Customer;
import com.keyin.rental.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService();
    }

    @Test
    void testCreateAndRetrieveCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customer.setCode("C1");
        customer.setDateOfBirth(LocalDate.of(1995, 1, 1));

        customerService.createCustomer(customer);

        Optional<Customer> retrievedCustomer = customerService.getCustomerById(1L);
        assertTrue(retrievedCustomer.isPresent());
        assertEquals("John Doe", retrievedCustomer.get().getName());
    }

    @Test
    void testCustomerEligibility() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Jane Doe");
        customer.setCode("C2");
        customer.setDateOfBirth(LocalDate.of(2000, 1, 1));
        customerService.createCustomer(customer);

        assertTrue(customerService.isEligibleForRental(1L, "House"));
        assertTrue(customerService.isEligibleForRental(1L, "Vehicle"));

        Customer underageCustomer = new Customer();
        underageCustomer.setId(2L);
        underageCustomer.setName("Underage");
        underageCustomer.setCode("C3");
        underageCustomer.setDateOfBirth(LocalDate.of(2005, 1, 1));
        customerService.createCustomer(underageCustomer);

        assertFalse(customerService.isEligibleForRental(2L, "House"));
        assertFalse(customerService.isEligibleForRental(2L, "Vehicle"));
    }
}
