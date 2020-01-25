/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import proyectods.ProyectoDS;

/**
 *
 * @author Freddy
 */
public class Cotizacion extends Documento{
    private int numCotizacion;
    private List<Venta> ventas;

    public Cotizacion(int numCotizacion) {
        this.numCotizacion = numCotizacion;
        ventas = new LinkedList<>();
        getCotizacionID();
    }

    @Override
    public void agregar() {
        String query = "insert into Cotizacion values ("+ numCotizacion+","+super.fechaEmision+","+super.personalCaja.getCedula()+","+super.cliente.getCedula()+")";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }

    @Override
    public void update(String argNuevo, String var, String argViejo) {
    }

    @Override
    public List<Documento> searchProducto(String arg, String var) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumCotizacion() {
        return numCotizacion;
    }

    public void setNumCotizacion(int numCotizacion) {
        this.numCotizacion = numCotizacion;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
    
    private void getCotizacionID(){
        String query = "SELECT MAX(id_cotizacion) FROM Cotizacion";
        try{
           Statement st = ProyectoDS.cdb.createStatement();
           ResultSet rs = st.executeQuery(query); 
           numCotizacion = Integer.parseInt(rs.getString("id"))+1;
        }catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
        
    }
    
    }
