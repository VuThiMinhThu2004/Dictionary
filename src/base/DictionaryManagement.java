import java.util.*;

public class DictionaryManagement extends Dictionary {
    /*chua co data*/
    private static final String IN_PATH = "dictionaries.txt";
    private static final String OUT_PATH = "dictionaries_out.txt";
    /*
    Nhập vào bàn phím số lượng từ vựng (Word).
    ● Định dạng nhập dữ liệu từ điển Anh – Việt:
    ○ Dòng 1: Nhập từ tiếng Anh.
    ○ Dòng 2: Nhập giải thích bằng tiếng Việt.
     */
    public void insertFromCommandline() {
        Scanner getIntegerInput = new Scanner(System.in);
        Scanner getStringInput = new Scanner(System.in);

        int size = getIntegerInput.nextInt();
        int pos = 0;

        while (pos < size) {
            String wordEng = getStringInput.nextLine();
            String mean = getStringInput.nextLine();

            listVocab.add(new Word(wordEng, mean));
            ++pos;
        }
    }

    public void dictionaryLookup() {

    }
}