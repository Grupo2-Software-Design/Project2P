package modelo;

import java.util.LinkedList;
import proyectods.ProyectoDS;
import java.sql.Statement;

/**
 *
 * @author Carlos
 */

public class Cliente{
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private LinkedList<Mascota> mascotas;

    public Cliente() {
    }

    public Cliente(String cedula, String nombre, String apellido, String direccion,String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void agregarCliente(){
        String query="insert into Persona values ("+cedula+","+nombre+","+apellido+","+direccion+","+correo;
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }   
    public void updateCliente(String data){
        String query = "UPDATE Persona" + " SET " + data + " WHERE " + "cedula = " + cedula+";";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }   
    
    
    
}