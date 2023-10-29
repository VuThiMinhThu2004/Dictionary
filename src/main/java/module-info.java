module com.example.dictionary {
    requires javafx.controls;
    requires javafx.fxml;
    requires ormlite.jdbc;
    requires java.sql;


    opens com.example.dictionary to javafx.fxml;
    exports com.example.dictionary;

    exports Dictionary.Controllers to javafx.fxml;
}