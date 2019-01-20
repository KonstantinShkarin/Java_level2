package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

class Chat {

    JFrame chatFrame;
    JPanel panelChat;
    JButton sendButton;
    JLabel areaLable, fieldWriteLable;
    JTextArea chatArea;
    JTextField fieldWrite;
    JScrollPane scrollPane;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    final  String IP_ADRESS = "localhost";
    final int PORT = 5000;
    String str;


    public static void main(String[] args) {
        Chat chat = new Chat();
        chat.go();
    }

    public void go() {

        chatFrame = new JFrame("Сетевой чат");
        panelChat = new JPanel();
        areaLable = new JLabel("История:");
        fieldWriteLable = new JLabel("Текст ввода:");
        chatArea = new JTextArea(10, 30);
        fieldWrite = new JTextField(30);
        sendButton = new JButton("Отправить");

        chatFrame.setLayout(new FlowLayout());

        chatArea.setLineWrap(true);
        sendButton.addActionListener(new SendListener());
        fieldWrite.addActionListener(new FieldWriteListener());

        scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        panelChat.add(scrollPane);
        chatArea.setEditable(false);

        chatFrame.getContentPane().add(areaLable);
        chatFrame.getContentPane().add(panelChat);
        chatFrame.getContentPane().add(fieldWriteLable);
        chatFrame.getContentPane().add(fieldWrite);
        chatFrame.getContentPane().add(sendButton);

        chatFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chatFrame.setSize(390, 390);
        chatFrame.setVisible(true);
        chatFrame.setResizable(false);
        chatFrame.getContentPane().setBackground(Color.lightGray);

        try {
            socket = new Socket(IP_ADRESS,PORT);
            in =  new DataInputStream (socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                             str = in.readUTF();
                             if (str.equals("/end"))
                                 break;
                             chatArea.append(str+"\n");

                    }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {e.printStackTrace();

                        }
                    }

                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addText() {
//        ArrayList<String> chatHistory = new ArrayList<>();
//        String fieldWriteGetText = fieldWrite.getText();
//
//        chatHistory.add(fieldWriteGetText);
//
//        chatArea.append(chatHistory.toString() + "\n");
//        fieldWrite.setText("");

        //chatArea.append(fieldWrite.getText() +"\n");
        try {
            out.writeUTF(fieldWrite.getText());
            fieldWrite.setText("");
            fieldWrite.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public class SendListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addText();
        }
    }

    public class FieldWriteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { addText();
        }
    }
}
