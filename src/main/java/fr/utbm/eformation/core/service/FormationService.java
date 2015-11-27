package fr.utbm.eformation.core.service;



import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.core.entity.CourseSession;
import fr.utbm.eformation.core.entity.Location;
import fr.utbm.eformation.core.repository.ClientInterfaceDAO;
import fr.utbm.eformation.core.repository.CourseSessionInterfaceDAO;
import fr.utbm.eformation.core.util.Factory;
import java.util.Date;
import java.util.List;

/**
 * Service allowing to filter the courses session
 *
 * @author java
 */
public class FormationService {

    private CourseSessionInterfaceDAO jcd = Factory.getCourseSessionDAO();
    private ClientInterfaceDAO jcl = Factory.getClientDAO();

    /**
     * Searching formations regarding to information about title, date and
     * location
     *
     * @param mc
     * @param d
     * @param l
     * @return List of formation
     */
    public List searchFormations(String mc, Date d, Location l) {
        return jcd.findSessionByInfos(mc, d, l);
    }

    /**
     * Register a client to a sessionCourse
     *
     * @param c
     * @return
     */
    public int inscription(Client c) {
        int k = jcl.insert(c);
        return k;
    }

    /**
     * Get all sessions courses available
     *
     * @return List of session
     */
    public List getallFormations() {
        return jcd.getListSession();

    }

    public CourseSession getCourseSession(int id) {
        return jcd.find(id);
    }
}
