module com.example.dictionary {
    requires javafx.controls;
    requires javafx.fxml;
    requires ormlite.jdbc;
    requires java.sql;
    requires java.desktop;
    requires org.apache.commons.csv;

    requires gson;
    requires java.scripting;
    requires jlayer;


    requires javafx.graphics;

    opens com.example.dictionary to javafx.fxml;
    exports com.example.dictionary;

    opens Dictionary.Models;
    opens Dictionary.Controllers;

    exports Dictionary.QuizGame;

    opens Dictionary.QuizGame;
    exports Dictionary.Controllers to javafx.fxml;

}
