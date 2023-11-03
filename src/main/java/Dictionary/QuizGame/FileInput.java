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
    static ArrayList<String> sixthSet = new ArrayList<>();
    static ArrayList<String> results = new ArrayList<>();
    static String object1,object2,answer1,answer2,answer3,answer4;
    public static ArrayList<String> answers() {
        results.add("9.0");
        results.add("9.0");
        results.add("MickeyMouse");
        results.add("ca");
        results.add("16");
        results.add("8.1f");
        results.add("JavaProgram");
        results.add("6.3f");
        results.add("MaryLamb");
        results.add("11");
        return results;
    }


    public static ArrayList<String> objectsList1() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                object1 = scan.next();
                firstSet.add(object1);
                scan.next();
                scan.nextLine();
                scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return firstSet;
    }

    public static ArrayList<String> objectsList2() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                scan.next();
                object2 = scan.next();
                secondSet.add(object2);
                scan.next();
                scan.nextLine();

            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return secondSet;
    }
    public static ArrayList<String> objectsList3() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                scan.nextLine();
                answer1 = scan.next();
                thirdSet.add(answer1);
                scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return thirdSet;
    }
    public static ArrayList<String> objectsList4() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                scan.nextLine();
                scan.next();
                answer2 = scan.next();
                fourthSet.add(answer2);
                scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fourthSet;
    }
    public static ArrayList<String> objectsList5() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                scan.nextLine();
                scan.next();
                scan.next();
                answer3 = scan.next();
                fifthSet.add(answer3);
                scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fifthSet;
    }
    public static ArrayList<String> objectsList6() {
        try {
            File file = new File("C:\\input.txt");
            Scanner scan = new Scanner(file);
            for(int i = 0; i < 10; i++) {
                scan.nextLine();
                scan.next();
                scan.next();
                scan.next();
                answer4 = scan.next();
                sixthSet.add(answer4);
                scan.nextLine();
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sixthSet;
    }

}