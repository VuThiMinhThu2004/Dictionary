package Dictionary.Controllers;

import Utils.DB;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginCon implements Initializable {

    @FXML
    private Button Login;

    @FXML
    private Hyperlink forgot_pw;

    @FXML
    private Hyperlink no_acc;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private Label label_welcome;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DB.logInUser(event, usernameField.getText(), passwordField.getText());
            }
        });

        no_acc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DB.changeScene(event, "/View/SignUp.fxml", "Sign Up!", null);
            }
        });
    }

    public void setUserInformation(String username) {
        label_welcome.setText("Welcome " + username + "!");
    }
    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Thực hiện xác thực tên người dùng và mật khẩu
        // Ví dụ: Kiểm tra xem tên người dùng và mật khẩu có đúng hay không
        if (username.equals("admin") && password.equals("password")) {
            // Nếu đúng, hiển thị thông báo đăng nhập thành công
            showAlert("Login Successful", "Welcome, " + username + "!");
        } else {
            // Nếu sai, hiển thị thông báo lỗi đăng nhập
            showAlert("Login Failed", "Invalid username or password.");
        }
    }

    @FXML
    private void handleNoAccount(ActionEvent event) {
        // Xử lý sự kiện khi người dùng nhấn vào liên kết "No account?"
        showAlert("No Account", "Redirect to create account page...");
        // Điều hướng sang trang tạo tài khoản (có thể thêm mã điều hướng ở đây)
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


}
