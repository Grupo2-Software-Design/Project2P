package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import proyectods.ProyectoDS;

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
    
    public int addDireccion(int mz,String slr,String ciudad,String cPrincipal, String cSecundaria){
        String query = "insert into Direccion values ( default,"+mz+","+slr+","+ciudad+","+cPrincipal+","+cSecundaria+");";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
            String q2 = "SELECT LAST_INSERT_ID() as id";
            ResultSet rs = st.executeQuery(q2);
            return Integer.parseInt(rs.getString("id"));
            
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
        return 0;
    }
    
    public int detalleCotizacion(int producto,int cantidad,float precio,int cotizacion){
        //corregir diagrama de base de datos cotizacion tiene detalle cotizacion -tabla intermedia yo creo
        String query = "insert to DetalleCotizacion values( default,"+","+producto+","+cantidad+","+precio+");";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
            String q2 = "SELECT LAST_INSERT_ID() as id";
            ResultSet rs = st.executeQuery(q2);
            return Integer.parseInt(rs.getString("id"));

        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
        return 0;
    }
    public int detalleTraslado(int mascota,float monto,int factura,int direccion){
        String query = "insert to detalleTraslado values( default,"+","+mascota+","+monto+","+factura+","+direccion+");";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
            String q2 = "SELECT LAST_INSERT_ID() as id";
            ResultSet rs = st.executeQuery(q2);
            return Integer.parseInt(rs.getString("id"));

        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
        return 0;
    }
    public int detalleProducto(int producto,int cantidad,float precio_venta,int factura){
        String query = "insert to detalleProducto values( default,"+","+producto+","+cantidad+","+precio_venta+","+factura+");";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
            String q2 = "SELECT LAST_INSERT_ID() as id";
            ResultSet rs = st.executeQuery(q2);
            return Integer.parseInt(rs.getString("id"));

        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
        return 0;
    }
    public int detallerServicio(int servicio, int cantidad,float precio_venta, int factura){
        String query= "insert to detalleServicio values( default,"+","+servicio+","+cantidad+","+precio_venta+","+factura+");";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
            String q2 = "SELECT LAST_INSERT_ID() as id";
            ResultSet rs = st.executeQuery(q2);
            return Integer.parseInt(rs.getString("id"));
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
        return 0;
    }

}
