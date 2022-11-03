package com.pointpleasant.PointPleasantGame.game;


import com.pointpleasant.PointPleasantGame.models.Player;
import com.pointpleasant.PointPleasantGame.models.enemies.Enemy;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Item;
import com.pointpleasant.PointPleasantGame.repositories.EnemyRepository;
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

    public Enemy getEnemy(Long id){
        EnemyRepository enemyRepository = game.getEnemyRepository();
        Optional<Enemy> foundEnemy = enemyRepository.findById(id);
        return foundEnemy.orElseGet(Enemy::new);
    }

    public void setPlayerDefault(){
        Player player = getPlayer();
        player.setHealthPoints(80);
        player.setInsight(0);
        player.setIntelligence(40);
        player.setInspiration(5);
        player.setCash(67);
        player.setGameProgress(0);
        player.getItems().get(1).setEquipped(false);
        player.getItems().get(2).setEquipped(false);
        player.getItems().get(3).setEquipped(false);
        player.getItems().get(4).setEquipped(false);
        player.getItems().get(5).setEquipped(false);
        player.getItems().get(6).setEquipped(false);
        player.getItems().get(7).setEquipped(false);
        player.getItems().get(8).setEquipped(false);
        this.game.getPlayerRepository().save(player);
    }

    public void getPlayerDefault(){
        Player player = getPlayer();
        userInterface.healthLabelStat.setText(Integer.toString(player.getHealthPoints()));
        userInterface.insightLabelStat.setText(Integer.toString(player.getInsight()));
        userInterface.defenceLabelStat.setText(Integer.toString(player.getDefence()));
        userInterface.inspirationLabelStat.setText(Integer.toString(player.getInspiration()));
        userInterface.intelligenceLabelStat.setText(Integer.toString(player.getIntelligence()));
        userInterface.cashLabelStat.setText(Integer.toString(player.getCash()));
    }

    public void inventoryButtons(){
        Player player = getPlayer();
        if(player.getItems().get(0).isEquipped()){
            userInterface.inventory1.setText(player.getItems().get(0).getName());
        }
        if(player.getItems().get(1).isEquipped()){
            userInterface.inventory2.setText(player.getItems().get(1).getName());
        }
        if(player.getItems().get(2).isEquipped()){
            userInterface.inventory3.setText(player.getItems().get(2).getName());
        }
        if(player.getItems().get(3).isEquipped()){
            userInterface.inventory4.setText(player.getItems().get(3).getName());
        }
        if(player.getItems().get(4).isEquipped()){
            userInterface.inventory5.setText(player.getItems().get(4).getName());
        }
        if(player.getItems().get(5).isEquipped()){
            userInterface.inventory6.setText(player.getItems().get(5).getName());
        }
        if(player.getItems().get(6).isEquipped()){
            userInterface.inventory7.setText(player.getItems().get(6).getName());
        }
        if(player.getItems().get(7).isEquipped()){
            userInterface.inventory8.setText(player.getItems().get(7).getName());
        }
    }

    public void weaponButtons(){
        Player player = getPlayer();
        if(player.getWeapons().get(0).isEquipped()){
            userInterface.weapon1.setText(player.getWeapons().get(0).getName());
        }
        if(player.getWeapons().get(1).isEquipped()){
            userInterface.weapon2.setText(player.getWeapons().get(1).getName());
        }
        if(player.getWeapons().get(2).isEquipped()){
            userInterface.weapon3.setText(player.getWeapons().get(2).getName());
        }
        if(player.getWeapons().get(3).isEquipped()){
            userInterface.weapon4.setText(player.getWeapons().get(3).getName());
        }
    }

    public void showItem1Description(){
        Player player = getPlayer();
        if(player.getWeapons().get(0).isEquipped()){
            userInterface.inventoryDetailText.setText(player.getItems().get(0).getDescription());
        } else{userInterface.inventoryDetailText.setText("No item in inventory slot");};
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
            case "getItem1": showItem1Description();break;
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
        player.takeDamage(20);
        player.setItemToEquipped(0);
        player.setWeaponToEquipped(2);
        player.setItemToEquipped(4);
//        Enemy bob = getAlienBob();
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



//        System.out.println(bob.getAttackPower());

        this.game.getPlayerRepository().save(player);

    }

    public void askAfterMary(){
        Player player = getPlayer();
        getPlayerDefault();
        inventoryButtons();
        weaponButtons();

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

        game.inventoryButton1 = "getItem1";
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
