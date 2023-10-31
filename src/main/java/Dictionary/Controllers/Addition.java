package Dictionary.Controllers;

import Dictionary.Models.English;
import Dictionary.Models.EnglishDataAccessObject;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Addition {

    @FXML
    private TextArea exampleTextArea;

    @FXML
    private Button addButton;

    @FXML
    private TextArea newWord;

    @FXML
    private TextArea meaning;
    @FXML
    private TextArea pronunciation;
    @FXML
    private TextArea synonym;

    @FXML
    private TextArea antonym;

    private TextArea partOfSpeech;

    public void resetText() {// xóa nội dung văn bản của một số trường TextArea.
        exampleTextArea.setText("");
        meaning.setText("");
        pronunciation.setText("");
        synonym.setText("");
        antonym.setText("");
        partOfSpeech.setText("");
    }

    public void handleAdd()  {//ấy thông tin về một từ từ cơ sở dữ liệu
        String word = newWord.getText();
        if (word.isEmpty() || word.isBlank()) {
            resetText();
            return;
        }
    }


    @FXML
    protected void HandleClickBtn(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        String word = newWord.getText();
        String ex = exampleTextArea.getText();
        String mn = meaning.getText();
        String pro = pronunciation.getText();
        String sy = synonym.getText();
        String an = antonym.getText();
        String posSpeech = partOfSpeech.getText();

        if(word.isEmpty() || word.isBlank()){
            alert.setHeaderText("Adding word failed");
            alert.setContentText("Word cannot be empty, please try again");
            alert.showAndWait();
        } else if (word.trim().isEmpty() || mn.trim().isEmpty()) {
            alert.setHeaderText("Adding word failed");
            alert.setContentText("Meaning cannot be empty, please try again");
            alert.showAndWait();
        } else{
            // Thêm từ mới vào cơ sở dữ liệu ở đây (với đoạn mã đã có)
            English english = new English(word, mn, pro, posSpeech, ex, sy, an);
            if(!EnglishDataAccessObject.updateWord(english)){
                return;
            }
            alert.setTitle("App Dictionary");
            alert.setHeaderText("Adding word successfully");
            alert.setContentText("New Word: " + word + "\nExplaination: "
                    + ex + "\nPart of speech :" + "Part of speech: " + posSpeech
                    + "\nSynonym: " + sy + "\nAnonym: "+ an);
            alert.showAndWait();

        }
    }


    public void HandleClickBtn(javafx.event.ActionEvent actionEvent) {
    }
}