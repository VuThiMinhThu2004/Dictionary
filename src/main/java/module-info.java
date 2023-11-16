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
    requires httpclient;
    requires httpcore;
    requires json;

    requires javafx.swing;

    opens com.example.dictionary to javafx.fxml;
    exports com.example.dictionary;

    opens Dictionary.Models;
    opens Dictionary.Controllers;

    exports Dictionary.QuizGame;
    exports Dictionary.Hangman;

    exports Dictionary to javafx.graphics;

    opens Dictionary.QuizGame;
    exports Dictionary.Controllers to javafx.fxml;

    opens Dictionary.Hangman;
    opens Dictionary.CrossWord;
    exports Dictionary.CrossWord;
}
