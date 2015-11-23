package fr.utbm.eformation.core.util;

import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.core.entity.Course;
import fr.utbm.eformation.core.repository.ClientInterfaceDAO;
import fr.utbm.eformation.core.repository.CourseInterfaceDAO;
import fr.utbm.eformation.core.repository.CourseSessionInterfaceDAO;
import fr.utbm.eformation.core.repository.DAOInterface;
import fr.utbm.eformation.core.repository.JdbcClientDAO;
import fr.utbm.eformation.core.repository.JdbcCourseDAO;
import fr.utbm.eformation.core.repository.JdbcCourseSessionDAO;
import fr.utbm.eformation.core.repository.JdbcLocationDAO;
import fr.utbm.eformation.core.repository.LocationInterfaceDAO;

/**
 * Allows independance between repository layer and service layer
 * @author java
 */
public class Factory {
    public static ClientInterfaceDAO getClientDAO(){
        return new JdbcClientDAO();
    }
    public static CourseInterfaceDAO getCourseDAO(){
        return new JdbcCourseDAO();
    }
    public static LocationInterfaceDAO getLocationDAO(){
        return new JdbcLocationDAO();
    }
    public static CourseSessionInterfaceDAO getCourseSessionDAO(){
        return new JdbcCourseSessionDAO();
    }
}
