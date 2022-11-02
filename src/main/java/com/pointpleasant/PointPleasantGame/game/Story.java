package com.pointpleasant.PointPleasantGame.game;


import com.pointpleasant.PointPleasantGame.models.Player;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Item;
import com.pointpleasant.PointPleasantGame.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

public class Story {

    Game game;

    Item item;
    UserInterface userInterface;
    VisibilityManager visibilityManager;




    public Story(Game game, UserInterface userInterface, VisibilityManager visibilityManager){
        this.game = game;
        this.userInterface = userInterface;
        this.visibilityManager = visibilityManager;
    }

    public Player getPlayer(){
        PlayerRepository playerRepository = game.getPlayerRepository();
        Optional<Player> foundPlayer = playerRepository.findById(1L);
        return foundPlayer.orElseGet(Player::new);
    }

    public void playerDefault(){
        userInterface.healthLabelStat.setText(Integer.toString(getPlayer().getHealthPoints()));
        userInterface.insightLabelStat.setText(Integer.toString(getPlayer().getInsight()));
        userInterface.defenceLabelStat.setText(Integer.toString(getPlayer().getDefence()));
        userInterface.inspirationLabelStat.setText(Integer.toString(getPlayer().getInspiration()));
        userInterface.intelligenceLabelStat.setText(Integer.toString(getPlayer().getIntelligence()));
        userInterface.cashLabelStat.setText(Integer.toString(getPlayer().getCash()));
    }

    public void inventoryButtons(){
        Player player = getPlayer();
        if(player.getItems().get(1).isEquipped()){
            userInterface.inventory1.setText(player.getItems().get(1).getName());
        }
        if(player.getItems().get(2).isEquipped()){
            userInterface.inventory2.setText(player.getItems().get(2).getName());
        }
        if(player.getItems().get(3).isEquipped()){
            userInterface.inventory3.setText(player.getItems().get(3).getName());
        }
        if(player.getItems().get(4).isEquipped()){
            userInterface.inventory2.setText(player.getItems().get(4).getName());
        }
        if(player.getItems().get(5).isEquipped()){
            userInterface.inventory2.setText(player.getItems().get(5).getName());
        }
        if(player.getItems().get(6).isEquipped()){
            userInterface.inventory2.setText(player.getItems().get(6).getName());
        }
        if(player.getItems().get(7).isEquipped()){
            userInterface.inventory2.setText(player.getItems().get(7).getName());
        }
        if(player.getItems().get(8).isEquipped()){
            userInterface.inventory2.setText(player.getItems().get(8).getName());
        }
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

    public void breakdown(){
        ImageIcon townImage = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/breakdownimg.png");
        userInterface.imageLabel.setIcon(townImage);
        userInterface.locationTextArea.setText("Point Pleasant Town Centre");

        userInterface.mainTextArea.setText("You wake with a start, certain that you have crashed. You are sitting in the passenger seat. The morning sun blinds you through the windshield. The car is on the highway roadside with dusty fields on either side. The battery is dead. Ahead is a sign that reads 'Point Pleasant: 2km'. You step out of the car. What do you do?");

        userInterface.choice1.setText("Newspaper Office");
        userInterface.choice2.setText("Wait for a car to pass");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1 = "newspaperOffice";
        game.choiceButton2 = "hotelRoom";
        game.choiceButton3 = "petTheDog";
        game.choiceButton4 = "kissYourMother";
        game.choiceButton5 = "leaveTown";


//        getPlayer().setWeaponToEquipped(I);
    }
    public void enterTheTown(){
        ImageIcon townImage = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/point.jpeg");
        userInterface.imageLabel.setIcon(townImage);

        userInterface.mainTextArea.setText("Point Pleasant is a quiet town. A quiet fortitude lurks among the people. You wait by your parked car and decide what to do. Where to go next?");
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
        Player player = getPlayer();
        ImageIcon townImage = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/point.jpeg");
        userInterface.imageLabel.setIcon(townImage);

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

        player.takeDamage(20);
        player.setItemToEquipped(1);

        this.game.getPlayerRepository().save(player);
        userInterface.healthLabelStat.setText(Integer.toString(getPlayer().getHealthPoints()));

    }

    public void askAfterMary(){
        inventoryButtons();

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
