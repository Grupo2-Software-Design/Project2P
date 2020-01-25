/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class LoginVentanaController extends StackPane implements Initializable{
    private Main application;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    public void setApp(Main application){
        this.application = application;
    }
    
    @FXML
    public void processLogin(ActionEvent event) {
        if (application == null){
            // We are running in isolated FXML, possibly in Scene Builder.
        } else {
            if(validateUser(userName,password)){
                if (!application.userLogging()){
                    System.out.println("F");
                }
            }
            else{
                System.out.println("F");
            }
        }
    }
    
    private boolean validateUser(TextField usName, TextField usPass){
        String uName = usName.getText();
        String uPass = usPass.getText();
        if(!"".equals(uPass) && !"".equals(uName)){
            String query = "SELECT * FROM usuario  WHERE  usuario.usuario = '"+uName+"' and estado = 1;";
            System.out.println(query);
        try{
            if(Main.cdb != null){
                Statement st = Main.cdb.createStatement();
                ResultSet rs = st.executeQuery(query);
                System.out.println("here");
                String usr = "";
                String pass = "";
                int type = 3;
                while (rs.next()) {
                    usr = rs.getString("usuario");
                    pass = rs.getString("contraseña");
                    type = rs.getInt("tipo");
                }
                System.out.println(usr);
                System.out.println(pass);
                System.out.println("f");
                if(!"".equals(usr)){
                    if(uPass.equals(pass)){
                        String tipo = "";
                        query = "SELECT * FROM tipoempleado  WHERE  tipoempleado.id_tipo = "+type+";";
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            tipo = rs.getString("nombre");
                        }
                        if(tipo != null){
                            Usuario usuario = new Usuario(uName,uPass,Usuario.Type.valueOf(tipo));
                            application.setUser(usuario);
                            return true;
                        }else{
                            System.out.println("mal tipo");
                        }
                    }else{
                        System.out.println("Contraseña mal");
                    }
                }else{
                    System.out.println("Usuario no existe");
                }   
            }else{
                System.out.println("No connection");
                return false;
            }  
        }
        catch(SQLException e){
            System.out.println("Problemas en la Query, "+e);
            return false;
        }
        }else{
            System.out.println("Campos vacios");
        }
        return false;
    }
}
