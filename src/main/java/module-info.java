module com.example.supermarket3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supermarket3 to javafx.fxml, javafx.base;
    exports com.example.supermarket3;
    exports com.example.supermarket3.control;
    opens com.example.supermarket3.control to javafx.fxml;
    opens com.example.supermarket3.Model to javafx.base;
}