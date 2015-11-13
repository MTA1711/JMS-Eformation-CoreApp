package fr.utbm.eformation.core.repository;

import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.core.entity.Course;
import fr.utbm.eformation.core.entity.CourseSession;
import fr.utbm.eformation.core.entity.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author java
 */
public class JdbcCourseSionDAO implements DAOInterface<CourseSession>{
    private Connection connexion;

    @Override
    public int insert(CourseSession obj) {
        int id = 0;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "INSERT INTO COURSE_SESSION(START_DATE, END_DATE,COURSE_CODE,LOCATION_ID) VALUES(?,?,?,?)";
            PreparedStatement stmt = this.connexion.prepareStatement(query, new String[]{"USER_ID"});
            stmt.setDate(1, new java.sql.Date(obj.getStartDate().getTime()) );
            stmt.setDate(2, new java.sql.Date(obj.getEndDate().getTime()) );
            stmt.setString(3, obj.getCourse().getCourseCode());
            stmt.setInt(4, obj.getLocation().getLocationId());
            int r = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                id = rs.getInt(1);
                obj.setCourseSessionId(id);
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
        return id;
    }

    @Override
    public int delete(CourseSession obj) {
        int r = 0;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "DELETE FROM COURSE_SESSION WHERE ID= ?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setInt(1, obj.getCourseSessionId());
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
    public int update(CourseSession obj) {
        int r=0;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "UPDATE COURSE_SESSION SET START_DATE=?, END_DATE=?, COURSE_CODE=?, LOCATION_ID=? WHERE ID=?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setDate(1, new java.sql.Date(obj.getStartDate().getTime()) );
            stmt.setDate(2, new java.sql.Date(obj.getEndDate().getTime()) );
            stmt.setString(3, obj.getCourse().getCourseCode());
            stmt.setInt(4, obj.getLocation().getLocationId());
            stmt.setInt(5, obj.getCourseSessionId());
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
    public CourseSession find(int id) {
        CourseSession cs = null;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "SELECT cs.ID, cs.START_DATE, cs.END_DATE, cs.COURSE_CODE, cc.TITLE, cs.LOCATION_ID, ll.CITY"
                    + " FROM COURSE_SESSION cs INNER JOIN COURSE cc ON cs.COURSE_CODE = cc.CODE"
                    + " INNER JOIN LOCATION ll ON cs.LOCATION_ID = ll.ID WHERE cs.ID = ?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                cs = new CourseSession();
                cs.setCourseSessionId(rs.getInt(1));
                cs.setStartDate(rs.getDate(2));
                cs.setEndDate(rs.getDate(3));
                
                Course c = new Course();
                c.setCourseCode(rs.getString(4));
                c.setTitle(rs.getString(5));
                
                Location l = new Location();
                l.setLocationId(rs.getInt(6));
                l.setCity(rs.getString(7));
                
                cs.setCourse(c);
                cs.setLocation(l);
                
                cs.setClients(this.getClientBySession(cs));
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
        
        return cs;
    }
    
    public List<CourseSession> getListSession(){
        List<CourseSession> ls = new LinkedList<>();
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "SELECT cs.ID, cs.START_DATE, cs.END_DATE, cs.COURSE_CODE, cc.TITLE, cs.LOCATION_ID, ll.CITY"
                    + " FROM COURSE_SESSION cs INNER JOIN COURSE cc ON cs.COURSE_CODE = cc.CODE"
                    + " INNER JOIN LOCATION ll ON cs.LOCATION_ID = ll.ID";
            Statement stmt = this.connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()){
                CourseSession cs = new CourseSession();
                cs.setCourseSessionId(rs.getInt(1));
                cs.setStartDate(rs.getDate(2));
                cs.setEndDate(rs.getDate(3));
                
                Course c = new Course();
                c.setCourseCode(rs.getString(4));
                c.setTitle(rs.getString(5));
                
                Location l = new Location();
                l.setLocationId(rs.getInt(6));
                l.setCity(rs.getString(7));
                
                cs.setCourse(c);
                cs.setLocation(l);
                
                cs.setClients(this.getClientBySession(cs));
                ls.add(cs);
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
       
        return ls;
    }
    
    public List<Client> getClientBySession(CourseSession cc){
        List<Client> lc = new LinkedList<>();
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "SELECT * FROM CLIENT cl WHERE cl.COURSE_SESSION_ID = ?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setInt(1, cc.getCourseSessionId());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Client c = new Client();
                c.setIdClient(rs.getInt(1));
                c.setLastName(rs.getString(2));
                c.setFirstName(rs.getString(3));
                c.setAddress(rs.getString(4));
                c.setPhone(rs.getString(5));
                c.setEmail(rs.getString(6));
                c.setSession(cc);
                lc.add(c);
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
        return lc;
    }
    
    public List<CourseSession> findSessionByInfos(String title,Date date,Location location){
        List<CourseSession> ls = new LinkedList<>();
        try {
            this.connexion = DatabaseConnect.getInstance();
            PreparedStatement stmt = buildRequest(title,date,location, this.connexion);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                CourseSession cs = new CourseSession();
                cs.setCourseSessionId(rs.getInt(1));
                cs.setStartDate(rs.getDate(2));
                cs.setEndDate(rs.getDate(3));
                
                Course c = new Course();
                c.setCourseCode(rs.getString(4));
                c.setTitle(rs.getString(5));
                
                Location l = new Location();
                l.setLocationId(rs.getInt(6));
                l.setCity(rs.getString(7));
                
                cs.setCourse(c);
                cs.setLocation(l);
                
                cs.setClients(this.getClientBySession(cs));
                ls.add(cs);
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
        return ls;
    }
    
    private PreparedStatement buildRequest(String title,Date date, Location location, Connection connexion ) throws SQLException{
        String s = "";
        int i = 0;
        int k = 1;
        boolean t = false;
        boolean d = false;
        boolean l = false;
        
        String query = "SELECT cs.ID, cs.START_DATE, cs.END_DATE, cs.COURSE_CODE, cc.TITLE, cs.LOCATION_ID, ll.CITY"
                    + " FROM COURSE_SESSION cs INNER JOIN COURSE cc ON cs.COURSE_CODE = cc.CODE"
                    + " INNER JOIN LOCATION ll ON cs.LOCATION_ID = ll.ID  ";
        if ( title != null){
            title = "%"+title+"%";
            s += " cc.TITLE like ? ";
            t = true;
            i++;
        }
        
        if (location != null){
            if (i != 0){
                s +=" AND ll.CITY = ? ";
            }else{
                s +=" ll.CITY = ? ";
            }
            l = true;
            i++;
        }
        
        if (date != null){
            s += " cs.START_DATE <= ? and ? <= cs.END_DATE ";
            d = true;
            i++;
        }
        
        if ( i != 0){
            query += " WHERE "+s ;
        }
        
        PreparedStatement stmt = connexion.prepareStatement(query);
        //System.out.println(stmt);
        if (t){
            stmt.setString(k++, title);
        }
        if(l){
            stmt.setString(k++, location.getCity());
        }
        if(d){
            stmt.setDate(k++, new java.sql.Date(date.getTime()));
            stmt.setDate(k++, new java.sql.Date(date.getTime()));
        }
        //System.out.println(stmt);
        return stmt;
    }
}
