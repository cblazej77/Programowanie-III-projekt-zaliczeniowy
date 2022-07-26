module com.example.zaliczenieklient2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zaliczenieklient2 to javafx.fxml;
    exports com.example.zaliczenieklient2;
}