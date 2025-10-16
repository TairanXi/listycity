package com.example.listycity;

/**
 * Represents a Canadian city with a name and province.
 * <p>
 * Equality is based on both {@code city} and {@code province},
 * so the same city in a different province is considered different.
 */
public class City implements Comparable<City> {

    /** The city name. */
    private final String city;

    /** The province or territory name. */
    private final String province;

    /**
     * Creates a new {@link City}.
     *
     * @param city     the city name (non-null)
     * @param province the province/territory name (non-null)
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * @return the city name
     */
    public String getCityName() {
        return city;
    }

    /**
     * @return the province/territory name
     */
    public String getProvinceName() {
        return province;
    }

    /**
     * Compares cities by name (lexicographical).
     */
    @Override
    public int compareTo(City o) {
        return this.city.compareTo(o.getCityName());
    }

    /**
     * Two cities are equal when both their names and provinces are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return this.city.equals(other.city) && this.province.equals(other.province);
    }

    /**
     * Hash code consistent with {@link #equals(Object)}.
     */
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + province.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return city + ", " + province;
    }
}
