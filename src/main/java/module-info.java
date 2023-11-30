module com.example.calculator_calidad_test {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.example.calculator_calidad_test to javafx.fxml;
    exports com.example.calculator_calidad_test;
}