/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import modelo.Servicio;
import modelo.Venta;
import proyectods.ProyectoDS;

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
    @FXML
    private TableView<Servicio> table;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combobox.getItems().removeAll(combobox.getItems());
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
        ObservableList<Servicio> servicios = FXCollections.observableArrayList();
        String query = "SELECT * FROM Producto  WHERE "+combobox.getValue()+" LIKE '%{$"+parametro.getText()+"}% and estado = 1;";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int id = Integer.parseInt(rs.getString("id_servicio"));
                float precio = Float.parseFloat(rs.getString("precio"));
                Servicio srv = new Servicio(id,rs.getString("nombre"),rs.getString("descripcion"),precio);
                servicios.add(srv);
            }
            table.setItems(servicios);
            parametro.setText("");     
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }

    @FXML
    private void colocar(ActionEvent event) {
        Servicio srv = table.getSelectionModel().getSelectedItem();
        Venta vt = new Venta(1,srv,"servicio");
        CotizarVentanaController.cotizacion.getVentas().add(vt);
        
    }
    
}
