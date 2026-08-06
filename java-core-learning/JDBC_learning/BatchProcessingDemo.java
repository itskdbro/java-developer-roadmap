package JDBC_learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BatchProcessingDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_learning";
        String username = "root";
        String password = "keshav0220";

        try {
            Connection con = DriverManager.getConnection(url, username, password);


            String insertQuery = "Insert into student(name,age) values(?,?)";
            String updateQuery = "Update student Set age = ? where name = ?";
            String deleteQuery = "Delete from student where id = ?";
            String selectQuery = "Select * from student where age > ?";

            java.sql.PreparedStatement ps = con.prepareStatement(insertQuery);

            // Batch- 1
            ps.setString(1, "naitik");
            ps.setInt(2, 24);
            ps.addBatch();

            // Batch- 2
            ps.setString(1, "rajan");
            ps.setInt(2, 23);
            ps.addBatch();

            // Batch- 3
            ps.setString(1, "om");
            ps.setInt(2, 22);
            ps.addBatch();


            int[] rows = ps.executeBatch();
            for (int i : rows) {
                System.out.println(i);
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
