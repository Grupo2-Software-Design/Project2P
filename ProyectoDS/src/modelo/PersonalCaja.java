/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Statement;
import proyectods.ProyectoDS;

/**
 *
 * @author Freddy
 */
public class PersonalCaja extends Empleado{

    public PersonalCaja(String cedula, String nombre, String apellido, String telefono, Usuario user, String TipoEmpleado, Sucursal sucursal) {
        super(cedula, nombre, apellido, telefono, user, TipoEmpleado, sucursal);
    }
    
    public void agregarCliente(String cedula, String nombre, String apellido, int direccion, String telefono){
        String query="insert into Persona values ("+cedula+","+nombre+","+apellido+","+direccion+","+telefono;
        try{
            Statement statement = ProyectoDS.cdb.createStatement();
            statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }   
    
}
