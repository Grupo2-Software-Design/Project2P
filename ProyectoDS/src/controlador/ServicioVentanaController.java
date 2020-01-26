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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import modelo.Cliente;
import modelo.Mascota;
import modelo.Producto;
import modelo.Servicio;
import modelo.Venta;
import proyectods.ProyectoDS;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class ServicioVentanaController extends StackPane implements Initializable {

    private Main application;
    @FXML
    private ComboBox<String> combobox;
    @FXML
    private TextField txtFieldBuscar;
    private List<Servicio> servicio = new LinkedList<>();
    private List<Mascota> mascotas = new LinkedList<>();
    @FXML
    private Button btnBuscar;
    @FXML
    private ComboBox<Mascota> comboboxMascota;
    @FXML
    private Button btnColocar;
    @FXML
    private TableView<Servicio> tabla;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        combobox.getItems().removeAll();
        combobox.getItems().addAll("Nombre", "Categoria", "Descripción");
        String q = "SELECT * FROM Mascota where " + FacturarVentanaController.cliente.getCedula() + " = dueño and estado = 1;";
        try {
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(q);
            while (rs.next()) {
                String nombreM = rs.getString("nombre");
                String raza = rs.getString("raza");
                int edad = Integer.parseInt(rs.getString("edad"));
                float peso = Float.parseFloat(rs.getString("peso"));
                float altura = Float.parseFloat(rs.getString("altura"));
                String tipo = rs.getString("tipo");
                String dueño = rs.getString("dueño");
                String tamaño = rs.getString("tamaño");
                //Cliente owner, String nombre, String raza, int edad, float peso, float altura, String tipo, String size
                Mascota pet = new Mascota(FacturarVentanaController.cliente,nombreM,raza,edad,peso,altura,tipo,tamaño);
                mascotas.add(pet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoVentanaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        comboboxMascota.getItems().addAll(mascota);
        // TODO
    }

    @FXML
    private void backToMenu(ActionEvent event) {
        if (application == null) {
            System.out.println("F");
        } else {
            try {
                FacturarVentanaController clientes = (FacturarVentanaController) application.replaceSceneContent("/vista/FacturarVentana.fxml");
                clientes.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setApp(Main application) {
        this.application = application;
    }

    @FXML
    public void gotoNuevaMascota(ActionEvent event) {
        if (application == null) {
            System.out.println("F");
        } else {
            try {
                NuevaMascotaController nMascota = (NuevaMascotaController) application.replaceSceneContent("/vista/NuevaMascota.fxml");
                nMascota.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void searchServicio(ActionEvent event) {
        String query = "SELECT * FROM Servicio where" + combobox.getValue() + "like \"%{$" + txtFieldBuscar.getText() + "}%\" estado = 1;";
        try {
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                float precio = Float.parseFloat(rs.getString("precio"));
                Servicio prd = new Servicio(Integer.parseInt(rs.getString("id_producto")),rs.getString("nombre"),rs.getString("descripcion"),precio);
                servicio.add(prd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoVentanaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabla.setItems((ObservableList<Servicio>) servicio);
        txtFieldBuscar.setText(null);
    }

    @FXML
    private void addServicio(ActionEvent event) {
        Servicio servicio = tabla.getSelectionModel().getSelectedItem();
        Venta vt = new Venta(1,servicio,"Factura");
        FacturarVentanaController.factura.getVentas().add(vt);
    }
}
