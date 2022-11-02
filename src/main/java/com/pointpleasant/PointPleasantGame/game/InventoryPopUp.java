package com.pointpleasant.PointPleasantGame.game;


import javax.swing.*;
import java.awt.*;


public class InventoryPopUp {

    JFrame popUpFrame;
    JPanel popUpPanel;
    JTextArea popUpTextArea;
    UserInterface userInterface;

    public static void main(String[] args) {
        JFrame popUpFrame = new JFrame();
        popUpFrame.setSize(300, 200);
        popUpFrame.setVisible(true);

        JPanel popUpPanel = new JPanel();
        popUpPanel.setBackground(Color.BLACK);
        JTextArea popUpTextArea = new JTextArea();

        popUpTextArea.setForeground(Color.WHITE);
        popUpTextArea.setFont(UserInterface.font2);
        popUpTextArea.setLineWrap(true);
        popUpTextArea.setWrapStyleWord(true);
        popUpTextArea.setText("blah");

    }
}
