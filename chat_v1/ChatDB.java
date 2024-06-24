import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ChatDB {

    private static final String URL = "jdbc:mysql://localhost:3306/chat";
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    
    public static void saveMessage(String message) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO messages (content) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, message);
            statement.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
