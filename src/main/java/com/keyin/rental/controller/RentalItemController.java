package com.keyin.rental.controller;

import com.keyin.entity.RentalItem;
import com.keyin.service.RentalItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rentalitems")
public class RentalItemController {

    @Autowired
    private RentalItemService rentalItemService;

    @GetMapping
    public List<RentalItem> getAllRentalItems() {
        return rentalItemService.getAllRentalItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalItem> getRentalItemById(@PathVariable String id) {
        Optional<RentalItem> rentalItem = rentalItemService.getRentalItemById(id);
        if (rentalItem.isPresent()) {
            return ResponseEntity.ok(rentalItem.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{customerId}")
    public RentalItem createRentalItem(@RequestBody RentalItem rentalItem, @PathVariable Long customerId) {
        return rentalItemService.createRentalItem(rentalItem, customerId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalItem> updateRentalItem(@PathVariable String id, @RequestBody RentalItem rentalItemDetails) {
        Optional<RentalItem> updatedRentalItem = rentalItemService.updateRentalItem(id, rentalItemDetails);
        if (updatedRentalItem.isPresent()) {
            return ResponseEntity.ok(updatedRentalItem.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRentalItem(@PathVariable String id) {
        if (rentalItemService.deleteRentalItem(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

