package fr.utbm.eformation.core.service;

import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.core.repository.ClientInterfaceDAO;
import fr.utbm.eformation.core.repository.DAOInterface;
import fr.utbm.eformation.core.repository.JdbcClientDAO;
import fr.utbm.eformation.core.util.Factory;
import java.util.List;

/**
 * CRUD operations for a client
 * @author java
 */

public class ClientService {
    //private JdbcClientDAO jcd = new JdbcClientDAO();
    private ClientInterfaceDAO jcd = Factory.getClientDAO();

    /**
     * Add a new client
     * @param c
     * @return 
     */
    public int addClient(Client c){
        int k = jcd.insert(c);
        return k;
    }

    /**
     * Update information about a client
     * @param c
     * @return Id of new client
     */
    public int updateClient(Client c){
        int k =jcd.update(c);
        return k;
    }
    /**
     * Delete a client
     * @param c
     * @return 
     */
    public int deleteClient(Client c){
        int k= jcd.delete(c);
        return k;
    }
    /**
     * Get all clients
     * @return List of client
     */  
    public List getListClients(){
        return jcd.getListClient();
    }
    /**
     * Get client by its ID
     * @param id
     * @return Cient
     */
    public Client getClient(int id ){
        return jcd.find(id);
    }
}
