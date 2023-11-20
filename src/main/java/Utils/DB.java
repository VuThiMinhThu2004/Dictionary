package Utils;

import Dictionary.Controllers.LoginCon;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;


public class DB {
    public static void changeScene(ActionEvent event, String fxmlFile, String title,
                                   String username) {
        Parent root = null;

        if (username != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DB.class.getResource(fxmlFile));
                root = loader.load();
                LoginCon loginCon = loader.getController();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DB.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 1000, 750));
        stage.show();
    }

    public static void signUpUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usersignup", "root", "");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
                psInsert.setString(1, username);
                psInsert.setString(2, password);
                psInsert.executeUpdate();

                changeScene(event, "/View/SignIn.fxml", "Welcome!", username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInUser(ActionEvent event, String username, String password) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usersignup", "root", "");
            preparedStatement = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Người dùng tồn tại và mật khẩu đúng
                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(DB.class.getResource("/View/DictionaryUI.fxml")));
                    Scene scene = new Scene(root);

                    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    currentStage.setScene(scene);
                    currentStage.setTitle("Welcome!");
                    currentStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid username or password");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("The provided credentials are incorrect!");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tài nguyên
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}