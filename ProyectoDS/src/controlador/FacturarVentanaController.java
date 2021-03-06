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
import modelo.Empleado;
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

    @FXML
    private void facturarListo(ActionEvent event) {
        searchCliente(cedula.getText());
        Empleado em=getEmpleado();
        String query ="insert into Factura values ("+factura.getNumFactura()+","+factura.sumTotal()+","+cliente.getCedula()+em.getCedula()+","+new Date()+","+factura.sumTotal()+");";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
            String q2;
            for(Venta v:factura.getVentas()){
                if(v.getProducto()!=null){
                    q2 = "insert into DetalleProducto values ("+v.getId()+","+v.getProducto().getId()+","+v.getCantidad()+","+v.getPvUnidad()+","+factura.getNumFactura()+",null);";
                }else{
                    q2 = "insert into DetallerServicio values ("+v.getId()+","+v.getServicio().getId()+","+v.getCantidad()+","+v.getPvUnidad()+","+factura.getNumFactura()+",null);";
                }
                st = ProyectoDS.cdb.createStatement();
                st.executeQuery(q2);
            }
            clear();
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
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
   
    private Empleado getEmpleado(){
        String query = "SELECT * FROM Empleado where nombre_usuario = "+application.getUser().getUsername()+";";
        try{
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(query);
            return new Empleado(rs.getString("cedula"),rs.getNString("nombre"),rs.getString("apellido"),rs.getString("telefono"),application.getUser(),rs.getString("tipo_empleado"),null);
          
        }
        catch(Exception e){
            System.out.println("Problemas en la Query, "+e);
        }
        return null;
    }
    
    private void clear(){
        id.getColumns().removeAll(id.getColumns());
        tipo.getColumns().removeAll(tipo.getColumns());
        nombre.getColumns().removeAll(nombre.getColumns());
        canti.getColumns().removeAll(canti.getColumns());
    }
    
}
