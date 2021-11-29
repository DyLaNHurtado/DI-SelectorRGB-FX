module com.example.rgbselectorfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rgbselectorfx to javafx.fxml;
    exports com.example.rgbselectorfx;
}