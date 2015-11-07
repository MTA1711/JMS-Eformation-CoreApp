package fr.utbm.eformation.core.repository;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * Create a connection to the datbase
 * This class is made with singleton pattern
 * @author java
 */
public class DatabaseConnect {
    private static final String url = "jdbc:mysql://localhost:3306/E_FORMATION";
    private static final String user = "java";
    private static final String passwd = "java";
    private static Connection connect;
    
    public static Connection getInstance(){
    //if(connect == null){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(url, user, passwd);
        } catch (Throwable e) {
            System.out.println("CONNECTION KO! "+ e.getMessage());
            e.printStackTrace();
        }
    //}		
    return connect;	
  }
}
