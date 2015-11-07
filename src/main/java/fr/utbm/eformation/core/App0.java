package fr.utbm.eformation.core;

import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.core.entity.Course;
import fr.utbm.eformation.core.entity.CourseSession;
import fr.utbm.eformation.core.entity.Location;
import fr.utbm.eformation.core.repository.JdbcClientDAO;
import fr.utbm.eformation.core.repository.JdbcCourseDAO;
import fr.utbm.eformation.core.repository.JdbcCourseSionDAO;
import fr.utbm.eformation.core.repository.JdbcLocationDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author java
 */
public class App0 {
    public static void main(String[] args){
        CourseSession cs = new CourseSession();
        JdbcLocationDAO bdl = new JdbcLocationDAO();
        JdbcCourseDAO bdc = new JdbcCourseDAO();
        JdbcCourseSionDAO bdcs = new JdbcCourseSionDAO();
        JdbcClientDAO bdcc = new JdbcClientDAO();
        
        CourseSession cs2 = bdcs.find(3);
        Location l3 = bdl.find(2);
        String title = "Développez";
  
        for (CourseSession cgi: bdcs.findSessionByInfos(null, null, l3)){
            System.out.println(cgi);
        }
        //System.out.println(cli);
    }
}
