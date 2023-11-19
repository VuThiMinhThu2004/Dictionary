package Dictionary.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginCon{

    @FXML
    private Button Login;

    @FXML
    private Hyperlink no_acc;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    private void initialize() {
        // Khởi tạo controller (có thể thực hiện các công việc chuẩn bị ở đây)
        // Ví dụ: thiết lập các giá trị mặc định hoặc khởi động các thành phần
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
