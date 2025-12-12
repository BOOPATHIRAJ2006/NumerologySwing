import java.sql.*;
import java.util.Scanner;

public class OnlineQuizApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/questions";
        String user = "root";      // replace with your MySQL 
        String password = "";  // replace with your MySQL password

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             Scanner sc = new Scanner(System.in)) {

            String query = "SELECT * FROM questions";
            ResultSet rs = stmt.executeQuery(query);

            int score = 0;
            while (rs.next()) {
                System.out.println("\nQ: " + rs.getString("question"));
                System.out.println("A. " + rs.getString("optionA"));
                System.out.println("B. " + rs.getString("optionB"));
                System.out.println("C. " + rs.getString("optionC"));
                System.out.println("D. " + rs.getString("optionD"));

                System.out.print("Your answer (A/B/C/D): ");
                String answer = sc.next().toUpperCase();

                if (answer.equals(rs.getString("correctOption"))) {
                    System.out.println("✅ Correct!");
                    score++;
                } else {
                    System.out.println("❌ Wrong! Correct answer: " + rs.getString("correctOption"));
                }
            }

            System.out.println("\nFinal Score: " + score);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
