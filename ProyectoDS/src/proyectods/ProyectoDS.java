/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectods;

import java.sql.Connection;
import modelo.DbConnection;

/**
 *
 * @author Freddy
 */
public class ProyectoDS {
    public static DbConnection db=new DbConnection();
    public static Connection cdb=db.conectarMySQL("proyectoDs","localhost");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
}