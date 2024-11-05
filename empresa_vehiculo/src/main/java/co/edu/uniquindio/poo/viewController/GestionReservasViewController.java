package co.edu.uniquindio.poo.viewController;
/**
* Sample Skeleton for 'GestionReservas.fxml' Controller Class
*/

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App.App;
import co.edu.uniquindio.poo.controller.ReservasController;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.TipoCaja;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionReservasViewController {
    // Iniciamos el controlador
    ReservasController reservasController;

    // Crear la lista de la tabla
    ObservableList<Reserva> listaReservas = FXCollections.observableArrayList();
    Reserva selectedReserva;

   @FXML // ResourceBundle that was given to the FXMLLoader
   private ResourceBundle resources;

   @FXML // URL location of the FXML file that was given to the FXMLLoader
   private URL location;

   @FXML // fx:id="txtFechaFinal"
   private TextField txtFechaFinal; // Value injected by FXMLLoader

   @FXML // fx:id="tbcVehiculo"
   private TableColumn<Reserva, String> tbcVehiculo; // Value injected by FXMLLoader

   @FXML // fx:id="btnLimpiar"
   private Button btnLimpiar; // Value injected by FXMLLoader

   @FXML // fx:id="tbcPrecioReserva"
   private TableColumn<Reserva, String> tbcPrecioReserva; // Value injected by FXMLLoader

   @FXML // fx:id="tblListReservas"
   private TableView<Reserva> tblListReservas; // Value injected by FXMLLoader

   @FXML // fx:id="vehiculoChoiceBox"
   private ChoiceBox<Vehiculo> vehiculoChoiceBox; // Value injected by FXMLLoader

   @FXML // fx:id="ClienteChoiceBox"
   private ChoiceBox<Cliente> ClienteChoiceBox; // Value injected by FXMLLoader

   @FXML // fx:id="btnActualizarReserva"
   private Button btnActualizarReserva; // Value injected by FXMLLoader

   @FXML // fx:id="tbcFechaInicio"
   private TableColumn<Reserva, String> tbcFechaInicio; // Value injected by FXMLLoader

   @FXML // fx:id="btnEliminar"
   private Button btnEliminar; // Value injected by FXMLLoader

   @FXML // fx:id="tbcCliente"
   private TableColumn<Reserva, String> tbcCliente; // Value injected by FXMLLoader

   @FXML // fx:id="btnAgregarReserva"
   private Button btnAgregarReserva; // Value injected by FXMLLoader

   @FXML // fx:id="txtFechaInicio"
   private TextField txtFechaInicio; // Value injected by FXMLLoader

   @FXML // fx:id="tbcFechaFinal"
   private TableColumn<Reserva, String> tbcFechaFinal; // Value injected by FXMLLoader
   private App app;

   @FXML
   void onAgregarReserva(ActionEvent event) {
        agregarReserva();
   }

   @FXML
   void onActualizarReserva(ActionEvent event) {
        actualizarReserva();
   }

   @FXML
   void onLimpiar(ActionEvent event) {
        limpiarSeleccion();
   }

   @FXML
   void onEliminar(ActionEvent event) {
        eliminarReserva();
   }

   @FXML // This method is called by the FXMLLoader when initialization is complete
   void initialize() {
        // Verificación de que los elementos se han inyectado correctamente
       assert txtFechaFinal != null : "fx:id=\"txtFechaFinal\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert tbcVehiculo != null : "fx:id=\"tbcVehiculo\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert btnLimpiar != null : "fx:id=\"btnLimpiar\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert tbcPrecioReserva != null : "fx:id=\"tbcPrecioReserva\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert tblListReservas != null : "fx:id=\"tblListReservas\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert vehiculoChoiceBox != null : "fx:id=\"vehiculoChoiceBox\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert ClienteChoiceBox != null : "fx:id=\"ClienteChoiceBox\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert btnActualizarReserva != null : "fx:id=\"btnActualizarReserva\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert tbcFechaInicio != null : "fx:id=\"tbcFechaInicio\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert tbcCliente != null : "fx:id=\"tbcCliente\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert btnAgregarReserva != null : "fx:id=\"btnAgregarReserva\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert txtFechaInicio != null : "fx:id=\"txtFechaInicio\" was not injected: check your FXML file 'GestionReservas.fxml'.";
       assert tbcFechaFinal != null : "fx:id=\"tbcFechaFinal\" was not injected: check your FXML file 'GestionReservas.fxml'.";
        // Lógica adicional a la hora de inicializar para mejorar legibilidad, flexibilidad...(initView)
        reservasController = new ReservasController(app.empresa);
        inicializarData();
        initView();
   }

   // Metodo para agregar los datos quemados a nuestros ChoiceBox
   public void inicializarData(){
    
    // Creamos nuestros vehiculos quemados
        Auto auto = new Auto("CYQ328", "Renult", "Clio", "2019", 4);
        Moto moto = new Moto("CK123T", "Honda", "modelo1", "2020", TipoCaja.AUTOMATICO);
        Camioneta camioneta = new Camioneta("JKD481", "Ferrari", "Urus", "2023", 3);
    // Los colocamos en nuestro ChoiceBox de vehiculos
    vehiculoChoiceBox.setItems(FXCollections.observableArrayList(
        auto,moto,camioneta
    ));

    // Creamos nuestros clientes quemados
        Cliente cliente = new Cliente("Santiago", "1092852765");
        Cliente cliente2 = new Cliente("Mariana", "1092852987");
        Cliente cliente3 = new Cliente("David", "41937876");
    // Los colocamos en nuestro ChoiceBox de Clientes
    ClienteChoiceBox.setItems(FXCollections.observableArrayList(
        cliente,cliente2,cliente3
    ));
   }

   private void initView() {
    // Traer los datos de la reserva a la tabla
    initDataBinding();

    // Obtiene la lista
    obtenerReserva();

    // Limpiar la tabla
    tblListReservas.getItems().clear();

    // Agregar los elementos a la tabla
    tblListReservas.setItems(listaReservas);

    // Seleccionar elemento de la tabla
    listenerSelection();
    }

    // Configuración de la tabla (celdas,filas,tipo de datos...)
    private void initDataBinding() {
        tbcFechaInicio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaInicial().toString()));
        tbcFechaFinal.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaFinal().toString()));
        tbcCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().toString()));
        tbcVehiculo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVehiculo().toString()));
        tbcPrecioReserva.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecio())));
        // Usamos SimpleObjectProperty para manejar Double y Integer correctamente
    }

    // Definimos nuestras funciones para el manejo de la interfaz
        // Función para obtener las reservas
        private void obtenerReserva(){
            listaReservas.addAll(reservasController.obtenerListaReservas());
        }

        // Función para seleccionar elementos de la tabla (Escuchado ó Listener)
        public void listenerSelection(){
            tblListReservas.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)-> {
                selectedReserva = newSelection;
                mostrarInformacionReserva(selectedReserva);
            });;
        }

        // Función para mostrar información en los elementos una vez seleccionado uno de la tabla
        private void mostrarInformacionReserva(Reserva reserva) {
            if (reserva != null){
                txtFechaInicio.setText(reserva.getFechaInicial().toString());
                txtFechaFinal.setText(reserva.getFechaFinal().toString());
                vehiculoChoiceBox.setValue(reserva.getVehiculo());
                ClienteChoiceBox.setValue(reserva.getCliente());
            }
        }

        // Funcion agregar Reserva a la tabla
        private void agregarReserva(){
            Reserva reserva = buildReserva();
            if (reservasController.crearReserva(reserva)){
                listaReservas.add(reserva);
                limpiarCamposReserva();
            }
        }

        // Funcion para crear la nueva reserva(build)
        private Reserva buildReserva(){
            // Convierte el texto a LocalDate
            LocalDate fechaInicio = LocalDate.parse(txtFechaInicio.getText());
            LocalDate fechaFinal = LocalDate.parse(txtFechaFinal.getText());
            
            Reserva reserva = new Reserva(fechaInicio,fechaFinal, vehiculoChoiceBox.getValue(), ClienteChoiceBox.getValue());
            return reserva;
        }

        // Funcion para elimiar Reserva de la tabla
        public void eliminarReserva(){
            if (reservasController.eliminarReserva(LocalDate.parse(txtFechaInicio.getText()))){
                listaReservas.remove(selectedReserva);
                limpiarCamposReserva();
                limpiarSeleccion();
            }
        }

        // Funcion para actualizar Reserva
        private void actualizarReserva(){
            if (selectedReserva != null &&
                        reservasController.actualizarReserva(selectedReserva.getFechaInicial(),buildReserva())){
                            
                            int index = listaReservas.indexOf(selectedReserva);
                            if (index >= 0){
                                listaReservas.set(index, buildReserva());
                            }

                            tblListReservas.refresh();
                            limpiarSeleccion();
                            limpiarCamposReserva();
                        }
        }
        // Función para limpiar la selección
        private void limpiarSeleccion(){
            tblListReservas.getSelectionModel().clearSelection();
            limpiarCamposReserva();
        }

        // Función limpiar campos reserva
        private void limpiarCamposReserva(){
            txtFechaInicio.clear();
            txtFechaFinal.clear();
            vehiculoChoiceBox.setValue(null);
            ClienteChoiceBox.setValue(null);
        }

        // Función para el poder instancia sobre app 
        public void setApp(App app){
            this.app = app;
        }
}

