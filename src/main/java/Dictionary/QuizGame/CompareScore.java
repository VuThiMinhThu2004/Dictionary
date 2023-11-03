package Dictionary.QuizGame;

import java.util.Comparator;
/** Method that compares Players by their score */
public class CompareScore implements Comparator<Player> {


    @Override
    public int compare(Player player1, Player player2) {
        return -(player1.getPoint() - player2.getPoint());
    }
}