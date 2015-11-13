package fr.utbm.eformation.core.service;

import fr.utbm.eformation.core.entity.Course;
import fr.utbm.eformation.core.repository.JdbcCourseDAO;
import java.util.List;

//CRUD sur la table course
public class CourseService {
	private JdbcCourseDAO jcd = new JdbcCourseDAO();

	public int addCourse(Course c){

		int k= jcd.insert(c);
                return k;
	}

	public int updateCourse(Course c){

		int k= jcd.update(c);
                return k;
	}

	public int deleteCourse(Course c){

		int k= jcd.delete(c);
                return k;
	}

	public List getListCourses(){

		return jcd.getListCourse();
	}
        
        public Course getCourse(String id){

		return jcd.find(id);
	}

}
