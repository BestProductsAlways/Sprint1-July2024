package com.keyin.rental;


import com.keyin.entity.City;
import com.keyin.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityServiceTest {

    private CityService cityService;

    @BeforeEach
    void setUp() {
        cityService = new CityService();
    }

    @Test
    void testCreateAndRetrieveCity() {
        City city = new City();
        city.setId("C1");
        city.setName("City1");

        cityService.createCity(city);

        Optional<City> retrievedCity = cityService.getCityById("C1");
        assertTrue(retrievedCity.isPresent());
        assertEquals("City1", retrievedCity.get().getName());
    }
}
