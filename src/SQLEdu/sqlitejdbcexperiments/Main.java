package SQLEdu.sqlitejdbcexperiments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lama
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:COREJAVA";
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, username, password);
    }

}
