package Dictionary.Controllers;

import Utils.DB;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpCon implements Initializable {
    @FXML
    private Icon exit;

    @FXML
    private Text label;

    @FXML
    private Hyperlink login;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signup;

    @FXML
    private TextField usernameField;
    @Override
    public void initialize(URL location, ResourceBundle resource) {
        signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!usernameField.getText().trim().isEmpty() && !passwordField.getText().trim().isEmpty()) {
                    DB.signUpUser(event, usernameField.getText(), passwordField.getText());
                } else {
                    System.out.println("Please fill in all information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information to sign up!");
                    alert.show();
                }
            }
        });
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DB.changeScene(event, "/View/SignIn.fxml", "Log In!", null);
            }
        });

    }
}
