package Dictionary.QuizGame;

/**
 * Project Name: Quiz Game
 * COP 3330C Object Oriented Programming
 * written by: @author Nenad Jovanovic (njovanovic1@mail.valenciacollege.edu)
 * created: 12/5/22
 */

/** Thread Class */

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class MyThread implements Runnable {
    Label ob1,clock,end,points,question;
    Button bt1,bt2,bt3,bt4,report;
    Text time;
    TextField player;

    public MyThread(Label l1, Label l2, Button butt1, Button butt2, Button butt3, Button butt4, Button report, Text t, Label endGame, Label point, TextField player,Label q){
        ob1 = l1;
        clock = l2;
        bt1 = butt1;
        bt2 = butt2;
        bt3 = butt3;
        bt4 = butt4;
        this.report = report;
        time = t;
        end = endGame;
        points = point;
        this.player = player;
        this.question = q;
    }
    /** Run Method that
     * changes questions and answers
     * moves countdown clock
     * adds timestamps
     * stores players and theirs scores into a MySQL database
     */

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int finalI = i;

                Platform.runLater(() -> {
                    question.setText("Question " + (finalI +1)+"/10");
                    bt1.setDisable(false);
                    bt2.setDisable(false);
                    bt3.setDisable(false);
                    bt4.setDisable(false);
                    ob1.setText(FileInput.objectsList1().get(finalI));
                    bt1.setText(FileInput.objectsList2().get(finalI));
                    bt2.setText(FileInput.objectsList3().get(finalI));
                    bt3.setText(FileInput.objectsList4().get(finalI));
                    bt4.setText(FileInput.objectsList5().get(finalI));
                });

                Platform.runLater(() -> clock.setText("10"));
                Thread.sleep(1000);
                Platform.runLater(() -> clock.setText("9"));
                Thread.sleep(1000);
                Platform.runLater(() -> clock.setText("8"));
                Thread.sleep(1000);
                Platform.runLater(() -> clock.setText("7"));
                Thread.sleep(1000);
                Platform.runLater(() -> clock.setText("6"));
                Thread.sleep(1000);
                Platform.runLater(() -> clock.setText("5"));
                Thread.sleep(1000);
                Platform.runLater(() -> clock.setText("4"));
                Thread.sleep(1000);
                Platform.runLater(() -> clock.setText("3"));
                Thread.sleep(1000);
                Platform.runLater(() -> clock.setText("2"));
                Thread.sleep(1000);
                Platform.runLater(() -> clock.setText("1"));
                Thread.sleep(1000);
                Platform.runLater(() -> {
                    clock.setText("0");
                    bt1.setDisable(true);
                    bt2.setDisable(true);
                    bt3.setDisable(true);
                    bt4.setDisable(true);
                });
            }
            Platform.runLater(() ->end.setVisible(true));
            DBUtils.addPlayer(player.getText(),Integer.parseInt(points.getText()));
            Platform.runLater(() -> report.setDisable(false));
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        Platform.runLater(() -> {
            String current = "";
            while(!MainController.timeStack.isEmpty()){
                current += MainController.timeStack.pop() + "\n";
            }
            time.setText(current);});
    }
}