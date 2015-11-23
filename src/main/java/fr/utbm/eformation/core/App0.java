package fr.utbm.eformation.core;

import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.core.entity.Course;
import fr.utbm.eformation.core.entity.CourseSession;
import fr.utbm.eformation.core.entity.Location;
import fr.utbm.eformation.core.repository.JdbcClientDAO;
import fr.utbm.eformation.core.repository.JdbcCourseDAO;
import fr.utbm.eformation.core.repository.JdbcCourseSessionDAO;
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
        JdbcCourseSessionDAO bdcs = new JdbcCourseSessionDAO();
        JdbcClientDAO bdcc = new JdbcClientDAO();
        
        CourseSession cs2 = bdcs.find(3);
        Location l3 = bdl.find(2);
        String title = "Développez";
        
        Date d =  new Date("12/30/2015");
  
        for (CourseSession cgi: bdcs.findSessionByInfos(null, d, null)){
            System.out.println(cgi);
        }
        //System.out.println(cli);
    }
}
