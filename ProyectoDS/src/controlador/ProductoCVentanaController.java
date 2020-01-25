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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import modelo.Articulo;
import modelo.Producto;
import modelo.Venta;
import proyectods.ProyectoDS;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class ProductoCVentanaController extends StackPane implements Initializable {
    private Main application;
    @FXML
    private ComboBox<String> buscarPor;
    @FXML
    private TextField campoBusqueda;
    @FXML
    private TextField cantidad;
    @FXML
    private TableColumn<Producto, String> nombre;
    @FXML
    private TableColumn<Producto, Integer> stock;
    @FXML
    private TableColumn<Producto, Float> pvIn;
    @FXML
    private TableColumn<Producto, Float> pvM;
    @FXML
    private TableColumn<Producto, String> categoria;
    @FXML
    private TableColumn<Producto, String> descripcion;
    @FXML
    private TableView<Producto> productosTable;
    @FXML
    private TableColumn<Producto, Integer> id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buscarPor = new ComboBox<>();
        buscarPor.getItems().addAll("Nombre","Categoria","Descripcion"); //Llenando opciones del comboBox
        
        
        
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
    private void buscarArticulo(ActionEvent event) {
        List<Producto> productos = new LinkedList<>();
        String query = "SELECT * FROM Producto  WHERE "+buscarPor.getValue()+" LIKE '%{$"+campoBusqueda.getText()+"}% and estado = 1;";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                float stk = Float.parseFloat(rs.getString("stock"));
                float prvM = Float.parseFloat(rs.getString("precio_porMayor"));
                float prvI = Float.parseFloat(rs.getString("precio_individual"));
                Producto prd = new Producto(rs.getString("nombre"),stk,prvI,prvM,rs.getString("categoria"),rs.getString("descripcion"));
                prd.setId(rs.getString("id_producto"));
                productos.add(prd);
            }
            productosTable.setItems((ObservableList<Producto>) productos);
            campoBusqueda.setText("");
            
            
                
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }

    @FXML
    private void colocarProducto(ActionEvent event) {
        Producto prd = productosTable.getSelectionModel().getSelectedItem();
        Venta vt = new Venta(Integer.parseInt(cantidad.getText()),prd,"cotizacion");
        CotizarVentanaController.cotizacion.getVentas().add(vt);
        cantidad.setText("");
    }

}
