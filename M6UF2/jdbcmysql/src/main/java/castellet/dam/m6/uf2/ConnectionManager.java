package castellet.dam.m6.uf2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionManager {
    private static String urlstring = "jdbc:mysql://mysql-rfam-public.ebi.ac.uk:4497/Rfam";    
    //private static String driverName = "com.mysql.jdbc.Driver";   
    private static String username = "rfamro";   
    private static String password = "";
    private static Connection con;

    public static Connection getConnection() {
        try {
            try {
                con = DriverManager.getConnection(urlstring, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (Exception ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return con;
    }
}