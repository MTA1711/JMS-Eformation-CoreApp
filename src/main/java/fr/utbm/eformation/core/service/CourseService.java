package fr.utbm.eformation.core.service;

import fr.utbm.eformation.core.entity.Course;
import fr.utbm.eformation.core.repository.JdbcCourseDAO;
import java.util.List;

//CRUD sur la table course
public class CourseService {
    private JdbcCourseDAO jcd = new JdbcCourseDAO();

    /**
     * Add a new course in DB
     * @param c
     * @return 
     */
    public int addCourse(Course c){

            int k= jcd.insert(c);
            return k;
    }
    
    /**
     * Update course information
     * @param c
     * @return 
     */
    public int updateCourse(Course c){

            int k= jcd.update(c);
            return k;
    }
    
    /**
     * Delete a course
     * @param c
     * @return 
     */
    public int deleteCourse(Course c){

            int k= jcd.delete(c);
            return k;
    }
    
    /**
     * Get all courses available 
     * @return list of courses
     */
    public List getListCourses(){

            return jcd.getListCourse();
    }
    
    /**
     * Get information about a course
     * @param id
     * @return 
     */
    public Course getCourse(String id){

            return jcd.find(id);
    }

}
