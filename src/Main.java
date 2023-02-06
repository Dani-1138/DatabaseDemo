import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String  url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stat = conn.createStatement();
            //String sql = "INSERT INTO Student VALUES('4','selam',32,'2222')";
            //String sql = "DELETE FROM `student` WHERE id=4";
            //String sql = "UPDATE `student` SET `id`='717',`name`='Daniel',`age`='33',`password`='3332' WHERE id=1";

            //stat.executeUpdate(sql);

            ResultSet resultSet = stat.executeQuery("select * from student");

            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3)+" "+ resultSet.getString(4));

            }
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}