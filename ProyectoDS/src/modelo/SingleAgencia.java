/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NICOLE
 */
public class SingleAgencia implements Suscriptor{
    private DbConnection database;
    private List<Sucursal> sucursales = new LinkedList<>();
    private DataBackup backupDB;
    private static SingleAgencia agencia;

    private SingleAgencia() {
        
    }
    
    public static SingleAgencia getInstance(){
        if(agencia == null)
            agencia = new SingleAgencia();
        return agencia;
    }
    
    public void addSucursal(Sucursal sucursal){
        sucursales.add(sucursal);
    }

    @Override
    public void actualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
