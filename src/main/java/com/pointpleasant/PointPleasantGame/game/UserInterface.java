package com.pointpleasant.PointPleasantGame.game;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {

    JFrame window, inventoryDetail;
    JPanel titleNamePanel, startButtonPanel, locationPanel, mainTextPanel, choiceButtonPanel, imagePanel, inventoryPanel, playerStatsPanel, introPanel, introButtonPanel, itemDescriptionPanel, titleImagePanel, openingImagePanel;
    JLabel titleNameLabel, healthLabel, healthLabelStat, insightLabel, insightLabelStat, defenceLabel, defenceLabelStat,intelligenceLabel, intelligenceLabelStat, inspirationLabel, inspirationLabelStat, imageLabel, cashLabel, cashLabelStat, titleImageLabel, openingImageLabel;
    JButton startButton, continueButton, introButton;
    JButton weapon1, weapon2, weapon3, weapon4, inventory1, inventory2, inventory3, inventory4, inventory5, inventory6, inventory7, inventory8, blankButton;
    Container container;
    JTextArea mainTextArea, locationTextArea, introTextArea, inventoryDetailText;

    JButton choice1, choice2, choice3, choice4, choice5;

    ImageIcon image;
    Font font = new Font("Impact", Font.PLAIN, 120);
    static Font font2 = new Font("Old Century", Font.PLAIN, 20);
    Font font3 = new Font("Old Century", Font.PLAIN, 15);
    Font font4 = new Font(Font.MONOSPACED, Font.PLAIN, 17);

    Font font5 = new Font(Font.MONOSPACED, Font.PLAIN, 14);

    String text ="";
    int i;


    public void createInterface(Game.DecisionHandler decisionHandler){

//        Main Game Window
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window = new JFrame();
        window.setSize(1440, 800);
//        window.setSize(screenSize.width, screenSize.height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);


        //    Title Screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(300, 80, 800, 150);
        titleNamePanel.setBackground(new Color(0,0,0,0));
        titleNameLabel = new JLabel("Point Pleasant");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(font);
        titleNamePanel.add(titleNameLabel);

        titleImagePanel = new JPanel();
//        titleImagePanel.setBounds(0, 0, screenSize.width, 900);
        titleImagePanel.setBounds(0, 0, 1440, 800);
        titleImagePanel.setBackground(new Color(0,0,0,0));
        ImageIcon starlitHighway = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/darkhighway.jpeg");
        titleImageLabel = new JLabel();
        titleImageLabel.setIcon(starlitHighway);
        titleImagePanel.add(titleImageLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(590, 500, 200, 100);
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
        continueButton.addActionListener(decisionHandler);
        continueButton.setActionCommand("continue");

        startButtonPanel.add(startButton);
        startButtonPanel.add(continueButton);

        window.add(titleNamePanel);
        window.add(startButtonPanel);
        window.add(titleImagePanel);

//        Intro screen

        introPanel = new JPanel();
        introPanel.setBounds(300, 150, 900, 500);
        introPanel.setBackground(Color.BLACK);
        introTextArea = new JTextArea("You have been driving for 13 hours. It is now 3am. The headlights form a cone of light on the asphalt, which is eaten up by the car's underside. \n\nBefore you is a highway emptied of traffic and darkened fields marked by telegraph poles on either side. The moon is hidden by clouds. \n\nYou are not aware of losing consciousness...  ");
        introTextArea.setBackground(new Color(0,0,0,0));
        introTextArea.setBounds(300, 150, 900, 500);
        introTextArea.setForeground(Color.WHITE);
        introTextArea.setFont(font2);
        introTextArea.setLineWrap(true);
        introTextArea.setWrapStyleWord(true);
        introPanel.add(introTextArea);
        window.add(introPanel);

        introButton = new JButton(">>>");
        introButton.setFont(font2);
        introButton.setBackground(Color.BLACK);
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
        locationPanel.setBackground(new Color(0,0,0,0));

        locationTextArea = new JTextArea();
        locationTextArea.setBounds(250, 30, 750, 40);
        locationTextArea.setBackground(Color.BLACK);
        locationTextArea.setForeground(Color.WHITE);
        locationTextArea.setFont(font2);
        locationPanel.add(locationTextArea);
        window.add(locationPanel, BorderLayout.PAGE_START);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(330, 490, 750, 140);
        mainTextPanel.setBackground(Color.BLACK);
        mainTextPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        window.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(340, 490, 750, 140);
        mainTextArea.setBackground(new Color(0,0,0,0));
        mainTextArea.setForeground(Color.WHITE);
        mainTextArea.setFont(font4);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        imagePanel = new JPanel();
        imagePanel.setBounds(330, 80, 750, 400);
        imagePanel.setBackground(new Color(0,0,0,0));

        imageLabel = new JLabel();
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        window.add(imagePanel);

        inventoryPanel = new JPanel();
        window.add(inventoryPanel, BorderLayout.LINE_START);
        inventoryPanel.setBounds(20, 80, 290, 500);
        inventoryPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        inventoryPanel.setBackground(new Color(51, 25,0));
        inventoryPanel.setLayout(new GridLayout(13, 1));


        inventory1 = new JButton("(Inventory slot 1)");
        inventory1.setBackground(Color.BLACK);
        inventory1.setForeground(Color.BLACK);
        inventory1.setFont(font3);
        inventory1.addActionListener(decisionHandler);
        inventory1.setActionCommand("inventory1");

        inventory2 = new JButton("(Inventory slot 2)");
        inventory2.setBackground(Color.BLACK);
        inventory2.setForeground(Color.BLACK);
        inventory2.setFont(font3);
        inventory2.addActionListener(decisionHandler);
        inventory2.setActionCommand("inventory2");

        inventory3 = new JButton("(Inventory slot 3)");
        inventory3.setBackground(Color.BLACK);
        inventory3.setForeground(Color.BLACK);
        inventory3.setFont(font3);
        inventory3.addActionListener(decisionHandler);
        inventory3.setActionCommand("inventory3");

        inventory4 = new JButton("(Inventory slot 4)");
        inventory4.setBackground(Color.BLACK);
        inventory4.setForeground(Color.BLACK);
        inventory4.setFont(font3);
        inventory4.addActionListener(decisionHandler);
        inventory4.setActionCommand("inventory4");

        inventory5 = new JButton("(Inventory slot 5)");
        inventory5.setBackground(Color.BLACK);
        inventory5.setForeground(Color.BLACK);
        inventory5.setFont(font3);
        inventory5.addActionListener(decisionHandler);
        inventory5.setActionCommand("inventory5");

        inventory6 = new JButton("(Inventory slot 6)");
        inventory6.setBackground(Color.BLACK);
        inventory6.setForeground(Color.BLACK);
        inventory6.setFont(font3);
        inventory6.addActionListener(decisionHandler);
        inventory6.setActionCommand("inventory6");

        inventory7 = new JButton("(Inventory slot 7)");
        inventory7.setBackground(Color.BLACK);
        inventory7.setForeground(Color.BLACK);
        inventory7.setFont(font3);
        inventory7.addActionListener(decisionHandler);
        inventory7.setActionCommand("inventory7");

        inventory8 = new JButton("(Inventory slot 8)");
        inventory8.setBackground(Color.BLACK);
        inventory8.setForeground(Color.BLACK);
        inventory8.setFont(font3);
        inventory8.addActionListener(decisionHandler);
        inventory8.setActionCommand("inventory8");

        inventoryPanel.add(inventory1);
        inventoryPanel.add(inventory2);
        inventoryPanel.add(inventory3);
        inventoryPanel.add(inventory4);
        inventoryPanel.add(inventory5);
        inventoryPanel.add(inventory6);
        inventoryPanel.add(inventory7);
        inventoryPanel.add(inventory8);

        itemDescriptionPanel = new JPanel();
        itemDescriptionPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        itemDescriptionPanel.setBounds(1100, 400, 290, 230);
        itemDescriptionPanel.setBackground(new Color(51, 25,0));
        inventoryDetailText = new JTextArea("GAME INSTRUCTIONS\n\n1.Make choices using the buttons above.\n\n2.Use inventory and discover inventory clues by clicking buttons to the left.\n\n3.Game will save on close. You will awaken at save point.");
        inventoryDetailText.setBounds(1100, 400, 285, 225);
        inventoryDetailText.setBackground(new Color(51, 25,0));
        inventoryDetailText.setForeground(Color.WHITE);
        inventoryDetailText.setFont(font5);
        inventoryDetailText.setLineWrap(true);
        inventoryDetailText.setWrapStyleWord(true);
        inventoryDetailText.setEditable(false);
        itemDescriptionPanel.add(inventoryDetailText);

//        weaponPanel.setLayout(new GridLayout(4, 1));

        weapon1 = new JButton("(Weapon slot 1)");
        weapon1.setBackground(Color.BLACK);
        weapon1.setForeground(Color.BLACK);
        weapon1.setFont(font3);
        weapon1.addActionListener(decisionHandler);
        weapon1.setActionCommand("weapon1");

        weapon2 = new JButton("(Weapon slot 2)");
        weapon2.setBackground(Color.BLACK);
        weapon2.setForeground(Color.BLACK);
        weapon2.setFont(font3);
        weapon2.addActionListener(decisionHandler);
        weapon2.setActionCommand("weapon2");

        weapon3 = new JButton("(Weapon slot 3)");
        weapon3.setBackground(Color.BLACK);
        weapon3.setForeground(Color.BLACK);
        weapon3.setFont(font3);
        weapon3.addActionListener(decisionHandler);
        weapon3.setActionCommand("weapon3");

        weapon4 = new JButton("(Weapon slot 4)");
        weapon4.setBackground(Color.BLACK);
        weapon4.setForeground(Color.BLACK);
        weapon4.setFont(font3);
        weapon4.addActionListener(decisionHandler);
        weapon4.setActionCommand("weapon4");

        blankButton = new JButton();
        blankButton.setBackground(new Color(51, 25,0));
        blankButton.setForeground(new Color(51, 25,0));
        blankButton.setFont(font3);
        blankButton.setOpaque(true);
        blankButton.setBorderPainted(false);

        inventoryPanel.add(blankButton);
        inventoryPanel.add(weapon1);
        inventoryPanel.add(weapon2);
        inventoryPanel.add(weapon3);
        inventoryPanel.add(weapon4);

        window.add(itemDescriptionPanel, BorderLayout.LINE_END);

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
        playerStatsPanel.setBounds(150, 650, 1220, 50);
        playerStatsPanel.setBackground(Color.BLACK);
        playerStatsPanel.setLayout(new GridLayout(1,12));
        inventoryPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
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

        intelligenceLabel = new JLabel("ATTACK:");
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

        cashLabel = new JLabel("CASH:");
        cashLabel.setFont(font3);
        cashLabel.setForeground(Color.WHITE);
        playerStatsPanel.add(cashLabel);
        cashLabelStat = new JLabel("");
        cashLabelStat.setFont(font3);
        cashLabelStat.setForeground(Color.WHITE);
        playerStatsPanel.add(cashLabelStat);

        window.setVisible(true);

    }

    Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            char[] character = text.toCharArray();
            int arrayNumber = character.length;

            String addedCharacter ="";
            String blank = "";

            addedCharacter = blank + character[i];
            mainTextArea.append(addedCharacter);

            i++;

            if(i==arrayNumber){
                i=0;
                timer.stop();
            }
        }
    });

    public void prepareText(){
        i=0;
        mainTextArea.setText("");
        timer.start();
    }




}
