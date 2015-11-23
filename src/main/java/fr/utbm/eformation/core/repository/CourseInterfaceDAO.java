package fr.utbm.eformation.core.repository;

import fr.utbm.eformation.core.entity.Course;
import java.util.List;

/**
 * Interface for the courses DAO. It extends DAOInterface
 * @author java
 */
public interface CourseInterfaceDAO extends DAOInterface<Course>{
    /**
     * get course by a string ID.
     * @param id
     * @return course
     */
    public Course find(String id);
    /**
     * Get all the courses in DB
     * @return list of course
     */
    public List<Course> getListCourse();
}
