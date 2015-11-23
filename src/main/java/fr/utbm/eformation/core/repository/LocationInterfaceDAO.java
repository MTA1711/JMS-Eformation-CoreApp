package fr.utbm.eformation.core.repository;

import fr.utbm.eformation.core.entity.Location;
import java.util.List;

/**
 * Interface for the Locations DAO. It extends DAOInterface
 * @author java
 */
public interface LocationInterfaceDAO extends DAOInterface<Location>{
    /**
     * Get all the location in DB
     * @return list of location
     */
    public  List<Location> getListLocation();
}
