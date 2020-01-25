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
import modelo.Mascota;
import modelo.Servicio;
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
    private List<Servicio> productos = new LinkedList<>();
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
                float stk = Float.parseFloat(rs.getString("stock"));
                float prvM = Float.parseFloat(rs.getString("precio_porMayor"));
                float prvI = Float.parseFloat(rs.getString("precio_individual"));
                Servicio prd = new Servicio(rs.getString("nombre"), stk, prvI, prvM, rs.getString("categoria"), rs.getString("descripcion"));
                prd.setId(rs.getString("id_producto"));
                productos.add(prd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoVentanaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabla.setItems((ObservableList<Servicio>) productos);
        txtFieldBuscar.setText(null);
    }

    @FXML
    private void addMascota(ActionEvent event) {
    }
}
