package com.keyin.rental.service;

import com.keyin.entity.Customer;
import com.keyin.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Customer createCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public Optional<Customer> updateCustomer(Long id, Customer customerDetails) {
        return getCustomerById(id).map(customer -> {
            customer.setName(customerDetails.getName());
            customer.setCode(customerDetails.getCode());
            customer.setDateOfBirth(customerDetails.getDateOfBirth());
            return customer;
        });
    }

    public boolean deleteCustomer(Long id) {
        return customers.removeIf(c -> c.getId().equals(id));
    }

    public boolean isEligibleForRental(Long customerId, String itemType) {
        Customer customer = getCustomerById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        int age = Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears();

        switch (itemType) {
            case "House":
            case "Airbnb":
                return age >= 21;
            case "Vehicle":
            case "Tool":
                return age >= 19;
            default:
                return false;
        }
    }
}
