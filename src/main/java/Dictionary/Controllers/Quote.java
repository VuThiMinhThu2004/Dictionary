package Dictionary.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Quote implements Initializable {

    @FXML
    private ListView<String> listView1; // Chú ý kiểu dữ liệu trong ListView, ở đây là String

    @FXML
    private ListView<String> listView2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> sentences = FXCollections.observableArrayList();

        // Đường dẫn đến file văn bản chứa các câu
        String filePath = "D:\\Dictionary\\src\\main\\java\\Utils\\quote.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sentences.add(line); // Thêm câu vào danh sách
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        listView1.setItems(sentences);


        ObservableList<String> sens = FXCollections.observableArrayList();

        // Đường dẫn đến file văn bản chứa các câu
        filePath = "D:\\Dictionary\\src\\main\\java\\Utils\\quoteVN.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sentences.add(line); // Thêm câu vào danh sách
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        listView2.setItems(sens);
    }
}

