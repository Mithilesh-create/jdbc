import java.sql.*;

import javax.swing.JOptionPane;

public class JdbcTest {
    public static void main(String[] args) throws Exception {

        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "db";
            String user = "root";
            String password = "admin";
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "CREATE DATABASE " + db;
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            JOptionPane.showMessageDialog(null, db + " Database has been created successfully", "System Message",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
