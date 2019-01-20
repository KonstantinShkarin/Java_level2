package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket server = null;
    private Socket socket = null;
    private DataInputStream in;
    private DataOutputStream out;
    // PrintWriter writer;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
            server = new ServerSocket(5000);
            System.out.println("Сервер запущен!");

            socket = server.accept();
            System.out.println("Клиент подключился!");

//            Scanner in = new Scanner(socket.getInputStream());
            Scanner outS = new Scanner(System.in);
//
//            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String str = in.readUTF();
                String strO = outS.nextLine();
                if (str.equals("/end")) {
                    out.writeUTF("/end");
                    break;
                }
                System.out.println(str);
                out.writeUTF(strO);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//
//
