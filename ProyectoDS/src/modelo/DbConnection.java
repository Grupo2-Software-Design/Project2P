package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Camilo
 */
public class DbConnection {

    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String database = "proyectoDS";
    public static String hostname = "localhost";

    // Path
    public static String url = "jdbc:mysql://" + hostname + "/" + database;

    public  Connection conectarMySQL() {
        Connection conn = null;
        Properties proper = new Properties();
        proper.put("user", "root");
        proper.put("password", "FPonce");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, proper);
        } catch (Exception e) {
            System.out.println("El problema con la base de datos es: " + e);
        }

        return conn;
    }
}

