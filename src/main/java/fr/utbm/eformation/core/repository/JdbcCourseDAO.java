package fr.utbm.eformation.core.repository;

import fr.utbm.eformation.core.entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author java
 */
public class JdbcCourseDAO implements DAOInterface<Course>{
    private Connection connexion ;
    
    @Override
    public int insert(Course obj) {
        int r = 0;
        try {            
            this.connexion = DatabaseConnect.getInstance();
            String query = "INSERT INTO COURSE(CODE, TITLE) VALUES(?,?)";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setString(1, obj.getCourseCode());
            stmt.setString(2, obj.getTitle());
            r = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcLocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (connexion!=null) connexion.close();
            } 
            catch (SQLException ex) {}
        }
        return r;
    }

    @Override
    public int delete(Course obj) {
        int r = 0;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "DELETE FROM COURSE WHERE CODE= ? and TITLE=?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setString(1, obj.getCourseCode());
            stmt.setString(2, obj.getTitle());
            r = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcLocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (connexion!=null) connexion.close();
            } 
            catch (SQLException ex) {}
        }
        return r;
    }

    @Override
    public int update(Course obj) {
        int r=0;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "UPDATE COURSE SET TITLE=? WHERE CODE=?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setString(1, obj.getTitle());
            stmt.setString(2, obj.getCourseCode());
            r = stmt.executeUpdate();                       
        } catch (SQLException ex) {
            Logger.getLogger(JdbcLocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (connexion!=null) connexion.close();
            } 
            catch (SQLException ex) {}
        }
        return r;
    }

    /**
    * get information about object with id in parameter
    * @param id
    * @return Course
    */
    public Course find(String id) {
        Course c = null;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "SELECT * FROM COURSE WHERE CODE = ?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                c = new Course();
                c.setCourseCode(rs.getString(1));
                c.setTitle(rs.getString(2));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcLocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (connexion!=null) connexion.close();
            } 
            catch (SQLException ex) {}
        }
        
        return c;
    }

    @Override
    public Course find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
    * get list of all courses in the catalogue
    * 
    * @return List
    */
    public  List<Course> getListCourse(){
        List<Course> listCourse = null;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "SELECT * FROM COURSE";
            Statement stmt = this.connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            listCourse = new LinkedList<>();
            while (rs.next()){
                Course l = new Course();
                l.setCourseCode(rs.getString(1));
                l.setTitle(rs.getString(2));            
                listCourse.add(l);                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcLocationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                if (connexion!=null) connexion.close();
            } 
            catch (SQLException ex) {}
        }
        return listCourse;
    }
}
