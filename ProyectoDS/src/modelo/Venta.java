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
    private String name;
    private float pvUnidad;
    
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
                    name = producto.getNombre();
                    pvUnidad =producto.getPrecioIndividual();
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
                    total=servicio.getPrecio()*cantidad;
                    name = servicio.getName();
                    pvUnidad = servicio.getPrecio();
                }catch(Exception e){
                    System.out.println("Problemas en la Query, "+e);
                }
                break;
            
        
    }
                
            
            
        }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPvUnidad() {
        return pvUnidad;
    }

    public void setPvUnidad(float pvUnidad) {
        this.pvUnidad = pvUnidad;
    }
    

}
    