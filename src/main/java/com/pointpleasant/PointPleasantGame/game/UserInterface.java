package com.pointpleasant.PointPleasantGame.game;

import javax.swing.*;
import java.awt.*;

public class UserInterface {

    JFrame window;
    JPanel titleNamePanel, startButtonPanel, locationPanel, mainTextPanel, choiceButtonPanel, imagePanel, inventoryPanel, playerStatsPanel, introPanel, introButtonPanel, weaponPanel;
    JLabel titleNameLabel, healthLabel, healthLabelStat, insightLabel, insightLabelStat, defenceLabel, defenceLabelStat,intelligenceLabel, intelligenceLabelStat, inspirationLabel, inspirationLabelStat, imageLabel;
    JButton startButton, continueButton, introButton;
    JButton weapon1, weapon2, weapon3, weapon4;
    Container container;
    JTextArea mainTextArea, locationTextArea, introTextArea;

    JButton choice1, choice2, choice3, choice4, choice5;

    ImageIcon image;
    Font font = new Font("Old Century", Font.PLAIN, 100);
    Font font2 = new Font("Old Century", Font.PLAIN, 20);
    Font font3 = new Font("Old Century", Font.PLAIN, 15);




    public void createInterface(Game.DecisionHandler decisionHandler){

//        Main Game Window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window = new JFrame();
        window.setSize(screenSize.width, screenSize.height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        //    Title Screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(300, 150, 800, 150);
        titleNamePanel.setBackground(new Color(0,0,0,0));
        titleNameLabel = new JLabel("Point Pleasant");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(font);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(600, 600, 200, 100);
        startButtonPanel.setBackground(new Color(0,0,0,0));

        startButton = new JButton("Start New Game");
        startButton.setFont(font2);
        startButton.setBackground(new Color(0,0,0,0));
        startButton.setForeground(Color.BLACK);
        startButton.addActionListener(decisionHandler);
        startButton.setActionCommand("start");

        continueButton = new JButton("Continue Game");
        continueButton.setFont(font2);
        continueButton.setBackground(new Color(0,0,0,0));
        continueButton.setForeground(Color.BLACK);

        startButtonPanel.add(startButton);
        startButtonPanel.add(continueButton);

        window.add(titleNamePanel);
        window.add(startButtonPanel);

//        Intro screen

        introPanel = new JPanel();
        introPanel.setBounds(300, 150, 800, 500);
        introPanel.setBackground(new Color(0,0,0,0));
        introTextArea = new JTextArea("You have been driving all night to get back to Point Pleasant.\n It had been a long drive and you are exhausted.\n The world seems full of vampires. A tedious future awaits.\n Well, you pull into the town centre eager to\n meet your dear friend, local newspaper editor, Mary Hyre.");
        introTextArea.setBackground(new Color(0,0,0,0));
        introTextArea.setForeground(Color.WHITE);
        introTextArea.setFont(font2);
        introPanel.add(introTextArea);
        window.add(introPanel);

        introButton = new JButton(">>>");
        introButton.setFont(font2);
        introButton.setBackground(new Color(0,0,0,0));
        introButton.setForeground(Color.BLACK);
        introButton.addActionListener(decisionHandler);
        introButton.setActionCommand("startAfterIntro");

        introButtonPanel = new JPanel();
        introButtonPanel.setBounds(1000, 700, 200, 100);
        introButtonPanel.setBackground(new Color(0,0,0,0));

        introButtonPanel.add(introButton);
        window.add(introButtonPanel);

//        Game Screen

        locationPanel = new JPanel();
        locationPanel.setBounds(330, 30, 750, 40);
        locationPanel.setBackground(Color.MAGENTA);

        locationTextArea = new JTextArea();
        locationTextArea.setBounds(250, 30, 750, 40);
        locationTextArea.setBackground(Color.BLACK);
        locationTextArea.setForeground(Color.WHITE);
        locationTextArea.setFont(font2);
        locationPanel.add(locationTextArea);
        window.add(locationPanel, BorderLayout.PAGE_START);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(330, 490, 750, 140);
        mainTextPanel.setBackground(Color.BLUE);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(330, 490, 750, 140);
        mainTextArea.setBackground(new Color(0,0,0,0));
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(font2);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        imagePanel = new JPanel();
        imagePanel.setBounds(330, 80, 750, 400);
        imagePanel.setBackground(Color.yellow);

        imageLabel = new JLabel();
        imagePanel.add(imageLabel);
        window.add(imagePanel);

        inventoryPanel = new JPanel();
        window.add(inventoryPanel, BorderLayout.LINE_START);
        inventoryPanel.setBounds(20, 80, 290, 500);
        inventoryPanel.setBackground(Color.yellow);

        weaponPanel = new JPanel();
        weaponPanel.setBounds(1100, 400, 290, 230);
        weaponPanel.setBackground(Color.WHITE);
        weaponPanel.setLayout(new GridLayout(4, 1));

        weapon1 = new JButton("EQUIPPED WEAPON: Alloy Tube");
        weapon1.setBackground(Color.BLACK);
        weapon1.setForeground(Color.BLACK);
        weapon1.setFont(font3);
//        choice1.addActionListener(decisionHandler);
//        choice1.setActionCommand("c1");

        weapon2 = new JButton("Shotgun");
        weapon2.setBackground(Color.BLACK);
        weapon2.setForeground(Color.BLACK);
        weapon2.setFont(font3);
        //   choice1.addActionListener(decisionHandler);
//        choice1.setActionCommand("c1");

        weapon3 = new JButton("Baseball bat");
        weapon3.setBackground(Color.BLACK);
        weapon3.setForeground(Color.BLACK);
        weapon3.setFont(font3);
        //   choice1.addActionListener(decisionHandler);
//        choice1.setActionCommand("c1");

        weapon4 = new JButton("Zap Gun");
        weapon4.setBackground(Color.BLACK);
        weapon4.setForeground(Color.BLACK);
        weapon4.setFont(font3);
        //   choice1.addActionListener(decisionHandler);
//        choice1.setActionCommand("c1");

        weaponPanel.add(weapon1);
        weaponPanel.add(weapon2);
        weaponPanel.add(weapon3);
        weaponPanel.add(weapon4);

        window.add(weaponPanel, BorderLayout.LINE_END);

        choiceButtonPanel = new JPanel();
        window.add(choiceButtonPanel, BorderLayout.LINE_END);
        choiceButtonPanel.setBounds(1100, 80, 320, 300);
        choiceButtonPanel.setBackground(Color.BLACK);
        choiceButtonPanel.setLayout(new GridLayout(5,1));

        choice1 = new JButton("choice 1");
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.BLACK);
        choice1.setFont(font2);
        choice1.addActionListener(decisionHandler);
        choice1.setActionCommand("c1");

        choice2 = new JButton("choice 2");
        choice2.setBackground(Color.BLACK);
        choice2.setForeground(Color.BLACK);
        choice2.setFont(font2);
        choice2.addActionListener(decisionHandler);
        choice2.setActionCommand("c2");

        choice3 = new JButton("choice 3");
        choice3.setBackground(Color.BLACK);
        choice3.setForeground(Color.BLACK);
        choice3.setFont(font2);
        choice3.addActionListener(decisionHandler);
        choice3.setActionCommand("c3");



        choice4 = new JButton("choice 4");
        choice4.setBackground(Color.BLACK);
        choice4.setForeground(Color.BLACK);
        choice4.setFont(font2);
        choice4.addActionListener(decisionHandler);
        choice4.setActionCommand("c4");


        choice5 = new JButton("choice 5");
        choice5.setBackground(Color.BLACK);
        choice5.setForeground(Color.BLACK);
        choice5.setFont(font2);
        choice5.addActionListener(decisionHandler);
        choice5.setActionCommand("c5");


        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        choiceButtonPanel.add(choice4);
        choiceButtonPanel.add(choice5);

        playerStatsPanel = new JPanel();
        playerStatsPanel.setBounds(100, 650, 1220, 50);
        playerStatsPanel.setBackground(Color.RED);
        playerStatsPanel.setLayout(new GridLayout(1,10));
        window.add(playerStatsPanel, BorderLayout.PAGE_END);

        healthLabel = new JLabel("HP:");
        healthLabel.setFont(font3);
        healthLabel.setForeground(Color.WHITE);
        playerStatsPanel.add(healthLabel);
        healthLabelStat = new JLabel("");
        healthLabelStat.setForeground(Color.WHITE);
        playerStatsPanel.add(healthLabelStat);

        insightLabel = new JLabel("INSIGHT:");
        insightLabel.setFont(font3);
        insightLabel.setForeground(Color.WHITE);
        playerStatsPanel.add(insightLabel);
        insightLabelStat = new JLabel("");
        insightLabelStat.setFont(font3);
        insightLabelStat.setForeground(Color.WHITE);
        playerStatsPanel.add(insightLabelStat);

        defenceLabel = new JLabel("DEFENCE:");
        defenceLabel.setFont(font3);
        defenceLabel.setForeground(Color.WHITE);
        playerStatsPanel.add(defenceLabel);
        defenceLabelStat = new JLabel("");
        defenceLabelStat.setFont(font3);
        defenceLabelStat.setForeground(Color.WHITE);
        playerStatsPanel.add(defenceLabelStat);

        intelligenceLabel = new JLabel("INTELLIGENCE:");
        intelligenceLabel.setFont(font3);
        intelligenceLabel.setForeground(Color.WHITE);
        playerStatsPanel.add(intelligenceLabel);
        intelligenceLabelStat = new JLabel("");
        intelligenceLabelStat.setFont(font3);
        intelligenceLabelStat.setForeground(Color.WHITE);
        playerStatsPanel.add(intelligenceLabelStat);

        inspirationLabel = new JLabel("INSPIRATION:");
        inspirationLabel.setFont(font3);
        inspirationLabel.setForeground(Color.WHITE);
        playerStatsPanel.add(inspirationLabel);
        inspirationLabelStat = new JLabel("");
        inspirationLabelStat.setFont(font3);
        inspirationLabelStat.setForeground(Color.WHITE);
        playerStatsPanel.add(inspirationLabelStat);

        window.setVisible(true);

    }


}
