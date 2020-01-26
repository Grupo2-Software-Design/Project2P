/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import modelo.Cotizacion;
import modelo.Venta;
import proyectods.ProyectoDS;

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
    private TableView<Venta> table;
    
    public static Cotizacion cotizacion= new Cotizacion();
    @FXML
    private TableColumn<Venta, Integer> idColumn;
    @FXML
    private TableColumn<Venta, String> tipoColumn;
    @FXML
    private TableColumn<Venta, String> nombreColumn;
    @FXML
    private TableColumn<Venta, Integer> cantidadColumn;
    @FXML
    private TableColumn<Venta, Float> pvUnidad;
    @FXML
    private TableColumn<Venta, Float> totalColumn;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarTabla();
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
        String query = "insert into Cotizacion values ("+cotizacion.getNumCotizacion()+","+nombre+","+stock+","+precioIndividual+","+precioMayor+", 1,"+categoria+","+descripcion+")";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }

    @FXML
    private void eliminarProducto(ActionEvent event) {
    }

    @FXML
    private void clearVentana(ActionEvent event) {
        idColumn.getColumns().removeAll(idColumn.getColumns());
        tipoColumn.getColumns().removeAll(tipoColumn.getColumns());
        nombreColumn.getColumns().removeAll(nombreColumn.getColumns());
        cantidadColumn.getColumns().removeAll(cantidadColumn.getColumns());
        pvUnidad.getColumns().removeAll(pvUnidad.getColumns());
        totalColumn.getColumns().removeAll(totalColumn.getColumns());
        
        
    }
    
    private void llenarTabla(){
        table.setItems((ObservableList<Venta>) cotizacion.getVentas());
        idColumn.setCellValueFactory(new PropertyValueFactory<Venta,Integer>("id"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<Venta,String>("tipo"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<Venta,String>("name"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<Venta,Integer>("cantidad"));
        pvUnidad.setCellValueFactory(new PropertyValueFactory<Venta,Float>("pvUnidad"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<Venta,Float>("total"));
        
    }

    
    
}
