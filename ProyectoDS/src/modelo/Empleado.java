/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import proyectods.ProyectoDS;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

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
    protected String TipoEmpleado;
    protected Sucursal sucursal;

    public Empleado(String cedula, String nombre, String apellido, String telefono, Usuario user,String TipoEmpleado,Sucursal sucursal) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.user = user;
        this.TipoEmpleado=TipoEmpleado;
        this.sucursal=sucursal;
    }

    public void agregar(){
        String query = "insert into Empleado values ( "+cedula+","+nombre+","+apellido+","+sucursal.getNumSucursal()+","+user.getUsername()+","+TipoEmpleado+")";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }
    public void update(String argNuevo,String var,String argViejo){
    String query = "UPDATE Empleado SET " + argNuevo + " WHERE " + var+" = " + argViejo+";";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }
    public List<Empleado> searchEmpleado(String arg,String var){
        List<Empleado> empleados = new LinkedList<>();
        String query = "SELECT * FROM Empleado  WHERE "+var+" = "+arg;
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Empleado emp = new Empleado(rs.getString("cedula"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("telefono"),new Usuario(rs.getString("username"),null),rs.getString("TipoEmpleado"),null);
                empleados.add(emp);
            }
            return empleados;
                
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
        return null;
    }
    
    public void delete(){
        String query = "UPDATE Empleado SET sucursal=NULL WHERE id_producto = "+cedula+";";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
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
