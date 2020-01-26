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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import modelo.Cliente;
import modelo.Mascota;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class NuevaMascotaController extends StackPane implements Initializable {
    private Main application;
    @FXML
    private ComboBox<String> comboSize;
    @FXML
    private Button addButton;
    @FXML
    private TextField nombre;
    @FXML
    private TextField tipo;
    @FXML
    private TextField raza;
    @FXML
    private TextField peso;
    @FXML
    private TextField altura;
    @FXML
    private TextField edad;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboSize.getItems().removeAll(comboSize.getItems());
        comboSize.getItems().addAll("Pequeña","Grande");
    }    

    @FXML
    private void backToMenu(ActionEvent event) {
        if(application == null){
            System.out.println("F");
        }
        else{
            try {
                ServicioVentanaController servicios = (ServicioVentanaController) application.replaceSceneContent("/vista/ServicioVentana.fxml");
                servicios.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void setApp(Main application){
        this.application = application;
    }

    @FXML
    private void addMascota(ActionEvent event) {
        if(FacturarVentanaController.cliente!= null && comboSize.getSelectionModel().getSelectedItem() != null){
            Cliente c = FacturarVentanaController.cliente;
            String cd = c.getCedula();
            String name = nombre.getText();
            String race = raza.getText();
            int age = Integer.parseInt(edad.getText());
            float w = Float.parseFloat(peso.getText());
            float h = Float.parseFloat(altura.getText());
            String type = tipo.getText();
            String size = comboSize.getSelectionModel().getSelectedItem();
            String query = "INSERT INTO `mascota` (`nombre`, `raza`, `edad`, `peso`, `altura`, `tipo`, `dueño`, `tamaño`) VALUES ('"+name+"', '"+race+"', '"+age+"', '"+w+"', '"+h+"', '"+type+"', '"+cd+"', '"+size+"');";
            try{
                if(Main.cdb != null){
                    Statement st = Main.cdb.createStatement();
                    ResultSet rs = st.executeQuery(query);
                }
            }catch(SQLException ex){
                System.out.println("no insert");
            }
            
        }else{
            System.out.println("No se añadió");
        }
        
        
    }
    
    
    
    
}
