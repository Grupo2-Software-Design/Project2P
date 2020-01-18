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
    public static String localhost = "localhost";

    // Path
    public static String url;

    public Connection conectarMySQL(String centraldb, String centralhost) {
        url = "jdbc:mysql://" + centralhost + "/" + centraldb;
        Connection conn = null;
        Properties proper = new Properties();
        proper.put("user", "root");
        proper.put("password", "FPonce");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, proper);
        } catch (Exception e) {
            System.out.println("El problema con la base de datos es: " + e);
            System.out.println("Conectandose a la base de datos local...");
            url = "jdbc:mysql://" + localhost + "/" + database;
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, proper);
            } catch (Exception locale) {
                System.out.println("No se pudo conectar a la base de datos local.");
            }
            return conn;
        }

        return conn;
    }
}
