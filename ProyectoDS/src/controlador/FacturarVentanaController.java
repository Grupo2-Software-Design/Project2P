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
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import modelo.Cotizacion;
import proyectods.ProyectoDS;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class FacturarVentanaController extends StackPane implements Initializable {
    private Main application;
    @FXML
    private TableView<?> ventanaPro;
    public static Cotizacion factura;
    @FXML
    private TextField cedula;
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

    @FXML
    private void eliminarProducto(ActionEvent event) {
        ventanaPro.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    private void facturarListo(ActionEvent event) {
        //ventanaPro.get
        String query = "insert into factura values (default,'"+total+"','"+cedula.getText()+"','"+Main.usuario+"','"+new Date()+"','"+cSecundaria+"');";
        String query2="insert into factura values (default,'"+total+"','"+cedula.getText()+"','"+Main.usuario+"','"+new Date()+"','"+cSecundaria+"');";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
            String q2 = "SELECT LAST_INSERT_ID() as id";
            st.executeQuery(q2);
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
    }
    
    create table detallerServicio(
	id_detalle int,
    servicio int,
    cantidad int,
    precio_venta float,
    factura int,
    primary key (id_detalle),
    foreign key (servicio) references servicio(id_servicio),
    foreign key (factura) references Factura(id_factura)
);
    
create table DetalleProducto(
	id_detalle int,
    producto int,
    cantidad int,
    precio_venta float,
    factura int,
    primary key (id_detalle),
    foreign key (producto) references Producto(id_producto),
    foreign key (factura) references Factura(id_factura)
);
    
    public int addDireccion(int mz,String slr,String ciudad,String cPrincipal, String cSecundaria){
        String query = "insert into Direccion values ( default,'"+mz+"','"+slr+"','"+ciudad+"','"+cPrincipal+"','"+cSecundaria+"');";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
            String q2 = "SELECT LAST_INSERT_ID() as id";
            ResultSet rs = st.executeQuery(q2);
            return Integer.parseInt(rs.getString("id"));
            
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
        return 0;
    }
    
    @FXML
    private void actualizar(ActionEvent event) {
    }
    
    
}
