/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import proyectods.ProyectoDS;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class NuevoClienteVentanaController extends StackPane implements Initializable {

    private Main application;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField cedula;
    @FXML
    private TextField ciudad;
    @FXML
    private TextField mz;
    @FXML
    private TextField slr;
    @FXML
    private TextField calleP;
    @FXML
    private TextField calleS;
    @FXML
    private TextField correo;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setApp(Main application) {
        this.application = application;
    }

    @FXML
    public void backToMenu(ActionEvent event) {
        if (application == null) {
            System.out.println("F");
        } else {
            try {
                FacturarVentanaController factura = (FacturarVentanaController) application.replaceSceneContent("/vista/FacturarVentana.fxml");
                factura.setApp(this.application);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void agregarCliente(ActionEvent event) {
        int id_dir=application.db.addDireccion(Integer.parseInt(mz.getText()), slr.getText(), ciudad.getText(), calleP.getText(), calleS.getText());
        String query = "insert into Persona values ('" + cedula + "','" + nombre + "','" + apellido + "','" + id_dir + "','" + correo;
        try {
            Statement st = ProyectoDS.cdb.createStatement();
            st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("Problemas en la Query, " + e);
        }

    }

    /*private boolean validarCliente() {
        String name = null;
        String query = "call buscarCliente ('" + cedula.getText() + "','" + name + "')";
        try {
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.getString("cedula") == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Problemas en la Query, " + e);
        }
        return false;
    }

    private int validarDireccion() {

        String query = "call buscarDireccion ('" + mz.getText() + "','" + slr.getText() + "','" + ciudad.getText() + "','" + calleP.getText() + "','" + calleS.getText() + ")";
        try {
            Statement st = ProyectoDS.cdb.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs == null) {
                return application.db.addDireccion(Integer.parseInt(mz.getText()), slr.getText(), ciudad.getText(), calleP.getText(), calleS.getText());
            }
            return Integer.parseInt(rs.getString("id_direccion"));
        } catch (Exception e) {
            System.out.println("Problemas en la Query, " + e);
        }
        return 0;
    }*/

}
