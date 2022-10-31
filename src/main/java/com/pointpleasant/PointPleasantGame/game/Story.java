package com.pointpleasant.PointPleasantGame.game;


import javax.swing.*;


public class Story {

    Game game;
    UserInterface userInterface;
    VisibilityManager visibilityManager;

    public Story(Game game, UserInterface userInterface, VisibilityManager visibilityManager){
        this.game = game;
        this.userInterface = userInterface;
        this.visibilityManager = visibilityManager;
    }

    public void playerDefault(){
//        player.setHealthPoints(10);
//        player.setInsight(0);
//        player.setDefence(3);
//        player.setInspiration(0);
//        player.setIntelligence(4);
        userInterface.healthLabelStat.setText(Integer.toString(10));
        userInterface.insightLabelStat.setText(Integer.toString(0));
        userInterface.defenceLabelStat.setText(Integer.toString(3));
        userInterface.inspirationLabelStat.setText(Integer.toString(0));
        userInterface.intelligenceLabelStat.setText(Integer.toString(4));
        userInterface.cashLabelStat.setText(Integer.toString(80));
    }

//    can make into an interface:
    public void selectChoice(String choiceButton){
        switch (choiceButton){
            case "newspaperOffice":newsPaperOffice(); break;
            case "hotelRoom": hotelRoom();break;
            case "petTheDog": petTheDog();break;
            case "kissYourMother": kissYourMother();break;
            case "leaveTown": leaveTown();break;
            case "askAfterMary": askAfterMary(); break;
            case "enterTheTown": enterTheTown();break;
        }
    }
    public void enterTheTown(){
        ImageIcon townImage = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/point.jpeg");
        userInterface.imageLabel.setIcon(townImage);

        userInterface.mainTextArea.setText("Point Pleasant is a quiet town. \nA quiet fortitude lurks among the people. You wait by your parked car and decide what to do.\nWhere to go next?");
        userInterface.choice1.setText("Go into the newspaper office");
        userInterface.choice2.setText("Go into the hotel");
        userInterface.choice3.setText("Pet the dog");
        userInterface.choice4.setText("Kiss your mother");
        userInterface.choice5.setText("Leave town");
        userInterface.locationTextArea.setText("Point Pleasant Town Centre");

        game.choiceButton1 = "newspaperOffice";
        game.choiceButton2 = "hotelRoom";
        game.choiceButton3 = "petTheDog";
        game.choiceButton4 = "kissYourMother";
        game.choiceButton5 = "leaveTown";
    }

    public void newsPaperOffice(){
        userInterface.mainTextArea.setText("You enter the newspaper office looking for your friend, Mary Hyre. There are only a couple of people around. The room is small. One old man sits at a typewriter. He asks what you want?");
        userInterface.choice1.setText("Tell him to eat his hat");
        userInterface.choice2.setText("Tell him you are new in town.");
        userInterface.choice3.setText("Ask after Mary");
        userInterface.choice4.setText("Leave the post office.");
        userInterface.choice5.setText("");
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        game.choiceButton1 = "";
        game.choiceButton2 = "";
        game.choiceButton3 = "askAfterMary";
        game.choiceButton4 = "enterTheTown";
        game.choiceButton5 = "leaveTown";
    }

    public void askAfterMary(){
        userInterface.mainTextArea.setText("She's been sick all day. Maybe you want to go see her at home. I can give you her address.");
        userInterface.choice1.setText("Get her address.");
        userInterface.choice2.setText("Tell him you are new in town.");
        userInterface.choice3.setText("Tell him about the bright lights you saw on the way into town.");
        userInterface.choice4.setText("Leave the post office.");
        userInterface.choice5.setText("");
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        game.choiceButton1 = "askAfterMary";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "enterTheTown";
        game.choiceButton5 = "leaveTown";
    }

    public void hotelRoom(){

    }

    public void petTheDog(){

    }

    public void kissYourMother(){

    }

    public void leaveTown(){

    }

}
