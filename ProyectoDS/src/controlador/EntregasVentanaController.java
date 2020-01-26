/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import modelo.Entrega;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class EntregasVentanaController extends StackPane implements Initializable {
    private Main application;
    @FXML
    private TableView<Entrega> entrega;
    @FXML
    private TableColumn<Entrega, String> cliente;
    @FXML
    private TableColumn<Entrega, String> direccion;
    @FXML
    private TableColumn<Entrega, String> descripcion;
    @FXML
    private TableColumn<Entrega, String> repartidor;
    @FXML
    private TableColumn<Entrega, String> estado;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
    
}
