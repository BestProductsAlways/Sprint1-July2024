package com.keyin.rental.controller;

import com.keyin.entity.City;
import com.keyin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable String id) {
        Optional<City> city = cityService.getCityById(id);
        if (city.isPresent()) {
            return ResponseEntity.ok(city.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable String id, @RequestBody City cityDetails) {
        Optional<City> updatedCity = cityService.updateCity(id, cityDetails);
        if (updatedCity.isPresent()) {
            return ResponseEntity.ok(updatedCity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id) {
        if (cityService.deleteCity(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

