import java.util.ArrayList;

public class Dictionary {
    public static ArrayList<Word> listVocab = new ArrayList<>();

    public Word get(int index) {
        return listVocab.get(index);
    }

    public int length() {
        return listVocab.length();
    }

    public ArrayList<Word> getDictionaryArray() {
        return listVocab;
    }

    public void add(Word wordInput) {
        dictionaryArray.add(wordInput);
    }

    public void remove(int index) {
        listVocab.remove(index);
    }
}