/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Statement;
import java.util.List;
import proyectods.ProyectoDS;

/**
 *
 * @author Freddy
 */
public class NotadeCredito extends Documento{
    private String numNota;

    public NotadeCredito(String numNota) {
        
        this.numNota = numNota;
    }

    @Override
    public void agregar() {
        String query = "insert into Cotizacion values ("+ numNota+","+super.fechaEmision+","+super.personalCaja.getCedula()+","+super.cliente.getCedula()+")";
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
