package com.keyin.rental.service;

import com.keyin.rental.entity.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final List<City> cities = new ArrayList<>();

    public List<City> getAllCities() {
        return cities;
    }

    public Optional<City> getCityById(String id) {
        return cities.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public City createCity(City city) {
        cities.add(city);
        return city;
    }

    public Optional<City> updateCity(String id, City cityDetails) {
        return getCityById(id).map(city -> {
            city.setName(cityDetails.getName());
            return city;
        });
    }

    public boolean deleteCity(String id) {
        return cities.removeIf(c -> c.getId().equals(id));
    }
}
