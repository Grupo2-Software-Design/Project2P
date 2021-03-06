/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class ClientesVentanaController extends StackPane implements Initializable {
    private Main application;
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
    public void backToMenu(ActionEvent event) {
        if (application == null){
            //Nothing
        }else{
            if (!application.userLogging()){
                System.out.println("F");
            }
        }
    }
    
    public void gotoNuevosClientes(ActionEvent event){
        if(application == null){
            System.out.println("F");
        }
        else{
            try {
                NuevoClienteVentanaController nClientes = (NuevoClienteVentanaController) application.replaceSceneContent("/vista/NuevoClienteVentana.fxml");
                nClientes.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
