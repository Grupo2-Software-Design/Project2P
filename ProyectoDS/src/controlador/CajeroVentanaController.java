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
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class CajeroVentanaController extends StackPane implements Initializable {
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
     
    public void processLogout(ActionEvent event) {
        if (application == null){
            return;
        }
        
        application.userLogout();
    }
    
    public void gotoClientes(ActionEvent event){
        if(application == null){
            System.out.println("F");
        }
        else{
            try {
                ClientesVentanaController clientes = (ClientesVentanaController) application.replaceSceneContent("/vista/ClientesVentana.fxml");
                clientes.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void gotoFacturar(ActionEvent event){
        if(application == null){
            System.out.println("F");
        }
        else{
            try {
                FacturarVentanaController clientes = (FacturarVentanaController) application.replaceSceneContent("/vista/FacturarVentana.fxml");
                clientes.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void gotoCotizar(ActionEvent event){
        if(application == null){
            System.out.println("F");
        }
        else{
            try {
                CotizarVentanaController clientes = (CotizarVentanaController) application.replaceSceneContent("/vista/CotizarVentana.fxml");
                clientes.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void gotoEntregas(ActionEvent event){
        if(application == null){
            System.out.println("F");
        }
        else{
            try {
                EntregasVentanaController entregas = (EntregasVentanaController) application.replaceSceneContent("/vista/EntregasVentana.fxml");
                entregas.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
