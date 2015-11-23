package fr.utbm.eformation.core.repository;

import fr.utbm.eformation.core.util.DatabaseConnect;
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
 * DAO class for the Location. It uses JDBC implementation
 * @author java
 */
public class JdbcLocationDAO implements LocationInterfaceDAO{
    private Connection connexion ;
    @Override
    public int insert(Location obj) {
        int id = 0;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "INSERT INTO LOCATION(CITY) VALUES(?)";
            PreparedStatement stmt = this.connexion.prepareStatement(query, new String[]{"USER_ID"});
            stmt.setString(1, obj.getCity());
            int r = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                id = rs.getInt(1);
                obj.setLocationId(id);
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
    public int delete(Location obj) {
        int r = 0;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "DELETE FROM LOCATION WHERE ID= ? and CITY=?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setInt(1, obj.getLocationId());
            stmt.setString(2, obj.getCity());
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
    public int update(Location obj) {
        int r=0;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "UPDATE LOCATION SET CITY=? WHERE ID=?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setString(1, obj.getCity());
            stmt.setInt(2, obj.getLocationId());
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
    public Location find(int id) {
        Location l = null;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "SELECT * FROM LOCATION WHERE ID = ?";
            PreparedStatement stmt = this.connexion.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                l = new Location();
                l.setLocationId(rs.getInt(1));
                l.setCity(rs.getString(2));
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
        
        return l;
    }
    
    @Override
    public  List<Location> getListLocation(){
        List<Location> listLocation = null;
        try {
            this.connexion = DatabaseConnect.getInstance();
            String query = "SELECT * FROM LOCATION";
            Statement stmt = this.connexion.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            listLocation = new LinkedList<>();
            while (rs.next()){
                Location l = new Location();
                l.setLocationId(rs.getInt(1));
                l.setCity(rs.getString(2));            
                listLocation.add(l);                
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
        return listLocation;
    }
    
}
