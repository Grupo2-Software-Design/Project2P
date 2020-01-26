/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import modelo.Cliente;
import modelo.Cotizacion;
import modelo.EfectivoStrategy;
import modelo.Factura;
import modelo.StrategyPay;
import modelo.Venta;
import proyectods.ProyectoDS;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class FacturarVentanaController extends StackPane implements Initializable {
    static Cliente cliente;
    private Main application;
    @FXML
    private TableView<?> ventanaPro;
    public static Factura factura;
    @FXML
    private TextField cedula;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> nombre;
    @FXML
    private TableColumn<?, ?> canti;
    @FXML
    private TableColumn<?, ?> tipo;
    @FXML
    private CheckBox domicilio;
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
    
    @FXML
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
    
    @FXML
    public void gotoProductos(ActionEvent event){
        if(application == null){
            System.out.println("F");
        }
        else{
            try {
                ProductoVentanaController productos = (ProductoVentanaController) application.replaceSceneContent("/vista/ProductoVentana.fxml");
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
                ServicioVentanaController servicios = (ServicioVentanaController) application.replaceSceneContent("/vista/ServicioVentana.fxml");
                servicios.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /*@FXML
    private void facturarListo(ActionEvent event) {
        factura =new Factura(0,domicilio.isSelected(),null, new EfectivoStrategy());
        LinkedList<Venta> ventas=new LinkedList<>(); 
        for(int i=0, i<id){
            
        }
        
    }
    
    @FXML
    private void actualizar(ActionEvent event) {
    }*/

    @FXML
    private void facturarListo(ActionEvent event) {
        
        searchCliente(cedula.getText());
    }

    @FXML
    private void actualizar(ActionEvent event) {
    }
    
    public Cliente searchCliente(String cedula){
        String query = "SELECT * FROM Persona  WHERE cedula = "+cedula+";";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(query);
            String cedu = rs.getString("cedula");
            String name = rs.getString("nombre");
            String last = rs.getString("apellido");
            int direc=Integer.parseInt(rs.getString("direccion"));
            String telefon=rs.getString("telefono");
            String correo=rs.getString("correo");
            cliente=new Cliente(cedu, name, last, direc, correo,telefon);       
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
        return null;
    }
   
}
