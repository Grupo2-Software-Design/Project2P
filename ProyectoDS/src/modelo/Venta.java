package modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import proyectods.ProyectoDS;

/**
 *
 * @author Camilo
 */

public class Venta{
    private int cantidad;
    private Producto producto;
    private Servicio servicio;
    private String tipo;
    private int id;
    private float total;
    
    public Venta(int cantidad, Producto producto, String tipo) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.tipo = tipo;
        setVentaId();
    }
    
    public Venta(int cantidad, Servicio servicio, String tipo) {
        this.cantidad = cantidad;
        this.servicio = servicio;
        this.tipo = tipo;
        setVentaId();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    private void setVentaId(){
        switch(tipo){
            case "producto":
                    
                String query = "SELECT MAX(id_detalle) From DetalleProducto";
                try{
                    Statement st = ProyectoDS.cdb.createStatement();
                    ResultSet rs = st.executeQuery(query); 
                    id = Integer.parseInt(rs.getString("id_detalle"))+1;
                    total=producto.getPrecioIndividual()*cantidad;
                }catch(Exception e){
                    System.out.println("Problemas en la Query, "+e);
                }
                break;
            case "servicio":
                                    
                String query2 = "SELECT MAX(id_detalle) From DetalleServicio";
                try{
                    Statement st = ProyectoDS.cdb.createStatement();
                    ResultSet rs = st.executeQuery(query2); 
                    id = Integer.parseInt(rs.getString("id_detalle"))+1;
                }catch(Exception e){
                    System.out.println("Problemas en la Query, "+e);
                }
                break;
            
        
    }
                
            
            
        }
    

}
    