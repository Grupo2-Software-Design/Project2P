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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import modelo.Servicio;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class ServicioCVentanaController extends StackPane implements Initializable {
    private Main application;
    @FXML
    private ComboBox<String> combobox;
    @FXML
    private TextField parametro;
    @FXML
    private TableColumn<Servicio, Integer> idColum;
    @FXML
    private TableColumn<Servicio, String> nombreColum;
    @FXML
    private TableColumn<Servicio, Float> precioColum;
    @FXML
    private TableColumn<Servicio, String> descripcionColum;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combobox = new ComboBox<>();
        combobox.getItems().addAll("Nombre","Categoria","Descripcion"); //Llenando opciones del comboBox
        
    }    

    @FXML
    private void backToMenu(ActionEvent event) {
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
    
    public void setApp(Main application){
        this.application = application;
    }

    @FXML
    private void buscar(ActionEvent event) {
    }

    @FXML
    private void colocar(ActionEvent event) {
    }
    
}
