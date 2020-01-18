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
public class Empleado implements IUser {

    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String telefono;
    protected Usuario user;

    public Empleado(String cedula, String nombre, String apellido, String telefono, Usuario user) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.user = user;
    }

    @Override
    public void logger() {

    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public Usuario getUser() {
        return user;
    }
}
