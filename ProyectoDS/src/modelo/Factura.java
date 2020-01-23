package modelo;

import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import proyectods.ProyectoDS;

/**
 *
 * @author Camilo
 */

public class Factura extends Documento{
    private String numFactura;
    private boolean domicilio;
    private LinkedList<Venta> ventas;
    private StrategyPay metodoPago;

    @Override
    public void agregar() {
        String query = "insert into Cotizacion values ("+ numFactura+","+super.fechaEmision+","+super.personalCaja.getCedula()+","+super.cliente.getCedula()+")";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Documento> searchProducto(String arg, String var) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}