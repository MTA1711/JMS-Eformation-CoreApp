package fr.utbm.eformation.core.service;

import fr.utbm.eformation.core.entity.Location;
import fr.utbm.eformation.core.repository.JdbcLocationDAO;
import fr.utbm.eformation.core.repository.LocationInterfaceDAO;
import fr.utbm.eformation.core.util.Factory;
import java.util.List;

/**
 * CRUD operations for a Location
 * @author java
 */
public class LocationService {
        
    private LocationInterfaceDAO jcd = Factory.getLocationDAO();
    
    /**
     * add a new location
     * @param l
     * @return id of the new location
     */
    public int addLocation(Location l){
        int k= jcd.insert(l);
        return k;
    }
    
    /**
     * Update information about a location
     * @param l
     * @return number of locations which are updated
     */
    public int updateLocation(Location l){
        int k= jcd.update(l);
        return k;
    }
    
    /**
     * Delete a location in DataBase
     * @param l
     * @return number of location which are deleted
     */
    public int deleteLocation(Location l){
        int k= jcd.delete(l);
        return k;
    }
    
    /**
     * Get a list of all locations available in DB
     * @return List of locations
     */
    public List getListLocations(){
        return jcd.getListLocation();
    }
    
    /**
     * Get information of a location
     * @param id
     * @return Location
     */
    public Location getLocation(int id){
        return jcd.find(id);
    }

}
