module com.example.dictionary {
    requires javafx.controls;
    requires javafx.fxml;
    requires ormlite.jdbc;
    requires java.sql;
    requires java.desktop;


    opens com.example.dictionary to javafx.fxml;
    exports com.example.dictionary;

    opens Models;

    exports Dictionary.Controllers to javafx.fxml;
}