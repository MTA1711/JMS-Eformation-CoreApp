package fr.utbm.eformation.core.service;



import java.sql.Date;

import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.core.entity.Location;
import fr.utbm.eformation.core.repository.JdbcClientDAO;
import fr.utbm.eformation.core.repository.JdbcCourseSionDAO;
import java.util.List;
//service permettant de filtrer les formations par date, par mot clé et par lieu
public class FormationService {

    /**
     * Searching formations regarding to information about title, date and location
     * @param mc
     * @param d
     * @param l
     * @return List of formation
     */
    public List searchFormations(String mc, Date d, Location l ){

            JdbcCourseSionDAO jcd = new JdbcCourseSionDAO();
            return jcd.findSessionByInfos(mc, d, l);
    }
    
    /**
     * Register a client to a sessionCourse
     * @param c
     * @return 
     */
    public int inscription(Client c){

            JdbcClientDAO jcl = new JdbcClientDAO();
            int k= jcl.insert(c);
            return k;

    }
    /**
     * Get all sessions courses available
     * @return List of session
     */
    public List getallFormations(){
            JdbcCourseSionDAO jcd = new JdbcCourseSionDAO();
            return jcd.getListSession();

    }
}
