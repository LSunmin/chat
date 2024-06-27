import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChatDB {
    private static final String URL = "jdbc:mysql://local:3306/chat";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void saveMessage(String message) {
        String query = "INSERT INTO messages (content) VALUES(?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, message);
            statement.executeUpdate();
            
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    public static void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}