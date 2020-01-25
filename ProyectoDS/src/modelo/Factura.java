package modelo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import proyectods.ProyectoDS;

/**
 *
 * @author Camilo
 */

public class Factura extends Documento{
    private int numFactura;
    private boolean domicilio;
    private LinkedList<Venta> ventas;
    private StrategyPay metodoPago;

    public Factura(int numFactura, boolean domicilio, LinkedList<Venta> ventas, StrategyPay metodoPago) {
        this.numFactura = numFactura;
        this.domicilio = domicilio;
        this.ventas = ventas;
        this.metodoPago = metodoPago;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public boolean isDomicilio() {
        return domicilio;
    }

    public void setDomicilio(boolean domicilio) {
        this.domicilio = domicilio;
    }

    public LinkedList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(LinkedList<Venta> ventas) {
        this.ventas = ventas;
    }

    public StrategyPay getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(StrategyPay metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    

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
    
    public void getFacturaID(){
        String query = "Select MAX(numFactura) From Factura";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(query);
            numFactura = Integer.parseInt(rs.getString("numFactura"))+1;
        }catch(Exception ex){
            System.out.println("Problemas en la query "+ ex);
        }
        
    }
    
    
}