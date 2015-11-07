package fr.utbm.eformation.core.entity;

/**
 *
 * @author java
 */
public class Location {
    private int locationId;
    private String city;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" + "locationId=" + locationId + ", city=" + city + '}';
    }
    
}
