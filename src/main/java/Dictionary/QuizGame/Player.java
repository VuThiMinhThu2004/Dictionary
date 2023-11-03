package Dictionary.QuizGame;

/**
 * Project Name: Quiz Game
 * COP 3330C Object Oriented Programming
 * written by: @author Nenad Jovanovic (njovanovic1@mail.valenciacollege.edu)
 * created: 12/5/22
 */
/** Player Object Class to store results into DB */

public class Player {
    String name;
    int point;

    public Player(String name, int point){
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String toString(){
        return name + " " + point;
    }
}