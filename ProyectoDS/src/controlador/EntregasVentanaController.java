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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import modelo.Entrega;

/**
 * FXML Controller class
 *
 * @author NICOLE
 */
public class EntregasVentanaController extends StackPane implements Initializable {
    private Main application;
    @FXML
    private TableView<Entrega> entrega;
    @FXML
    private TableColumn<Entrega, String> cliente;
    @FXML
    private TableColumn<Entrega, String> direccion;
    @FXML
    private TableColumn<Entrega, String> descripcion;
    @FXML
    private TableColumn<Entrega, String> repartidor;
    @FXML
    private TableColumn<Entrega, String> estado;
    private ObservableList<Entrega> data;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String query = "SELECT * FROM VEntrega;";
        String eCliente = "";
        String eDir = "";
        String eDesc = "";
        String eRepartidor = "";
        String eEstado = "";
        data = FXCollections.observableArrayList(); 
        cliente.setCellValueFactory(new PropertyValueFactory<Entrega,String>("cliente"));
        direccion.setCellValueFactory(new PropertyValueFactory<Entrega,String>("direccion"));
        descripcion.setCellValueFactory(new PropertyValueFactory<Entrega,String>("descripcion"));
        repartidor.setCellValueFactory(new PropertyValueFactory<Entrega,String>("repartidor"));
        estado.setCellValueFactory(new PropertyValueFactory<Entrega,String>("estado"));
        try{
            if(Main.cdb != null){
                Statement st = Main.cdb.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    eCliente = rs.getString("cliente");
                    eDir = rs.getString("direccion");
                    eDesc = rs.getString("tipoEntrega");
                    eRepartidor = rs.getString("nombre_usuario");
                    eEstado = rs.getString("estado");
                    Entrega e = new Entrega(eCliente,eDir,eDesc,eRepartidor,eDesc);
                    data.add(e);
                }
                entrega.setItems(data);
            }
            }catch(SQLException ex){
                
            }
            
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
    
}
