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
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import modelo.Cotizacion;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class CotizarVentanaController extends StackPane implements Initializable {
    private Main application;
    @FXML
    private Label empleadoName;
    @FXML
    private Label date;
    @FXML
    private Label hora;
    @FXML
    private TableView<?> table;
    
    public static Cotizacion cotizacion;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backToMenu(ActionEvent event) {
        if (application == null){
            //Nothing
        }else{
            if (!application.userLogging()){
                System.out.println("F");
            }
        }
    }
    
    public void setApp(Main application){
        this.application = application;
    }
    
    @FXML
    public void gotoProductos(ActionEvent event){
        if(application == null){
            System.out.println("F");
        }
        else{
            try {
                ProductoCVentanaController productos = (ProductoCVentanaController) application.replaceSceneContent("/vista/ProductoCVentana.fxml");
                productos.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    public void gotoServicios(ActionEvent event){
        if(application == null){
            System.out.println("F");
        }
        else{
            try {
                ServicioCVentanaController servicios = (ServicioCVentanaController) application.replaceSceneContent("/vista/ServicioCVentana.fxml");
                servicios.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void makeCotizacion(ActionEvent event) {
    }

    @FXML
    private void eliminarProducto(ActionEvent event) {
    }

    @FXML
    private void clearVentana(ActionEvent event) {
    }
    

    
    
}
