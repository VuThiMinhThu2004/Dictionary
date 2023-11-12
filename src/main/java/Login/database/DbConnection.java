package Login.database;

/**
 * @author inforkgodara
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    private Connection con;
    private static DbConnection dbc;
    private DbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try{Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LoginApp", "root", "");
            PreparedStatement pStat = null;
            //pStat = conn.prepareStatement("INSERT INTO `players`(name,score) VALUES(?,?)");
            pStat.setString(1, "username");
            pStat.setString(2, "password");
            pStat.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DbConnection getDatabaseConnection() {
        if (dbc == null) {
            dbc = new DbConnection();
        }
        return dbc;
    }

    public Connection getConnection() {
        return con;
    }

    public static void main(String[] args) {
        new DbConnection();
    }
}