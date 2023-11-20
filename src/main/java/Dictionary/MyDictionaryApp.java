package Dictionary;

import Dictionary.Models.English;
import Dictionary.Models.EnglishDataAccessObject;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MyDictionaryApp extends Application {
    public static Stage AppStage;
    public static final int dbSize;

    static {
        try {
            dbSize = EnglishDataAccessObject.getAllWords().size();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static final List<English> englishList;

    static {
        try {
            englishList = EnglishDataAccessObject.getAllWords();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Map<String, String> WordMapMean = new HashMap<>();
    public static Map<String, String> MeanMapWord = new HashMap<>();

    public MyDictionaryApp() throws SQLException {

    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/View/SignIn.fxml")));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            AppStage = primaryStage;
            primaryStage.setOnCloseRequest(e -> {
                Platform.exit();
                System.exit(0);
            });
            for(English english : englishList) {
                WordMapMean.put(english.getWord(), english.getMeaning());
                MeanMapWord.put(english.getMeaning(), english.getWord());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}

