/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import proyectods.ProyectoDS;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Carlos
 */
public class Usuario {
    private String username;
    private String password;
    private Type tipo;

    public Usuario(String username, String password, Type tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void agregar(){
        String query="insert into Usuario values ("+username+","+password+");";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }   
    public void update(String argNuevo,String var,String argViejo){
        String query = "UPDATE USUARIO SET " + argNuevo + " WHERE " + var+" = " + argViejo+";";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }
   
    
    public void delete(){
        String query = "UPDATE Usuario SET "+"0 WHERE usuario = "+username+";";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }
    
    public enum Type{ADMIN,JEFEBODEGA,CAJERO}
}
