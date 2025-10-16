package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A container that manages a set-like list of {@link City} objects.
 * <p>
 * The list disallows duplicates according to {@link City#equals(Object)}.
 */
public class CityList {

    private final List<City> cities = new ArrayList<>();

    /**
     * Adds a city if it does not already exist.
     *
     * @param city the city to add
     * @throws IllegalArgumentException if the city already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists: " + city);
        }
        cities.add(city);
    }

    /**
     * @param city the candidate
     * @return {@code true} if this list contains {@code city}; {@code false} otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Removes {@code city} if present; otherwise throws.
     *
     * @param city the city to remove
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        boolean removed = cities.remove(city);
        if (!removed) {
            throw new IllegalArgumentException("City not found: " + city);
        }
    }

    /**
     * @return the number of cities in this list
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Returns the cities sorted by name (ascending).
     *
     * @return a sorted view of the internal list
     */
    public List<City> getCities() {
        Collections.sort(cities);
        return cities;
    }
}
