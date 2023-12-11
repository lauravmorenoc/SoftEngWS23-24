module com.example.assignment8_architecture {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment8_architecture to javafx.fxml;
    exports com.example.assignment8_architecture;
}