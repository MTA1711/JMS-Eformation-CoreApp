package fr.utbm.eformation.core.repository;

import fr.utbm.eformation.core.util.DatabaseConnect;
import fr.utbm.eformation.core.entity.Client;
import fr.utbm.eformation.core.entity.Course;
import fr.utbm.eformation.core.entity.CourseSession;
import fr.utbm.eformation.core.entity.Location;
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
 * DAO class for the Client. It uses JDBC implementation
 * @author java
 */
public class JdbcClientDAO implements ClientInterfaceDAO{
    private Connection connexion;

    @Override
    public int insert(Client obj) {
        int retour = 0;
        try {            
            this.connexion = DatabaseConnect.getInstance();
            String query = "INSERT INTO CLIENT(LASTNAME, FIRSTNAME, ADDRESS, PHONE, EMAIL, COURSE_SESSION_ID) VALUES(?,?,?,?,?,?)";
            PreparedStatement stmt = this.connexion.prepareStatement(query, new String[]{"USER_ID"});
            stmt.setString(1, obj.getLastName());
            stmt.setString(2, obj.getFirstName());
            stmt.setString(3, obj.getAddress());
            stmt.setString(4, obj.getPhone());
            stmt.setString(5, obj.getEmail());
            stmt.setInt(6, obj.getSession().getCourseSessionId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                retour = rs.getInt(1);
                obj.setIdClient(retour);
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
        return retour;
    }

    @Override
    public int delete(Client obj) {
        int r = 0;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "DELETE FROM CLIENT WHERE ID= ?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setInt(1, obj.getIdClient());
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
    public int update(Client obj) {
        int r=0;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "UPDATE CLIENT SET LASTNAME=?, FIRSTNAME=?, ADDRESS=?, PHONE=?, EMAIL=?, COURSE_SESSION_ID=? WHERE ID=?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setString(1, obj.getLastName());
            stmt.setString(2, obj.getFirstName());
            stmt.setString(3, obj.getAddress());
            stmt.setString(4, obj.getPhone());
            stmt.setString(5, obj.getEmail());
            stmt.setInt(6, obj.getSession().getCourseSessionId());
            stmt.setInt(7, obj.getIdClient());
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
    public Client find(int id) {
        Client c = null;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "SELECT cl.ID, cl.LASTNAME, cl.FIRSTNAME, cl.ADDRESS, cl.PHONE, cl.EMAIL, cl.COURSE_SESSION_ID, "
                    + " cs.START_DATE, cs.END_DATE, cs.COURSE_CODE, cc.TITLE, cs.LOCATION_ID, ll.CITY FROM CLIENT cl "
                    + " INNER JOIN COURSE_SESSION cs ON cl.COURSE_SESSION_ID = cs.ID  "
                    + "INNER JOIN COURSE cc ON cs.COURSE_CODE = cc.CODE"
                    + "INNER JOIN LOCATION ll ON cs.LOCATION_ID = ll.ID WHERE cl.ID = ?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                c = new Client();
                c.setIdClient(rs.getInt(1));
                c.setLastName(rs.getString(2));
                c.setFirstName(rs.getString(3));
                c.setAddress(rs.getString(4));
                c.setPhone(rs.getString(5));
                c.setEmail(rs.getString(6));
                
                CourseSession cs = new CourseSession();
                cs.setCourseSessionId(rs.getInt(7));
                cs.setStartDate(rs.getDate(8));
                cs.setEndDate(rs.getDate(9));
                
                Course cc = new Course();
                cc.setCourseCode(rs.getString(10));
                cc.setTitle(rs.getString(11));
                
                Location l = new Location();
                l.setLocationId(rs.getInt(12));
                l.setCity(rs.getString(13));
                
                cs.setCourse(cc);
                cs.setLocation(l);
                
                c.setSession(cs);
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
    public  List<Client> getListClient(){
        List<Client> listClient = null;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "SELECT cl.ID, cl.LASTNAME, cl.FIRSTNAME, cl.ADDRESS, cl.PHONE, cl.EMAIL, cl.COURSE_SESSION_ID, "
                    + " cs.START_DATE, cs.END_DATE, cs.COURSE_CODE, cc.TITLE, cs.LOCATION_ID, ll.CITY FROM CLIENT cl "
                    + " INNER JOIN COURSE_SESSION cs ON cl.COURSE_SESSION_ID = cs.ID  "
                    + "INNER JOIN COURSE cc ON cs.COURSE_CODE = cc.CODE"
                    + "INNER JOIN LOCATION ll ON cs.LOCATION_ID = ll.ID ";
            Statement stmt = this.connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            listClient = new LinkedList<>();
            
            while(rs.next()){
                Client c = new Client();
                c.setIdClient(rs.getInt(1));
                c.setLastName(rs.getString(2));
                c.setFirstName(rs.getString(3));
                c.setAddress(rs.getString(4));
                c.setPhone(rs.getString(5));
                c.setEmail(rs.getString(6));
                
                CourseSession cs = new CourseSession();
                cs.setCourseSessionId(rs.getInt(7));
                cs.setStartDate(rs.getDate(8));
                cs.setEndDate(rs.getDate(9));
                
                Course cc = new Course();
                cc.setCourseCode(rs.getString(10));
                cc.setTitle(rs.getString(11));
                
                Location l = new Location();
                l.setLocationId(rs.getInt(12));
                l.setCity(rs.getString(13));
                
                cs.setCourse(cc);
                cs.setLocation(l);
                
                c.setSession(cs);
                
                listClient.add(c);
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
        
        return listClient;
    }
    
}
