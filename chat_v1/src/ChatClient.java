import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println("Server: " + response);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }).start();

            try (Scanner scanner = new Scanner(System.in)) {
                String message;
                while ((message = scanner.nextLine()) != null) {
                    out.println(message);
                }
            } // Scanner가 자동으로 닫힌다.
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
