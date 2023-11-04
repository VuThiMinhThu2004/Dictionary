package Dictionary.QuizGame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;
import java.sql.Timestamp;

public class MainController implements Initializable {
    @FXML
    TableView <Player> playerTable;
    @FXML
    TableColumn<Player,String> column1;
    @FXML
    TableColumn<Player, Integer> column2;

    @FXML
    Label object1;
    @FXML
    Label clock;
    @FXML
    Label nameArea;
    @FXML
    Label point;
    @FXML
    Label end;
    @FXML
    Label table;
    @FXML
    Label question;
    @FXML
    Text timestamps;
    @FXML
    TextField player;
    @FXML
    Button choice1,choice2,choice3,choice4,generateReport;


    static Timestamp timestamp;
    static Date date;
    static ObservableList<Player> listP;
    static ObservableList<Player> listSorted;
    static Stack<String> timeStack = new Stack<>();
    static int j = 0;
    static int k = 1;
    public static boolean isTheAnswer(String sss, ArrayList<String> someList) {
        boolean answer = false;
        for(String w : someList){
            if (sss.equals(w)) {
                answer = true;
                break;
            }
        }
        return answer;
    }

    @FXML
    public void checkResult1(){
        setAnswer(choice1);
    }
    @FXML
    public void checkResult2(){ setAnswer(choice2); }
    @FXML
    public void checkResult3() { setAnswer(choice3); }
    @FXML
    public void checkResult4() { setAnswer(choice4); }

    /** Method that starts the Thread */

    @FXML
    public void startThread(){
        nameArea.setText("Player: " + player.getText());
        player.setDisable(true);
        MyThread th = new MyThread(object1,clock,choice1,choice2,choice3,choice4,generateReport,timestamps,end,point,player,question);
        Thread t1 = new Thread(th);
        t1.start();
    }
    /** Method that generates ranking list and output results into a file */

    @FXML
    public void showResults() throws FileNotFoundException {
        playerTable.setVisible(true);
        object1.setVisible(false);
        question.setVisible(false);
        end.setVisible(false);
        choice1.setVisible(false);
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
//        gr.setVisible(false);
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory<>("point"));
        listP = DBUtils.findAllPeople();
        listP.sort(new CompareScore());
        listSorted = FXCollections.observableArrayList();
        if (listP.size() >=10){
            for(int j=0;j<10;j++){
                listSorted.add(listP.get(j));
            }
        }
        else {
            listSorted.addAll(listP);
        }
        playerTable.setItems(listSorted);

        FileOutputStream fs = new FileOutputStream("C:\\Users\\ADMIN\\Sophomore\\OOP\\Dictionary\\src\\main\\java\\Dictionary\\QuizGame\\output.txt");
        PrintWriter pw = new PrintWriter(fs);
        pw.println(listSorted);
        pw.close();
    }
    /** Method that checks the selected answer and stores points and timestamps into a stack list */
    private void setAnswer(Button b) {
        if (isTheAnswer(b.getText(), FileInput.answers())) {
            j++;
            point.setText("" + j);
            choice1.setDisable(true);
            choice2.setDisable(true);
            choice3.setDisable(true);
            choice4.setDisable(true);
            date = new Date();
            timestamp = new Timestamp(date.getTime());
            String temp = timestamp + "\nQuestion " + k + "  " + 1 + " point";
            timeStack.push(temp);
        } else {
            choice1.setDisable(true);
            choice2.setDisable(true);
            choice3.setDisable(true);
            choice4.setDisable(true);
            date = new Date();
            timestamp = new Timestamp(date.getTime());
            String temp = timestamp + "\nQuestion " + k + "  " + 0 + " points";
            timeStack.push(temp);
        }
        k++;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        end.setVisible(false);
        generateReport.setDisable(true);
        timestamps.setText("");
        player.setEditable(true);
        player.requestFocus();
        playerTable.setVisible(false);
    }
}