package com.example.listycity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListyCityTest {

    // ---- helpers ----
    private City edmonton() { return new City("Edmonton", "Alberta"); }
    private City calgary()  { return new City("Calgary",  "Alberta"); }
    private City regina()   { return new City("Regina",   "Saskatchewan"); }
    private City charlottetown() { return new City("Charlottetown", "Prince Edward Island"); }

    private CityList mockCityList() {
        CityList list = new CityList();
        list.add(edmonton());
        return list;
    }

    // ---- tests merged from both files ----
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> cityList.add(city));
    }

    @Test
    void testGetCities_ordering() {
        CityList cityList = mockCityList();
        // Edmonton is the only one, should be first
        assertEquals(0, edmonton().compareTo(cityList.getCities().get(0)));

        // Adding Charlottetown pushes Edmonton down after sort
        City c = charlottetown();
        cityList.add(c);
        assertEquals(0, c.compareTo(cityList.getCities().get(0)));
        assertEquals(0, edmonton().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void hasCity_returnsTrueWhenPresent_andFalseWhenAbsent() {
        CityList list = new CityList();
        list.add(edmonton());

        assertTrue(list.hasCity(edmonton()));
        assertFalse(list.hasCity(calgary()));
    }

    @Test
    void delete_removesExistingCity() {
        CityList list = new CityList();
        list.add(edmonton());
        list.add(calgary());

        list.delete(edmonton());

        assertFalse(list.hasCity(edmonton()));
        assertTrue(list.hasCity(calgary()));
        assertEquals(1, list.countCities());
    }

    @Test
    void delete_throwsWhenCityMissing() {
        CityList list = new CityList();
        list.add(calgary());
        assertThrows(IllegalArgumentException.class, () -> list.delete(regina()));
    }

    @Test
    void countCities_returnsCorrectSize() {
        CityList list = new CityList();
        assertEquals(0, list.countCities());

        list.add(edmonton());
        list.add(calgary());
        assertEquals(2, list.countCities());
    }

    @Test
    void add_throwsOnDuplicate() {
        CityList list = new CityList();
        list.add(edmonton());
        assertThrows(IllegalArgumentException.class, () -> list.add(edmonton()));
    }

    @Test
    void getCities_returnsSortedByName() {
        CityList list = new CityList();
        list.add(edmonton());
        list.add(calgary());

        assertEquals("Calgary",  list.getCities().get(0).getCityName());
        assertEquals("Edmonton", list.getCities().get(1).getCityName());
    }
}
