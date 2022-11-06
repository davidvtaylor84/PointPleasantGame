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
        player.setDefence(10);
        player.setAttack(7);
        player.setInspiration(5);
        player.setCash(180);
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
        userInterface.intelligenceLabelStat.setText(Integer.toString(player.getAttack()));
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
            case "enteringTheTown": enteringTheTown();break;
            case "towardsShimmer": walkingTowardsShimmer();break;
            case "upCloseWithTheShimmer": upCloseWithShimmer();break;
            case "throughTheShimmer": player.setInsight(1);game.getPlayerRepository().save(player);throughTheShimmer(); break;
            case "waitForCar": waitForCar();break;
            case "walkingIntoTown": headingIntoTown();break;
            case "encounterWithVadig": encounterWithVadig(); break;
            case "fightWithVadig": battleWithVadig();break;
            case "vadigFightsBack": vadigFightsBack();break;
            case "winOverVadig": winOverVadig(); break;
            case "afterShimmer": afterShimmer(); break;
            case "winOverVadig2": winOverVadig2();break;
            case "giveVadigMoney":giveVadigMoney();break;
            case "fieldInvestigation": player.setItemToEquipped("Average Energy Bar");game.getPlayerRepository().save(player);fieldInvestigation();break;
            case "inspiredAttackAgainstVadig": inspiredAttackAgainstVadig();break;
            case "theTownSquare": theTownSquare();break;
            case "enterLocalShop": enterLocalShop();break;

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
        setPlayerDefault();
        getPlayerDefault();
        ImageIcon townImage = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/breakdownimg.png");
        userInterface.imageLabel.setIcon(townImage);
        userInterface.locationTextArea.setText("Point Pleasant Town Centre");

        userInterface.mainTextArea.setText("You wake with a start in the passenger seat, certain that you have crashed. The morning sun blinds you through the windshield. The car is on the roadside. The battery is dead. As is your phone.\n\nAhead, a sign reads 'Point Pleasant: 2km'. Far down the road behind, you spot a shimmer above the asphalt. You step out of the car. What do you do?");

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
        game.inventoryButton3 = "getAverageEnergyBar";
        game.inventoryButton4 = "getMediocreEnergyBar";
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
        ImageIcon towardsShimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/towardsshimmer.jpeg");
        userInterface.imageLabel.setIcon(towardsShimmer);
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

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void throughTheShimmer(){
        Player player = getPlayer();
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

        game.choiceButton1 = "afterShimmer";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void afterShimmer(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();


        ImageIcon townImage = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/breakdownwake.png");
        userInterface.imageLabel.setIcon(townImage);
        userInterface.locationTextArea.setText("Wake Up");

        userInterface.mainTextArea.setText("Again, you wake sitting in the passenger seat of your car. You quickly step out and look for the telltale shimmer in air above the road behind. This time there is nothing untoward above the asphalt.\n\nYou sigh, relieved, yet the feeling that you are still dreaming is hard to shake.\n\nWhat do you do?");

        userInterface.choice1.setText("Walk into town");
        userInterface.choice2.setText("Wait for a car to pass");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1 = "walkingIntoTown";
        game.choiceButton2 = "waitForCar";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void waitForCar(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/breakdownwake.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Roadside");

        userInterface.mainTextArea.setText("You wait for an hour. No cars pass. Everything is still and quiet save for the gentle rustling of wind through the crops. You have drunk the remnants of your water bottle. You are now very hungry.");

        userInterface.choice1.setText("Walk into town");
        if(player.getInsight()==0){
        userInterface.choice2.setText("Head towards shimmer");}
        else {userInterface.choice2.setText("");}
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1 = "walkingIntoTown";
        if(player.getInsight()==0){
            game.choiceButton2 = "towardsShimmer";
        } else {game.choiceButton2 = "";}
        game.choiceButton2 = "towardsShimmer";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }


    public void headingIntoTown(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();
        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/encountervadig.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Towards Point Pleasant");

        userInterface.mainTextArea.setText("After walking for 20 minutes in the increasingly hot sun, a very tall man emerges from the scrub from the side of the road.\n\nHe waves and runs to you, grinning and laughing, his gait like that of a gazelle with a broken leg. In less time that you can think to react, he stands with his face very close to yours. His breath smells like almonds.");

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1 = "encounterWithVadig";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }


    public void encounterWithVadig(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();
        ImageIcon shimmer = new ImageIcon("/Users/charlesvaldez/codeclan_work/capstone/PointPleasantGame/src/main/java/com/pointpleasant/PointPleasantGame/game/resources/vadig.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Vadig");

        userInterface.mainTextArea.setText("'Do not be afraid. The name's Vadig,' he says, in an unusually high-pitched sing-song, 'We are from a country much weaker than yours.'\n\nHe grabs you by the lapels and puts his hands in your pockets.\n\n'I require your cash for my own pleasure,' he adds.\n\n");

        userInterface.choice1.setText("Fight him off");
        userInterface.choice2.setText("Let him take your money");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1 = "fightWithVadig";
        game.choiceButton2 = "giveVadigMoney";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void giveVadigMoney(){
        Player player = getPlayer();
        player.setCash(0);
        player.setItemToEquipped("Energy Bar+");
        inventoryButtons();
        weaponButtons();
        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/vadigTakes.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Vadig Takes Your Money");

        userInterface.mainTextArea.setText("'This will not do,' he says. 'I was going to give you something for your courage. Now I won't. Use this if you ever get into a fight. Thanks for the cash.'\n\nVadig hands over a Mediocre Energy Bar(+10 HP) and walks away from you down the road.");

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1 = "enteringTheTown";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void battleWithVadig(){
        Player player = getPlayer();
        Enemy enemy = getEnemy(1L);
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int playerAttack = player.attackEnemy(enemy.getDefence(), attackRoll);

        enemy.takeDamage(playerAttack);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/grappleVadig.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with Vadig");

        userInterface.mainTextArea.setText("Vadig HP: "+enemy.getHealthPoints()+"\n\nYOUR D20 ATTACK ROLL: "+attackRoll+" vs VADIG DEFENCE RATING: "+enemy.getDefence()+"\n\nYou grapple with Vadig and inflict " + playerAttack+ " points of damage");

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("Inspired Attack");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "vadigFightsBack";
            if(player.getInspiration()>0){
                game.choiceButton2 = "inspiredAttackAgainstVadig";}
            else {game.choiceButton2 = "";}
        } else{
            game.choiceButton1 = "winOverVadig";
            game.choiceButton2 = "";
        }
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void inspiredAttackAgainstVadig(){
        Player player = getPlayer();
        Enemy enemy = getEnemy(1L);
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int roll = player.attackEnemy(enemy.getDefence(), attackRoll);

        int damageTotal = roll +8;

        enemy.takeDamage(damageTotal);

        player.setInspiration(player.getInspiration()-1);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/grappleVadig.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with Vadig");

        userInterface.mainTextArea.setText("Vadig HP:"+enemy.getHealthPoints()+"\nYou used 1 point of Inspiration to add +8 damage to a successful or unsuccessful attack roll.\n\nD20 ATTACK ROLL: "+attackRoll+" vs VADIG DEFENCE RATING: "+enemy.getDefence()+"\nYou inflict " + damageTotal+ " points of damage.");

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "vadigFightsBack";
        } else{
            game.choiceButton1 = "winOverVadig";
            userInterface.choice2.setText("");
        }
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void vadigFightsBack(){
        Player player = getPlayer();
        Enemy enemy = getEnemy(1L);
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int enemyAttack = enemy.attackPlayer(player.getDefence(), attackRoll);

        player.takeDamage(enemyAttack);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/newvadigfights.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with Vadig");

        userInterface.mainTextArea.setText("Vadig giggles inanely as he tries to wrestle you to the ground.\n\nENEMY D20 ATTACK ROLL: "+attackRoll+" vs YOUR DEFENCE RATING: "+player.getDefence()+"\n\nVadig inflicts " + enemyAttack+ " points of damage");

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(player.getHealthPoints()>0){
            game.choiceButton1 = "fightWithVadig";
        } else{
            game.choiceButton1 = "youDie";
        }
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void winOverVadig(){
        Player player = getPlayer();
        player.setItemToEquipped("Rusted Key");
        player.setDefence(player.getDefence()+2);
        player.setAttack(player.getAttack()+3);
        inventoryButtons();
        weaponButtons();

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/vadiglaughing.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Highway fight aftermath");

        userInterface.mainTextArea.setText("Vadig falls to the ground and laughs.\n\n'Well done', he says. 'I had to test you for what is to come.'\n\nHe stands up slowly and hands you a rusted key. His height seems to have increased.");

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="winOverVadig2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }


    public void winOverVadig2(){
        Player player = getPlayer();
        player.setCash(4);
        inventoryButtons();
        weaponButtons();

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/vadiglaughing.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Highway fight aftermath");

        userInterface.mainTextArea.setText("'You must visit my sister in library in town.'\n\nHe nods and runs off into the field before descending some unseen staircase hidden by scrub.\n\n(Rusted Key has been added to Inventory. +2 Defence. +3 Attack.)");

        userInterface.choice1.setText("On to Point Pleasant");
        userInterface.choice2.setText("Investigate field");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enteringTheTown";
        game.choiceButton2 = "fieldInvestigation";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void fieldInvestigation(){
        Player player = getPlayer();
        player.setItemToEquipped("Average Health Bar");
        player.setCash(4);
        inventoryButtons();
        weaponButtons();

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/emptyField.jpeg");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Investigate Field");

        userInterface.mainTextArea.setText("You can find no sign of a staircase or door amidst the dirt and dried out cornstalks, only an Average Energy Bar(+20 HP) with a note attached that reads: 'Eat this during your next fight. It can help.");

        userInterface.choice1.setText("On to Point Pleasant");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enteringTheTown";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }


    public void enteringTheTown(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon townImage = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/pleasantMain.png");
        userInterface.imageLabel.setIcon(townImage);

        userInterface.locationTextArea.setText("Welcome to Point Pleasant");

        if(player.getCash()==0) {
            userInterface.mainTextArea.setText("After walking for an hour, you enter Point Pleasant. It is small town, a population of around 4,000, according to the signage on approach. The main thoroughfare features thrift stores, bars, locally owned shops. You notice, after looking in a shop window, that your eyes are rimmed red and swollen.");
        } else {userInterface.mainTextArea.setText("After walking for an hour, you enter Point Pleasant. It is small town, a population of around 4,000, according to the signage on approach. The main thoroughfare features thrift stores, bars, locally owned shops. You notice, after looking in a shop window, that your eyes are rimmed red and swollen.\n\nYou realise that your wallet is gone. You only have $4 in change.");}

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");


        game.choiceButton1 = "theTownSquare";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void theTownSquare(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon townImage = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/townsquare.png");
        userInterface.imageLabel.setIcon(townImage);

        userInterface.locationTextArea.setText("Point Pleasant");

        userInterface.mainTextArea.setText("In the town square, you notice that you are being actively avoided, as if you are a symptom of psychosis. Everyone talks to one another in hushed tones. It is cold, with the grey shell of cloud threatening rain.\n\nA handful of shops and businesses are open. Most are closed. Where do you want to go?");

        userInterface.choice1.setText("Local Shop");
        userInterface.choice2.setText("Car Garage");
        userInterface.choice3.setText("Diner");

        game.choiceButton1 = "enterLocalShop";
        game.choiceButton2 = "enterCarGarage";
        game.choiceButton3 = "enterDiner";

        if(player.getGameProgress()==1){
            userInterface.choice4.setText("Point Pleasant Enquirer");
            game.choiceButton4 = "newspaperOffice";
        } else{userInterface.choice4.setText("");
            game.choiceButton4 = "";
        }
        if(player.getGameProgress()==2){
            userInterface.choice5.setText("The Marlee Hotel");
            game.choiceButton5 = "marleeHotel";
        } else{userInterface.choice5.setText("");
            game.choiceButton5 = "";}

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void enterLocalShop(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/shopkeeper.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Pleasant Store");

        userInterface.mainTextArea.setText("It is dry and dusty inside the store. The shelves are threadbare. The shopkeeper is a small man with no chin and thick glasses sitting in a chair to the side.\n\nYou immediately erupt into a fit of coughing\n\nThe man ignores you, his head buried in a book entitled, 'The History of Glue'.");

        userInterface.choice1.setText("Tell Shopkeeper your story");
        userInterface.choice2.setText("What can I buy?");
        userInterface.choice3.setText("Can I use your phone?");
        userInterface.choice4.setText("Leave store");
        userInterface.choice5.setText("");

        game.choiceButton1= "tellShopkeeper";
        game.choiceButton2 = "whatToBuy";
        game.choiceButton3 = "useShopKeepersPhone";
        game.choiceButton4 = "theTownSquare";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void tellShopkeeper(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/shopkeeper.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Pleasant Store");

        userInterface.mainTextArea.setText("It is dry and dusty inside the store. The shelves are threadbare. The shopkeeper is a small man with no chin and thick glasses sitting in a chair to the side.\n\nYou immediately erupt into a fit of coughing\n\nThe man ignores you, his head buried in a book entitled, 'The History of Glue'.");

        userInterface.choice1.setText("Tell Shopkeeper your story");
        userInterface.choice2.setText("What can I buy?");
        userInterface.choice3.setText("Can I use your phone?");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="tellShopkeeper";
        game.choiceButton2 = "whatToBuy";
        game.choiceButton3 = "useShopKeepersPhone";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
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
