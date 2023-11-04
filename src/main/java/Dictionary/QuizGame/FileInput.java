package Dictionary.QuizGame;
/** FileInput class that reads data from the given txt.file and process
 them into 6 ArrayLists(2 lists for questions and 4 Lists for possible answers).
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInput {
    static ArrayList<String> firstSet = new ArrayList<>();
    static ArrayList<String> secondSet = new ArrayList<>();
    static ArrayList<String> thirdSet = new ArrayList<>();
    static ArrayList<String> fourthSet = new ArrayList<>();
    static ArrayList<String> fifthSet = new ArrayList<>();
    static ArrayList<String> results = new ArrayList<>();
    static String object1,answer1,answer2,answer3,answer4;
    public static ArrayList<String> answers() {
        results.add("B. responsibility");
        results.add("C. the");
        results.add("C. suitable ");
        results.add("D. special dishes");
        results.add("C. became");
        results.add("D. A and B");
        results.add("A. under");
        results.add("B. mysterious");
        results.add("A. interested in");
        results.add("C. determined");
        return results;
    }


    public static ArrayList<String> objectsList1() {
        try {
            File file = new File("D:\\Dictionary\\src\\main\\java\\Dictionary\\QuizGame\\input.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                object1 = scan.nextLine();
                firstSet.add(object1);

                answer1 = scan.nextLine();
                secondSet.add(answer1);

                answer2 = scan.nextLine();
                thirdSet.add(answer2);

                answer3 = scan.nextLine();
                fourthSet.add(answer3);

                answer4 = scan.nextLine();
                fifthSet.add(answer4);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return firstSet;
    }

    public static ArrayList<String> objectsList2() {
        return secondSet;
    }
    public static ArrayList<String> objectsList3() {
        return thirdSet;
    }
    public static ArrayList<String> objectsList4() {
        return fourthSet;
    }
    public static ArrayList<String> objectsList5() {
        return fifthSet;
    }
}