/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Freddy
 */
public class Administrativo extends Empleado{

    public Administrativo(String cedula, String nombre, String apellido, String telefono, Usuario user, String TipoEmpleado, Sucursal sucursal) {
        super(cedula, nombre, apellido, telefono, user, TipoEmpleado, sucursal);
    }
    
}
