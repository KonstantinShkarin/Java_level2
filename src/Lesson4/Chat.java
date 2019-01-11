package Lesson4;

//@Konstantin Shkarin
//        02.01.2019
//        Java 2 lesson 4


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Chat {

    JFrame chatFrame;
    JPanel panelChat;
    JButton sendButton;
    JLabel areaLable, fieldWriteLable;
    JTextArea chatArea;
    JTextField fieldWrite;
    JScrollPane scrollPane;


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

    }

    public void addText() {
        ArrayList<String> chatHistory = new ArrayList<>();
        String fieldWriteGetText = fieldWrite.getText();

        chatHistory.add(fieldWriteGetText);

        chatArea.append(chatHistory.toString() + "\n");
        fieldWrite.setText("");
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
