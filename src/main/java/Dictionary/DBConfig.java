package Dictionary;

import Dictionary.Models.English;
import Dictionary.Models.EnglishDataAccessObject;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConfig {
    private static final String DATABASE_URL = "jdbc:sqlite:engData.db";
    public static ConnectionSource connectionSource;

    static {
        try {
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static EnglishDataAccessObject englishDAO;

    static {
        try {
            englishDAO = new EnglishDataAccessObject(connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        /*
        TableUtils: create table in db
         */
        TableUtils.createTableIfNotExists(connectionSource, English.class);
        Data();//nap db
        //NormalizeType();
    }
    public static void NormalizeType() throws SQLException {
        EnglishDataAccessObject word = new EnglishDataAccessObject();

        var EnglishWords = word.getAllWords();
        for(var x : EnglishWords){
            word.changeType(x.getWord());
        }
    }

    public static void Data() throws SQLException {
        String csvFile = "src/main/resources/englishDictionary.csv";
        List<English> englishList = parseEnglish(csvFile);
        for (English english : englishList) {
            englishDAO.updateWord(english);
        }
    }

    public static List<English> parseEnglish(String csvFile) {
        List<English> englishList = new ArrayList<>();

        try (Reader reader = new FileReader(csvFile);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : csvParser) {
                String word = csvRecord.get(0);
                String pos = csvRecord.get(1);
                String def = csvRecord.get(2);
                String example = csvRecord.size() > 3 ? csvRecord.get(3) : "";
                String synonyms = csvRecord.size() > 4 ? csvRecord.get(4) : "";
                String antonyms = csvRecord.size() > 5 ? csvRecord.get(5) : "";

                English english = new English();
                english.setWord(word);
                english.setType(pos);
                english.setMeaning(def);
                english.setExample(example);
                english.setSynonym(synonyms);
                english.setAntonyms(antonyms);

                englishList.add(english);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return englishList;
    }
}