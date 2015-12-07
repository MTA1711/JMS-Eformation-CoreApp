package fr.utbm.eformation.core.entity;

import java.io.Serializable;

/**
 * location of a course
 * @author java
 */
public class Location implements Serializable{
    private static final long serialVersionUID = 1L;
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
