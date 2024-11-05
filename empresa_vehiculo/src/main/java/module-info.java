module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo to javafx.fxml;
    opens co.edu.uniquindio.poo.viewController to javafx.fxml;
    exports co.edu.uniquindio.poo.App;
    exports co.edu.uniquindio.poo.viewController;
}
