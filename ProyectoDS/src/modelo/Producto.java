/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Queryable;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import proyectods.ProyectoDS;

/**
 *
 * @author NICOLE
 */
public class Producto implements Queryable {
    private String id;
    private String nombre;
    private float precioIndividual;
    private float stock;
    private float precioMayor;
    private String categoria;
    private String descripcion;

    public Producto(String nombre,float stock, float precioIndividual, float precioMaror, String categoria, String descripcion) {
        this.nombre = nombre;
        this.precioIndividual = precioIndividual;
        this.stock = stock;
        this.precioMayor = precioMaror;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public float getPrecioMayor() {
        return precioMayor;
    }
 
    public void agregar(){
        String query = "insert into Producto values ( default,"+nombre+","+stock+","+precioIndividual+","+precioMayor+", 1,"+categoria+","+descripcion+")";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }
    public void update(String argNuevo,String var,String argViejo){
    String query = "UPDATE Persona SET " + argNuevo + " WHERE " + var+" = " + argViejo+";";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }
    public List<Producto> searchProducto(String arg,String var){
        List<Producto> productos = new LinkedList<>();
        String query = "SELECT * FROM Producto  WHERE "+var+" = "+arg+" and estado = 1;";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                float stk = Float.parseFloat(rs.getString("stock"));
                float prvM = Float.parseFloat(rs.getString("precio_porMayor"));
                float prvI = Float.parseFloat(rs.getString("precio_individual"));
                Producto prd = new Producto(rs.getString("nombre"),stk,prvI,prvM,rs.getString("categoria"),rs.getString("descripcion"));
                prd.setId(rs.getString("id_producto"));
                productos.add(prd);
            }
            return productos;
                
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
        return null;
    }
    
    public void delete(){
        String query = "UPDATE Producto SET "+"0 WHERE id_producto = "+id+";";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }
    
    public float getPrecioIndividual() {
        return precioIndividual;
    }

    public void setPrecioIndividual(float precioIndividual) {
        this.precioIndividual = precioIndividual;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getPrecioMaror() {
        return precioMayor;
    }

    public void setPrecioMayor(float precioMayor) {
        this.precioMayor = precioMayor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precioIndividual;
    }

    public void setPrecio(float precio) {
        this.precioIndividual = precio;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}   
