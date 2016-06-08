package SQLEdu.sqlitejdbcexperiments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lama
 */
public class Main {

    static Connection c;

    public static void main(String[] args) throws SQLException {
        createDB();
//        createTable();
//        insert();
        select();

    }

    public static void createDB() {
        c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Opened database succesfly");
    }

    public static void createTable() {

        try {
            Statement s = c.createStatement();

            String sql = "CREATE TABLE COMPANY"
                    + "(ID INT PRIMARY KEY NOT null,"
                    + "name text not null,"
                    + "age int not null,"
                    + "address char(50),"
                    + "salary real)";

            s.executeUpdate(sql);
            s.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Table created succesfly!");
    }

    static void insert() {
        try {
            c.setAutoCommit(false);
            System.out.println("Opened db succesfly");

            Statement stmt = c.createStatement();
            String sql = "insert into company (id, name, age, address, salary)"
                    + "values(1, 'paul', 32, 'California', 20000.00 )";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void select() {
        try {
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from company");

//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                int age = resultSet.getInt("age");
//                String address = resultSet.getString("address");
//                float salary = resultSet.getFloat("salary");
//                System.out.println("ID: " + id + ".\nName: " + name + "\nAge: " + age + "\nAddress: " + address + "\nSalary: " + salary + "\n-------------------------\n");
//
//            }
            System.out.println(resultSet.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
