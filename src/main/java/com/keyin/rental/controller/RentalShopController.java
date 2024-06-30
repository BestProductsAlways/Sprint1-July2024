package com.keyin.rental.controller;

import com.keyin.entity.RentalShop;
import com.keyin.service.RentalShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rentalshops")
public class RentalShopController {

    @Autowired
    private RentalShopService rentalShopService;

    @GetMapping
    public List<RentalShop> getAllRentalShops() {
        return rentalShopService.getAllRentalShops();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalShop> getRentalShopById(@PathVariable Long id) {
        Optional<RentalShop> rentalShop = rentalShopService.getRentalShopById(id);
        if (rentalShop.isPresent()) {
            return ResponseEntity.ok(rentalShop.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public RentalShop createRentalShop(@RequestBody RentalShop rentalShop) {
        return rentalShopService.createRentalShop(rentalShop);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalShop> updateRentalShop(@PathVariable Long id, @RequestBody RentalShop rentalShopDetails) {
        Optional<RentalShop> updatedRentalShop = rentalShopService.updateRentalShop(id, rentalShopDetails);
        if (updatedRentalShop.isPresent()) {
            return ResponseEntity.ok(updatedRentalShop.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRentalShop(@PathVariable Long id) {
        if (rentalShopService.deleteRentalShop(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

