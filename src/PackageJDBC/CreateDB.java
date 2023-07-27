package PackageJDBC;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateDB {
    public void createDB() {
        try {

            String url = "jdbc:postgresql://localhost:5432/";
            String user = "postgres";
            String password = "admin";
            String sql = "create database school";
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            int bl = statement.executeUpdate(sql);
            System.out.println("Created to database successfully........." + bl);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {

            String url = "jdbc:postgresql://localhost:5432/";
            String user = "postgres";
            String password = "admin";
            String db = "school";
            String sql = "create table students(studentId int,sname varchar(255),age int)";
            Connection connection = DriverManager.getConnection(url + db, user, password);
            Statement statement = connection.createStatement();
            int bl = statement.executeUpdate(sql);
            System.out.println("Created table successfully........." + bl);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertIntoTable() {
        try {

            String url = "jdbc:postgresql://localhost:5432/";
            String user = "postgres";
            String password = "admin";
            String db = "school";
            String sql = "insert into students (studentId,sname,age) values (?,?,?)";

            Connection connection = DriverManager.getConnection(url + db, user, password);
            // Statement statement = connection.createStatement();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, 2);
            pstm.setString(2, "Nilesh");
            pstm.setInt(3, 26);
            pstm.execute();
            // int bl = statement.executeUpdate(sql);
            System.out.println("Inserted into table successfully.........");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ReadData() {
        try {

            String url = "jdbc:postgresql://localhost:5432/";
            String user = "postgres";
            String password = "admin";
            String db = "school";
            String sql = "select * from students";

            Connection connection = DriverManager.getConnection(url + db, user, password);
            // Statement statement = connection.createStatement();
            PreparedStatement pstm = connection.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(3));
                System.out.println(rs.getString("sname"));

                System.out.println(" ");
            }
            // int bl = statement.executeUpdate(sql);
            System.out.println("Read successfully.........");
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
