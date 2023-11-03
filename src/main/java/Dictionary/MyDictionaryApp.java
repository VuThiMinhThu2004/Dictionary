package Dictionary;

import Dictionary.Models.English;
import Dictionary.Models.EnglishDataAccessObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MyDictionaryApp extends Application {
    public static Stage AppStage;
    public static final int dbSize = 0;

    public List<English> englishList;

    {
        try {
            englishList = EnglishDataAccessObject.getAllWords();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        @Override
    public void start(Stage primaryStage) throws IOException {

        try {
            // Tải giao diện từ tệp FXML
            Parent root = FXMLLoader.load(getClass().getResource("/View/DicionaryUI.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);//Stage là một cửa sổ gốc
            primaryStage.show();//cửa sổ chính của ứng dụng
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Khởi động ứng dụng
        launch();
    }
}

