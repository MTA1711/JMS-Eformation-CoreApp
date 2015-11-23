package fr.utbm.eformation.core.repository;

import fr.utbm.eformation.core.entity.Client;
import java.util.List;

/**
 * Interface for the clients DAO. It extends DAOInterface
 * @author java
 */
public interface ClientInterfaceDAO extends DAOInterface<Client>{
    /**
     * Get all the clients in DB
     * @return list of client
     */
    public  List<Client> getListClient();
}
