public class Word {
    protected String word_target;
    protected String word_explain;
    public Word() {}

    public Word(String search, String mean) {
        word_target = search;
        word_explain = mean;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String search) {
        word_target = search;
    }

    public void setWord_explain(String mean) {
        word_explain = mean;
    }

    public int compareTo(Word other) {
        return this.searching.compareToIgnoreCase(other.searching);
    }

    public void writeWord() {
        System.out.println(word_target + " = " + word_explain);
    }
}