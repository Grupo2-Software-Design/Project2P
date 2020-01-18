package modelo;

import java.util.LinkedList;

/**
 *
 * @author Camilo
 */

public class Cliente{
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private LinkedList<Mascota> mascotas;

    public Cliente() {
    }

    public Cliente(String cedula, String nombre, String apellido, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        mascotas = new LinkedList<>();
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cliente cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public Cliente nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Cliente apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Cliente direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

}