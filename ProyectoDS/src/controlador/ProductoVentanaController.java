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
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import modelo.Producto;
import modelo.Venta;
import proyectods.ProyectoDS;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class ProductoVentanaController extends StackPane implements Initializable {
    private Main application;
    @FXML
    private TableView<Producto> tabla;
    @FXML
    private ComboBox<String> combobox;
    private List<Producto> productos = new LinkedList<>();
    private List<Venta> ventas = new LinkedList<>();
    @FXML
    private TextField searchArtTxtfield;
    @FXML
    private TextField cantidadTxtField;
    @FXML
    private Button colocarButton;
    @FXML
    private TableColumn<Producto, String> TableColumnNombre;
    @FXML
    private TableColumn<Producto, Integer> TableColumnStock;
    @FXML
    private TableColumn<Producto, Float> TableColumnPrecioI;
    @FXML
    private TableColumn<Producto, Float> TableColumnPrecioM;
    @FXML
    private TableColumn<Producto, String> TableColumnCategoria;
    @FXML
    private TableColumn<Producto, String> TableColumnDesc;
    @FXML
    private TableColumn<Producto, Integer> TableColumnid;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combobox= new ComboBox<>();
        searchArtTxtfield = new TextField();
        cantidadTxtField = new TextField();
        tabla = new TableView<>();
        combobox.getItems().addAll("Nombre","Categoria","Descripción");

    }    

    @FXML
    private void backToMenu(ActionEvent event) {
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
    
   
    public void setApp(Main application){
        this.application = application;
    }

    @FXML
    private void searchArticulo(ActionEvent event) {
        String query = "SELECT * FROM Producto where"+combobox.getValue()+"like \"%{$"+searchArtTxtfield.getText()+"}%\" estado = 1;";
        try {
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                float stk = Float.parseFloat(rs.getString("stock"));
                float prvM = Float.parseFloat(rs.getString("precio_porMayor"));
                float prvI = Float.parseFloat(rs.getString("precio_individual"));
                Producto prd = new Producto(rs.getString("nombre"), stk, prvI, prvM, rs.getString("categoria"), rs.getString("descripcion"));
                prd.setId(rs.getString("id_producto"));
                productos.add(prd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoVentanaController.class.getName()).log(Level.SEVERE, null, ex);
        }
         tabla.setItems((ObservableList<Producto>) productos);
         searchArtTxtfield.setText(null);
    }    

    @FXML
    private void añadirArticulo(ActionEvent event) {
        Producto prd = tabla.getSelectionModel().getSelectedItem();
        //Venta vt = new Venta(Integer.parseInt(cantidadTxtField.getText()),prd,"Factura");
        ProductoVentanaController.factura,getVentas().add(vt);
        cantidadTxtField.setText(null);
        
        
    }
}