package JDBC_learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementDemo {
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

            java.sql.PreparedStatement ps = con.prepareStatement(selectQuery);

            // Insertion
//            ps.setString(1, "ravi");
//            ps.setInt(2, 21);

            // Updation
//            ps.setInt(1, 24);
//            ps.setString(2, "Rahul");

            // Deletion
//            ps.setInt(1,5);

            // Selection
            ps.setInt(1, 22);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));

            }

//            int rows = ps.executeUpdate();
//            if (rows > 0) {
//                System.out.println(rows + " Row Inserted Successfully ");
//            } else {
//                System.out.println("No Row Inserted");
//            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
