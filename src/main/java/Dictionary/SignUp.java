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

public class SignUp extends SignIn {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private Stage primaryStage; // You need to set this reference to the primary stage

    @FXML
    protected void navigate() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getClassLoader().getResource("View/signIn.fxml"));

            Parent root = loader.load();

            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void signUp() {
        String _usrname = usernameField.getText(); // Thay đổi tên biến từ usrname thành username
        String _pwd = passwordField.getText(); // Thay đổi tên biến từ pwd thành password

        User usr = new User();

        System.out.println(_usrname);
        System.out.println(_pwd);

        String rs = usr.signUp(_usrname, _pwd); // Gọi phương thức signUp từ đối tượng User

        if (rs.equals("Signed up successfully!")) {
            navigate(); // Gọi phương thức navigate để chuyển đến màn hình đăng nhập
        } else {
            // Xử lý tình huống khi đăng ký không thành công
            // Ví dụ: hiển thị thông báo lỗi cho người dùng
            System.out.println("Sign-up failed: " + rs);
        }
    }
}
