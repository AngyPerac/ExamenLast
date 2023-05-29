
package controlador;

//import java.sql.*;
import java.sql.Connection;// Objeto de conexión
import java.sql.DriverManager;// Objeto del controlador o driver JDBC
import javax.swing.JOptionPane;

public class Conecta {
    /*public static final String USU = "root";
    public static final String PAS = "12345678";
    public static final String URL = "jdbc:mysql://localhost:3306/sakila";*/
    
     public static Connection getConexion(String usu,String pas, String url) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// Driver depende de la BD
            //establece la conexión
            con = (Connection) DriverManager.getConnection(url, usu, pas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
