package Dictionary;

import Dictionary.Alerts.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignIn {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Stage primaryStage; // You need to set this reference to the primary stage

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    private void handleLoginAction() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = new User(); // Create an instance of the User class

        // Check login credentials
        String result = user.signIn(username, password);

        if (result.equals("Signed in successfully!")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("path/to/home.fxml"));
                Parent root = loader.load();

                // Access the controller for the home.fxml if needed
                // HomeController homeController = loader.getController();
                // homeController.someMethod();

                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid username or password."); // Or show an alert
        }
    }

    @FXML
    private void handleForgotPasswordAction() {
        // Implement logic for password recovery here
        System.out.println("Forgot password clicked!");
    }
}
