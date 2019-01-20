import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket server;
    private Socket socket;
   // PrintWriter writer;

    public Server(){
        try {
            server = new ServerSocket(5000);
            System.out.println("Сервер запущен!");

            socket = new Socket();
//            Scanner in = new Scanner(socket.getInputStream());
//            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился!");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
         ;
        }

        }

    }
