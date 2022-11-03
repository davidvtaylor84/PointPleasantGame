package com.pointpleasant.PointPleasantGame.game;

public class VisibilityManager {

    UserInterface userInterface;
    public VisibilityManager(UserInterface ui){
        userInterface = ui;
    }

    public void showTitleScreen(){
        userInterface.titleNamePanel.setVisible(true);
        userInterface.startButtonPanel.setVisible(true);
        userInterface.titleImagePanel.setVisible(true);

        userInterface.introPanel.setVisible(false);
        userInterface.introButtonPanel.setVisible(false);

        userInterface.mainTextPanel.setVisible(false);
        userInterface.choiceButtonPanel.setVisible(false);
        userInterface.playerStatsPanel.setVisible(false);
        userInterface.locationPanel.setVisible(false);
        userInterface.mainTextPanel.setVisible(false);
        userInterface.choiceButtonPanel.setVisible(false);
        userInterface.imagePanel.setVisible(false);
        userInterface.inventoryPanel.setVisible(false);
        userInterface.playerStatsPanel.setVisible(false);
        userInterface.itemDescriptionPanel.setVisible(false);
    }

    public void showIntroScreen(){
        userInterface.titleNamePanel.setVisible(false);
        userInterface.startButtonPanel.setVisible(false);
        userInterface.titleImagePanel.setVisible(false);

        userInterface.introPanel.setVisible(true);
        userInterface.introButtonPanel.setVisible(true);



        userInterface.mainTextPanel.setVisible(false);
        userInterface.choiceButtonPanel.setVisible(false);
        userInterface.playerStatsPanel.setVisible(false);
        userInterface.locationPanel.setVisible(false);
        userInterface.mainTextPanel.setVisible(false);
        userInterface.choiceButtonPanel.setVisible(false);
        userInterface.imagePanel.setVisible(false);
        userInterface.inventoryPanel.setVisible(false);
        userInterface.playerStatsPanel.setVisible(false);
        userInterface.itemDescriptionPanel.setVisible(false);
    }

    public void showGameScreen(){
        userInterface.titleNamePanel.setVisible(false);
        userInterface.startButtonPanel.setVisible(false);
        userInterface.titleImagePanel.setVisible(false);

        userInterface.introPanel.setVisible(false);
        userInterface.introButtonPanel.setVisible(false);


        userInterface.mainTextPanel.setVisible(true);
        userInterface.choiceButtonPanel.setVisible(true);
        userInterface.playerStatsPanel.setVisible(true);
        userInterface.locationPanel.setVisible(true);
        userInterface.mainTextPanel.setVisible(true);
        userInterface.choiceButtonPanel.setVisible(true);
        userInterface.imagePanel.setVisible(true);
        userInterface.inventoryPanel.setVisible(true);
        userInterface.playerStatsPanel.setVisible(true);
        userInterface.itemDescriptionPanel.setVisible(true);

    }
}

