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
public class JefeBodega extends Empleado{

    public JefeBodega(String cedula, String nombre, String apellido, String telefono, Usuario user) {
        super(cedula, nombre, apellido, telefono, user);
    }
    
    public void cambiarPrecio(Producto p, float precio){
        p.setPrecio(precio);
    }
}
