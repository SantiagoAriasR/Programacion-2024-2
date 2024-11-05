package co.edu.uniquindio.poo.App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.viewController.GestionReservasViewController;
import co.edu.uniquindio.poo.viewController.PantallaInicioViewController;


public class App extends Application{

    // Creamos el objeto Empresa ya que se instancia una sola vez
    private Stage primaryStage;
    public static Empresa empresa = new Empresa("Uniquinio");

    
    // Metodo start (Sacado de la practica)
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Gestion de Reservas");
        openViewPrincipal();
    }

    // Open View principal (Sacado de la practica)
    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/PantallaInicio.fxml"));
            javafx.scene.layout.AnchorPane rootLayout = (javafx.scene.layout.AnchorPane) loader.load();
            PantallaInicioViewController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Main (Sacado de la practica)
    public static void main(String[] args) {
        launch();
    }

    // Función con el que cambiamos de activity con el botón (Basado en ejemplo de la practica)
    public void iniciarGestionAction(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("/co/edu/uniquindio/poo/GestionReservas.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            GestionReservasViewController gestionReservasViewController = loader.getController();
            gestionReservasViewController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    // Metodo inicializar data (Sacado de la practica)
     public void inicializarData(){  
    }
}
