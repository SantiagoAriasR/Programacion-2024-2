package co.edu.uniquindio.poo.viewController;

/**
 * Sample Skeleton for 'PantallaInicio.fxml' Controller Class
 */

 import java.net.URL;
 import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App.App;
import javafx.fxml.FXML;
 import javafx.scene.control.Button;
 
 public class PantallaInicioViewController {
 
     @FXML // ResourceBundle that was given to the FXMLLoader
     private ResourceBundle resources;
 
     App app;
     @FXML // URL location of the FXML file that was given to the FXMLLoader
     private URL location;
 
     @FXML // fx:id="btnIniciar"
     private Button btnIniciar; // Value injected by FXMLLoader
 
     @FXML
     void iniciarGestionAction() {
        app.iniciarGestionAction();
     }

     public void setApp(App app){
        this.app = app;
     }
 
     @FXML // This method is called by the FXMLLoader when initialization is complete
     void initialize() {
         assert btnIniciar != null : "fx:id=\"btnIniciar\" was not injected: check your FXML file 'PantallaInicio.fxml'.";
 
     }
 }
 
