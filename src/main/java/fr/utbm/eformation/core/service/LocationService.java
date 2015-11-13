package fr.utbm.eformation.core.service;

import fr.utbm.eformation.core.entity.Location;
import fr.utbm.eformation.core.repository.JdbcLocationDAO;
import java.util.List;

//CRUD sur la table location
public class LocationService {

	JdbcLocationDAO jcd = new JdbcLocationDAO();
	public int addLocation(Location l){

		int k= jcd.insert(l);
                return k;
	}

	public int updateLocation(Location l){

		int k= jcd.update(l);
                return k;
	}

	public int deleteLocation(Location l){

		int k= jcd.delete(l);
                return k;
	}

	public List getListLocations(){

		return jcd.getListLocation();
	}
        
        public Location getLocation(int id){

		return jcd.find(id);
	}

}
