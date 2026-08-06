package JDBC_learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_learning";
        String username = "root";
        String password = "keshav0220";

        try {
            // 1. Establish Connection
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection successfully");

            // 2. Create Statement
            Statement st = con.createStatement();

            // 3. Execute Query
            String insertQuery = "INSERT into student(name,age) VALUES('Aman',22)";
            String updateQuery = "Update student Set age = 23 Where name = 'Aman' ";

            int rows = st.executeUpdate(updateQuery);
            if (rows > 0) {
                System.out.println(rows + " rows Updated Successfully");
            } else {
                System.out.println("No Rows Updated");
            }

            // 4. Result set
            ResultSet rs = st.executeQuery("Select * from student");
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));

            }

            // 5. Close connection
            con.close();
            st.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
