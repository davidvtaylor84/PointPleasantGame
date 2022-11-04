package com.pointpleasant.PointPleasantGame.game;


import com.pointpleasant.PointPleasantGame.models.Player;
import com.pointpleasant.PointPleasantGame.models.enemies.Enemy;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Item;
import com.pointpleasant.PointPleasantGame.models.inventory.weapons.Weapon;
import com.pointpleasant.PointPleasantGame.repositories.EnemyRepository;
import com.pointpleasant.PointPleasantGame.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
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

    public void defaultInventory(){
        Player player = getPlayer();
        player.getItems().get(0).setEquipped(false);
        player.getItems().get(1).setEquipped(false);
        player.getItems().get(2).setEquipped(false);
        player.getItems().get(3).setEquipped(false);
        player.getItems().get(4).setEquipped(false);
        player.getItems().get(5).setEquipped(false);
        player.getItems().get(6).setEquipped(false);
        player.getItems().get(7).setEquipped(false);
    }

    public void setPlayerDefault(){
        Player player = getPlayer();
        player.setHealthPoints(80);
        player.setInsight(0);
        player.setIntelligence(40);
        player.setInspiration(5);
        player.setCash(67);
        player.setGameProgress(0);
        defaultInventory();
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
        if(player.getItemByName("Army Uniform").isEquipped()){
            userInterface.inventory1.setText(player.getItemByName("Army Uniform").getName());
        }
        if(player.getItemByName("Energy Bar+").isEquipped()){
            userInterface.inventory2.setText(player.getItemByName("Energy Bar+").getName());
        }
        if(player.getItemByName("Average Energy Bar").isEquipped()){
            userInterface.inventory3.setText(player.getItemByName("Average Energy Bar").getName());
        }
        if(player.getItemByName("Mediocre Energy Bar").isEquipped()){
            userInterface.inventory4.setText(player.getItemByName("Mediocre Energy Bar+").getName());
        }
        if(player.getItemByName("Rusted Key").isEquipped()){
            userInterface.inventory5.setText(player.getItemByName("Rusted Key").getName());
        }
        if(player.getItemByName("Keycard").isEquipped()){
            userInterface.inventory6.setText(player.getItemByName("Keycard").getName());
        }
        if(player.getItemByName("Ammonite").isEquipped()){
            userInterface.inventory7.setText(player.getItemByName("Ammonnite").getName());
        }
        if(player.getItemByName("Windup Torch").isEquipped()){
            userInterface.inventory8.setText(player.getItemByName("Windup Torch").getName());
        }
    }

    public void weaponButtons(){
        Player player = getPlayer();
        if(player.getWeaponByName("Alloy Tube").isEquipped()){
            userInterface.weapon1.setText(player.getWeaponByName("Alloy Tube").getName());
        }
        if(player.getWeaponByName("Baseball Bat").isEquipped()){
            userInterface.weapon2.setText(player.getWeaponByName("Baseball Bat").getName());
        }
        if(player.getWeaponByName("Colt revolver").isEquipped()){
            userInterface.weapon3.setText(player.getWeaponByName("Colt revolver").getName());
        }
        if(player.getWeaponByName("M16").isEquipped()){
            userInterface.weapon4.setText(player.getWeaponByName("M16").getName());
        }
    }


    public void showInventoryItem(String itemName){
        Player player = getPlayer();
        if(player.getItemByName(itemName).isEquipped()){
            userInterface.inventoryDetailText.setText(player.getItemByName(itemName).getDescription());
        }
    }

    public void showWeaponItem(String weaponName){
        Player player = getPlayer();
        if(player.getWeaponByName(weaponName).isEquipped()){
            userInterface.inventoryDetailText.setText(player.getWeaponByName(weaponName).getDescription());
        }
    }





//    can make into an interface:
    public void selectChoice(String choiceButton){
        Player player = getPlayer();
        switch (choiceButton){
            case "newspaperOffice":newsPaperOffice(); break;
            case "hotelRoom": hotelRoom();break;
            case "petTheDog": petTheDog();break;
            case "kissYourMother": kissYourMother();break;
            case "leaveTown": leaveTown();break;
            case "askAfterMary": askAfterMary(); break;
            case "enterTheTown": enterTheTown();break;
            case "towardsShimmer": walkingTowardsShimmer();break;
            case "upCloseWithTheShimmer": upCloseWithShimmer();break;
            case "throughTheShimmer": throughTheShimmer(); break;
            case "waitForCar": waitForCar();break;

            case "getArmyUniform": showInventoryItem("Army Uniform");break;
            case "getEnergyBarPlus": showInventoryItem("Energy Bar+");break;
            case "getMediocreEnergyBar": showInventoryItem("Mediocre Energy Bar");break;
            case "getAverageEnergyBar": showInventoryItem("Average Energy Bar");break;
            case "getRustedKey": showInventoryItem("Rusted Key");break;
            case "getKeyCard": showInventoryItem("Keycard");break;
            case "getAmmonite": showInventoryItem("Ammonite");break;
            case "getWindupTorch": showInventoryItem("Windup Torch");break;

            case "getAlloyTube": showWeaponItem("Alloy Tube");break;
            case "getBaseballBat": showWeaponItem("Baseball Bat"); break;
            case "getColt": showWeaponItem("Colt"); break;
            case "getM16": showWeaponItem("M16"); break;
        }
    }

    public void breakdown(){
        Player player = getPlayer();
        getPlayerDefault();
        ImageIcon townImage = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/breakdownimg.png");
        userInterface.imageLabel.setIcon(townImage);
        userInterface.locationTextArea.setText("Point Pleasant Town Centre");

        userInterface.mainTextArea.setText("You wake with a start in the passenger seat, certain that you have crashed.  The morning sun blinds you through the windshield. The car is on the roadside. The battery is dead. As is your phone.\n\nAhead, a sign reads 'Point Pleasant: 2km'. Far down the road behind, you spot a shimmer above the asphalt. You step out of the car. What do you do?");

        userInterface.choice1.setText("Walk into town");
        userInterface.choice2.setText("Wait for a car to pass");
        userInterface.choice3.setText("Head towards the shimmer");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1 = "walkingIntoTown";
        game.choiceButton2 = "waitForCar";
        game.choiceButton3 = "towardsShimmer";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton1 = "getArmyUniform";
        game.inventoryButton2 = "getEnergyBarPlus";
        game.inventoryButton3 = "getMediocreEnergyBar";
        game.inventoryButton4 = "getAverageEnergyBar";
        game.inventoryButton5 = "getRustedKey";
        game.inventoryButton6 = "getKeyCard";
        game.inventoryButton7 = "getAmmonite";
        game.inventoryButton8 = "getWindupTorch";

        game.weapon1 = "getAlloyTube";
        game.weapon2 = "getBaseballBat";
        game.weapon3 = "getColt";
        game.weapon4 = "getM16";


        this.game.getPlayerRepository().save(player);
    }

    public void walkingTowardsShimmer(){
        Player player = getPlayer();
        getPlayerDefault();
        ImageIcon towardsshimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/towardsshimmer.jpeg");
        userInterface.imageLabel.setIcon(towardsshimmer);
        userInterface.locationTextArea.setText("Away from town");

        userInterface.mainTextArea.setText("As you draw closer to this metallic shimmer hovering a metre above the road, a strange fear tightens around your heart. The logical part of your brain tells you it is merely a mirage, though deep down, something inside is screaming that you should run from this thing as fast as possible.\n\nWhat do you do?");

        userInterface.choice1.setText("Head towards horror");
        userInterface.choice2.setText("Walk back into town");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1 = "upCloseWithTheShimmer";
        game.choiceButton2 = "walkingIntoTown";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton1 = "getArmyUniform";
        game.inventoryButton2 = "getEnergyBarPlus";
        game.inventoryButton3 = "getMediocreEnergyBar";
        game.inventoryButton4 = "getAverageEnergyBar";
        game.inventoryButton5 = "getRustedKey";
        game.inventoryButton6 = "getKeyCard";
        game.inventoryButton7 = "getAmmonite";
        game.inventoryButton8 = "getWindupTorch";

        game.weapon1 = "getAlloyTube";
        game.weapon2 = "getBaseballBat";
        game.weapon3 = "getColt";
        game.weapon4 = "getM16";

        this.game.getPlayerRepository().save(player);
    }

    public void upCloseWithShimmer(){
        Player player = getPlayer();
        getPlayerDefault();
        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/shimmer.jpeg");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("The shimmer");

        userInterface.mainTextArea.setText("You cannot comprehend what you are seeing. The air warps likes the surface of a body of water, refracting rainbow light. It gives off a freezing cold when you hold your hand up to it. Terror and curiousity are mixed in your gut. You feel sick.\n\nDo you you run or do you wish to proceed into the shimmer?");

        userInterface.choice1.setText("Put your head in");
        userInterface.choice2.setText("Head towards the town");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1 = "throughTheShimmer";
        game.choiceButton2 = "walkingIntoTown";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton1 = "getArmyUniform";
        game.inventoryButton2 = "getEnergyBarPlus";
        game.inventoryButton3 = "getMediocreEnergyBar";
        game.inventoryButton4 = "getAverageEnergyBar";
        game.inventoryButton5 = "getRustedKey";
        game.inventoryButton6 = "getKeyCard";
        game.inventoryButton7 = "getAmmonite";
        game.inventoryButton8 = "getWindupTorch";

        game.weapon1 = "getAlloyTube";
        game.weapon2 = "getBaseballBat";
        game.weapon3 = "getColt";
        game.weapon4 = "getM16";


        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void throughTheShimmer(){
        Player player = getPlayer();
        player.setInsight(1);
        inventoryButtons();
        weaponButtons();
        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/farbeyond.jpeg");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("$%£$8mg3g33$");

        userInterface.mainTextArea.setText("re$%44gg365&46;'][r[lkko397*&*^54587b69n8(*87b7t65534x243$x35 %4% ^ 65^5 Yy 8B& T^R F^%45*&*9(89*9u8644@$2%90}[{OoHkhhIy*&8&%6$ygURy£5£$28(&(re$%44gg365&46;'][r[lkko397*&*^54587b69n8(*87b7t65534x243$x35 %4% ^65^5 Yy 8B& T^R F^%45*&(\n\n(Insight has increased by +1)");

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1 = "walkingIntoTown";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton1 = "getArmyUniform";
        game.inventoryButton2 = "getEnergyBarPlus";
        game.inventoryButton3 = "getMediocreEnergyBar";
        game.inventoryButton4 = "getAverageEnergyBar";
        game.inventoryButton5 = "getRustedKey";
        game.inventoryButton6 = "getKeyCard";
        game.inventoryButton7 = "getAmmonite";
        game.inventoryButton8 = "getWindupTorch";

        game.weapon1 = "getAlloyTube";
        game.weapon2 = "getBaseballBat";
        game.weapon3 = "getColt";
        game.weapon4 = "getM16";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void waitForCar(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/roadside.jpeg");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Roadside");

        userInterface.mainTextArea.setText("You wait for an hour. No cars pass. Everything is still and quiet save for the gentle rustling of wind through the crops. You have drunk the remnants of your water bottle. You are now very hungry.");

        userInterface.choice1.setText("Walk into town");
        userInterface.choice2.setText("Head towards shimmer");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1 = "walkingIntoTown";
        game.choiceButton2 = "towardsShimmer";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton1 = "getArmyUniform";
        game.inventoryButton2 = "getEnergyBarPlus";
        game.inventoryButton3 = "getMediocreEnergyBar";
        game.inventoryButton4 = "getAverageEnergyBar";
        game.inventoryButton5 = "getRustedKey";
        game.inventoryButton6 = "getKeyCard";
        game.inventoryButton7 = "getAmmonite";
        game.inventoryButton8 = "getWindupTorch";

        game.weapon1 = "getAlloyTube";
        game.weapon2 = "getBaseballBat";
        game.weapon3 = "getColt";
        game.weapon4 = "getM16";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
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

        player.setItemToEquipped("Army Uniform");
        player.setWeaponToEquipped("Alloy Tube");
        player.setItemToEquipped("Rusted Key");
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

        game.inventoryButton1 = "getArmyUniform";
        game.inventoryButton2 = "getEnergyBarPlus";
        game.inventoryButton3 = "getMediocreEnergyBar";
        game.inventoryButton4 = "getAverageEnergyBar";
        game.inventoryButton5 = "getRustedKey";
        game.inventoryButton6 = "getKeyCard";
        game.inventoryButton7 = "getAmmonite";
        game.inventoryButton8 = "getWindupTorch";

        game.weapon1 = "getAlloyTube";
        game.weapon2 = "getBaseballBat";
        game.weapon3 = "getColt";
        game.weapon4 = "getM16";

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

        game.inventoryButton1 = "getArmyUniform";
        game.inventoryButton2 = "getEnergyBarPlus";
        game.inventoryButton3 = "getMediocreEnergyBar";
        game.inventoryButton4 = "getAverageEnergyBar";
        game.inventoryButton5 = "getRustedKey";
        game.inventoryButton6 = "getKeyCard";
        game.inventoryButton7 = "getAmmonite";
        game.inventoryButton8 = "getWindupTorch";

        game.weapon1 = "getAlloyTube";
        game.weapon2 = "getBaseballBat";
        game.weapon3 = "getColt";
        game.weapon4 = "getM16";

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
