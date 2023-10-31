package Dictionary;

import Dictionary.Models.English;
import Dictionary.Models.EnglishDataAccessObject;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBConfig {
    private static final String DATABASE_URL = "jdbc:sqlite:engData.db";
    static ConnectionSource connectionSource;

    static {
        try {
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static EnglishDataAccessObject englishDAO;

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
        LoadData();//nap db
    }

    public static void LoadData() throws SQLException {
        String csvFile = "src/main/resources/englishDictionary.csv";
        List<English> englishList = parseEnglish(csvFile);
        for (English english : englishList) {
            englishDAO.updateWord(english);
        }
    }

    public static List<English> parseEnglish(String csvFile) {
        List<English> englishList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }

                String[] values = line.split(",", -1);
                if (values.length >= 3) {
                    String word = values[0].trim();
                    String pos = values[1].trim();
                    String def = values[2].trim();
                    English english = new English();
                    english.setWord(word);
                    english.setType(pos);
                    english.setMeaning(def);
                    englishList.add(english);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return englishList;
    }
}