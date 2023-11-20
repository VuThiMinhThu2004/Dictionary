package Dictionary.Alerts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private Connection connection;

    // Constructors, setters, getters, and other methods related to User entity
    // ...

    public String signUp(String displayName, String password) {
        // Code to insert new user into the database
        // ...

        // Example SQL query for inserting user
        String insertQuery = "INSERT INTO users(display_name, password) VALUES(?, ?);";

        try {
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, displayName);
            statement.setString(2, password);

            // Execute the SQL statement
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                return "Signed up successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Signed up failed.";
    }

    public String signIn(String displayName, String password) {
        // Code to verify user credentials from the database
        // ...

        // Example SQL query for checking user credentials
        String selectQuery = "SELECT * FROM users WHERE display_name = ? AND password = ?;";

        try {
            PreparedStatement statement = connection.prepareStatement(selectQuery);
            statement.setString(1, displayName);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // User credentials are valid
                return "Signed in successfully!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid username or password.";
    }
}
