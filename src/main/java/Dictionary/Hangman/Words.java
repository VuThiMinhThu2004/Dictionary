package Dictionary.Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Words{

    private ArrayList<String> words;
    private String[] letters;


    public Words() throws FileNotFoundException {
        words = new ArrayList<>();
        Scanner sc = new Scanner(new File("D:\\Dictionary\\src\\main\\java\\Dictionary\\Hangman\\Words.txt"));
        while(sc.hasNextLine()) words.add(sc.nextLine());
    }

    public String getRandomWord(){
        return words.get(new Random().nextInt(words.size())).toUpperCase();
    }
}