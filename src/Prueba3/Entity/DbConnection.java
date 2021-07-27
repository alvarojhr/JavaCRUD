package Prueba3.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection connect(){
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:src/Prueba2/MisionTic.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("CONNECTION-"+e);
        }
        return  con;
    }
}
