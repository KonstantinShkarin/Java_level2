import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private JFrame chatFrame;
    private JPanel panelChat;
    private JButton sendButton;
    private JLabel areaLable, fieldWriteLable;
    private JTextArea chatArea;
    private JTextField fieldWrite;
    private JScrollPane scrollPane;

    public void ChatWindow() {
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
    }
    public void addText () {



            ArrayList<String> chatHistory = new ArrayList<>();
            String fieldWriteGetText = fieldWrite.getText();

            chatHistory.add(fieldWriteGetText);
        try {
            out.writeUTF(fieldWriteGetText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fieldWrite.setText("");
        fieldWrite.requestFocus();

        }

         class SendListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                addText();
            }
        }
         class FieldWriteListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) { addText();
            }
        }

    public void connectClient(){
        try {
            socket = new Socket("127.0.0.1", 5000);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
