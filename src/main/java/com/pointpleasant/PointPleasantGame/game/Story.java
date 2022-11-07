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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public Enemy getEnemyByName(String name){
        EnemyRepository enemyRepository = game.getEnemyRepository();
        Optional<Enemy> foundEnemy = enemyRepository.findByName(name);
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
        defaultInventory();
        Player player = getPlayer();
        player.setHealthPoints(38);
        player.setInsight(0);
        player.setDefence(10);
        player.setAttack(7);
        player.setInspiration(4);
        player.setCash(180);
        player.setGameProgress(0);
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
            userInterface.inventory4.setText(player.getItemByName("Mediocre Energy Bar").getName());
        }
        if(player.getItemByName("Rusted Key").isEquipped()){
            userInterface.inventory5.setText(player.getItemByName("Rusted Key").getName());
        }
        if(player.getItemByName("Keycard").isEquipped()){
            userInterface.inventory6.setText(player.getItemByName("Keycard").getName());
        }
        if(player.getItemByName("Ammonite").isEquipped()){
            userInterface.inventory7.setText(player.getItemByName("Ammonite").getName());
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

    public void continueGame(){
        Player player = getPlayer();
        if(player.getGameProgress()==0){
            breakdown();
            setPlayerDefault();
            visibilityManager.showIntroScreen();
        }else{youAwaken();
        }
        getPlayerDefault();
        inventoryButtons();
        weaponButtons();
        this.game.getPlayerRepository().save(player);
    }

    public void healthItem(String name){
        Player player = getPlayer();
        showInventoryItem(name);
        if(player.getItemByName(name).isEquipped()){
        player.useHealthBooster(name);
        player.unEquipItem(name);
        this.game.getPlayerRepository().save(player);
        showInventoryItem(name);
        inventoryButtons();
        }
    }



//    can make into an interface:
    public void selectChoice(String choiceButton){
        Player player = getPlayer();
        switch (choiceButton){
            case "breakdown": setPlayerDefault();breakdown();break;
            case "newspaperOffice":newsPaperOffice(); break;
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
            case "tellShopkeeper": tellShopkeeper();break;
            case "whatToBuy": whatToBuy();break;
            case "buyTorch": buyTorch();break;
            case "useShopkeepersPhone": useShopkeepersPhone(); break;
            case "earningMoneyAtShop": earningMoneyAtShop();break;
            case "chopLog": chopLog();break;
            case "enterCarGarage": enterCarGarage();break;
            case "tellMechanic": tellMechanic();break;
            case "useMechanicPhone": useMechanicPhone();break;
            case "maryTells": maryTells();break;
            case "maryTellsMore": maryTellsMore();break;
            case "maryTellsMoreAgain": maryTellsMoreAgain();break;
            case "enterDiner": enterDiner();break;
            case "beefTacos": beefTacos();break;
            case "usePhoneInDiner": usePhoneInDiner();break;
            case "talkToManInDiner":talkToManInDiner();break;
            case "marleeHotel": marleeHotel();break;
            case "hypnotist": hypnotist();break;
            case "hypnotised": hypnotised(); break;
            case "hypnotised2": hypnotised2();break;
            case "hypnotised3": hypnotised3();break;
            case "dumpsterEncounter": dumpsterEncounter();break;
            case "openBox": openBox();break;
            case "manInBlack": manInBlack();break;
            case "MIBAttacks": MIBAttacks();break;
            case "playerAttacksMIB": playerAttacksMIB();break;
            case "inspiredAttackAgainstMIB": inspiredAttackAgainstMIB();break;
            case "askAboutVadig": askAboutVadig();break;
            case "buyEnergyBar": buyEnergyBar();break;
            case "vadigsKey": vadigsKey();break;

            case "getArmyUniform": showInventoryItem("Army Uniform");break;
            case "getEnergyBarPlus": healthItem("Energy Bar+");userInterface.inventory2.setText("(Inventory slot 2)");break;
            case "getMediocreEnergyBar": healthItem("Mediocre Energy Bar");userInterface.inventory4.setText("(Inventory slot 4)");break;
            case "getAverageEnergyBar": healthItem("Average Energy Bar");userInterface.inventory3.setText("(Inventory slot 3)");break;
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
        Enemy enemy = getEnemy(1L);
        enemy.setHealthPoints(20);
        setPlayerDefault();
        getPlayerDefault();
        ImageIcon townImage = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/breakdownimg.png");

        userInterface.imageLabel.setIcon(townImage);
        userInterface.locationTextArea.setText("Outskirts of Town");

        userInterface.text = "You wake with a start in the passenger seat, certain that you have crashed. The morning sun blinds you through the windshield. The car is on the roadside. The battery is dead. As is your phone.\n\nAhead, a sign reads 'Point Pleasant: 2km'. Far down the road behind, you spot a shimmer above the asphalt. You step out of the car. What do you do?";
        userInterface.prepareText();

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
     this.game.getEnemyRepository().save(enemy);
    }

    public void walkingTowardsShimmer(){
        Player player = getPlayer();
        getPlayerDefault();
        ImageIcon towardsShimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/towardsshimmer.jpeg");
        userInterface.imageLabel.setIcon(towardsShimmer);
        userInterface.locationTextArea.setText("Away from town");

        userInterface.text = "As you draw closer to this metallic shimmer hovering a metre above the road, a strange fear tightens around your heart. The logical part of your brain tells you it is merely a mirage, though deep down, something inside is screaming that you should run from this thing as fast as possible.\n\nWhat do you do?";
        userInterface.prepareText();

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

        userInterface.text = "You cannot comprehend what you are seeing. The air warps likes the surface of a body of water, refracting rainbow light. It gives off a freezing cold when you hold your hand up to it. Terror and curiosity are mixed in your gut. You feel sick.\n\nDo you you run or do you wish to proceed into the shimmer?";
        userInterface.prepareText();


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

        userInterface.text = "re$%44gg365&46;'][r[lkko397*&*^54587b69n8(*87b7t65534x243$x35 %4%^65^5Yy8B& T^R F^%45*&*9(89*9u8644@$2%90}[{OoHkhhIy*&8&%6$ygURy£5£$28(&(re$%44gg365&46;'][r[lkko397*&*^54587b69n8(*87b7t65534x243$x35 %4%^65^5Yy8B&T^RF^%45*&(\n\n(Insight has increased by +1)";
        userInterface.prepareText();


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

        userInterface.text = "Again, you wake sitting in the passenger seat of your car. You quickly step out and look for the telltale shimmer in air above the road behind. This time there is nothing untoward above the asphalt.\n\nYou sigh, relieved, yet the feeling that you are still dreaming is hard to shake.\n\nWhat do you do?";
        userInterface.prepareText();

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

        userInterface.text ="You wait for an hour. No cars pass. Everything is still and quiet save for the gentle rustling of wind through the crops. You have drunk the remnants of your water bottle. You are now very hungry.";
        userInterface.prepareText();


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
        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/vadigEncounter.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Towards Point Pleasant");

        userInterface.text = "After walking for 20 minutes in the increasingly hot sun, a very tall man emerges from the scrub from the side of the road.\n\nHe waves and runs to you, grinning and laughing, his gait like that of a gazelle with a broken leg. In less time that you can think to react, he stands with his face very close to yours. His breath smells like almonds.";
        userInterface.prepareText();

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

        userInterface.text = "'Do not be afraid. The name's Vadig,' he says, in an unusually high-pitched sing-song, 'We are from a country much weaker than yours.'\n\nHe grabs you by the lapels and puts his hands in your pockets.\n\n'I require your cash for my own pleasure,' he adds.";
        userInterface.prepareText();

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

        userInterface.text = ("'This will not do,' he says. 'I was going to give you something special for your courage. Now I won't. You might still get it yet if you prove you can work hard. Thanks for the cash. Take this.'\n\nVadig hands over an Energy Bar(+25 HP) and ambles off down the road.");
        userInterface.prepareText();

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

        userInterface.text = "Vadig HP: "+enemy.getHealthPoints()+"\n\nYOUR D20 ATTACK ROLL: "+attackRoll+" vs VADIG DEFENCE RATING: "+enemy.getDefence()+"\n\nYou grapple with Vadig and inflict " + playerAttack+ " points of damage";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "vadigFightsBack";
        } else{
            game.choiceButton1 = "winOverVadig";
        }
        game.choiceButton2 = "";
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

        userInterface.text = "Vadig HP:"+enemy.getHealthPoints()+"\nYou used 1 point of Inspiration to add +8 damage to a successful or unsuccessful attack roll.\n\nD20 ATTACK ROLL: "+attackRoll+" vs VADIG DEFENCE RATING: "+enemy.getDefence()+"\nYou inflict " + damageTotal+ " points of damage.";
        userInterface.prepareText();

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

        userInterface.text = "Vadig giggles inanely as he tries to wrestle you to the ground.\n\nENEMY D20 ATTACK ROLL: "+attackRoll+" vs YOUR DEFENCE RATING: "+player.getDefence()+"\n\nVadig inflicts " + enemyAttack+ " points of damage";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("Inspired Attack");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(player.getHealthPoints()>0){
            game.choiceButton1 = "fightWithVadig";
            if(player.getInspiration()>0){
                game.choiceButton2 = "inspiredAttackAgainstVadig";}
            else {game.choiceButton2 = "";}
        } else{
            game.choiceButton1 = "breakdown";
            game.choiceButton2 = "";
        }

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

        userInterface.text = "Vadig falls to the ground and laughs.\n\n'Well done', he says. 'I had to test you for what is to come.'\n\nHe stands up slowly and hands you a rusted key. His height seems to have increased.";
        userInterface.prepareText();

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

        userInterface.text = "'You must visit my sister in library in town.'\n\nHe nods and runs off into the field before descending some unseen staircase hidden by scrub.\n\n(Rusted Key has been added to Inventory. +2 Defence. +3 Attack.)";
        userInterface.prepareText();

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

        userInterface.text = "You can find no sign of a staircase or door amidst the dirt and dried out cornstalks, only an Average Energy Bar(+20 HP) with a note attached that reads: 'Eat this if you are feeling weak. It can help.";
        userInterface.prepareText();

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
            userInterface.text = ("After walking for an hour, you enter Point Pleasant. It is small town, a population of around 4,000, according to the signage on approach. The main thoroughfare features thrift stores, bars, locally owned shops. You notice, after looking in a shop window, that your eyes are rimmed red and swollen.");
        } else {userInterface.text = "After walking for an hour, you enter Point Pleasant. It is small town, a population of around 4,000, according to the signage on approach. The main thoroughfare features thrift stores, bars, locally owned shops. You notice, after looking in a shop window, that your eyes are rimmed red and swollen.\n\nYou realise that your wallet is gone. You only have $4 in change.";}
        userInterface.prepareText();

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

        ImageIcon townImage = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/newtownsquare.png");
        userInterface.imageLabel.setIcon(townImage);

        userInterface.locationTextArea.setText("Point Pleasant");

        userInterface.text = "In the town square, you notice that you are being actively avoided, as if you are a symptom of psychosis. Everyone talks to one another in hushed tones. It is cold, with the grey shell of cloud threatening rain.\n\nA handful of shops and businesses are open. Most are closed. Where do you want to go?";
        userInterface.prepareText();

        userInterface.choice1.setText("Pleasant Store");
        userInterface.choice2.setText("Rita's Car Garage");
        userInterface.choice3.setText("Dynamite Diner");

        game.choiceButton1 = "enterLocalShop";
        game.choiceButton2 = "enterCarGarage";
        game.choiceButton3 = "enterDiner";

        if(player.getGameProgress()>=1){
            userInterface.choice4.setText("Point Pleasant Enquirer");
            game.choiceButton4 = "newspaperOffice";
        } else{userInterface.choice4.setText("");
            game.choiceButton4 = "";
        }
        if(player.getGameProgress()>=2){
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

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mainshopkeeper.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Pleasant Store");

        userInterface.text = "It is dry and dusty inside the store. The shelves are threadbare. The shopkeeper is a small man with no chin and thick glasses sitting in a chair to the side.You immediately erupt into a fit of coughing\n\nThe man ignores you, his head buried in a book entitled, 'The History of Glue'.";
        userInterface.prepareText();

        userInterface.choice1.setText("Tell Shopkeeper your story");
        userInterface.choice2.setText("What can I buy?");
        userInterface.choice3.setText("Can I use your phone?");
        userInterface.choice4.setText("Leave store");
        userInterface.choice5.setText("");

        game.choiceButton1= "tellShopkeeper";
        game.choiceButton2 = "whatToBuy";
        game.choiceButton3 = "useShopkeepersPhone";
        game.choiceButton4 = "theTownSquare";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void tellShopkeeper(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mainshopkeeper.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Pleasant Store");

        userInterface.text = "'A lot of strange things going on in town at the moment,' he says. 'I think it has something to do with the power plant three towns over. Leaking poisonous fumes or somethin, causing hallucinations. Might explain your eyes as well.'\n\nHe looks you up and down:'You gonna buy anything?'";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("What can I buy?");
        userInterface.choice3.setText("Can I use your phone?");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterLocalShop";
        game.choiceButton2 = "whatToBuy";
        game.choiceButton3 = "useShopKeepersPhone";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void useShopkeepersPhone(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mainshopkeeper.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Pleasant Store");

        userInterface.text = "The old man chuckles: 'I don't think so, sonny. Phone and internet service has been out for three days. You want to make contact with someone outside, the quickest way would be through post.'\n\n'Doesn't bother me much since I never use the internet, but I hear this is a mighty unusual occurrence.'";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("What can I buy?");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterLocalShop";
        game.choiceButton2 = "whatToBuy";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void whatToBuy(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mainshopkeeper.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Pleasant Store");

        userInterface.text = "The store is a mess of faded signage, old boardgames, machinery parts sitting on a table like pieces of abstract sculpture.\n\nYou are not interested in most of it, save for a nifty wind-up torch($30) that reminds you of something you had as a child.";
        userInterface.prepareText();


        userInterface.choice1.setText("< < <");

        userInterface.choice4.setText("Ask about earning money");
        userInterface.choice5.setText("");

        if(player.getItemByName("Windup Torch").isEquipped()) {
            userInterface.choice2.setText("");
            game.choiceButton2 = "";
        } else{
            userInterface.choice2.setText("Buy Torch($30)");
            game.choiceButton2 = "buyTorch";
        }

        if(player.getItemByName("Mediocre Energy Bar").isEquipped()) {
            userInterface.choice3.setText("");
            game.choiceButton3 = "";
        } else{
            userInterface.choice3.setText("Mediocre Energy Bar($2)");
            game.choiceButton3 = "buyEnergyBar";
        }

        game.choiceButton1="enterLocalShop";

        game.choiceButton4 = "earningMoneyAtShop";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void buyTorch(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mainshopkeeper.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Pleasant Store");

        if(player.getCash()>=30 && !player.getItemByName("Windup Torch").isEquipped()) {
            player.setCash(player.getCash() - 30);
            userInterface.text = "'There you go, sir, one torch,' he says. 'This is a classic.'\n\n(Windup Torch added to inventory. Cash -$30)";
            player.setItemToEquipped("Windup Torch");
        }else{userInterface.text = "'Not enough cash, hombre,' he mutters.\n\nHe sits down and continues reading his book, then looks up:'Got some logs need chopping out back if you want to earn $40'";}
        userInterface.prepareText();


        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("Chop logs");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterLocalShop";
        game.choiceButton2 = "earningMoneyAtShop";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void buyEnergyBar(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mainshopkeeper.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Pleasant Store");

        if(player.getCash()>=2 && !player.getItemByName("Mediocre Energy Bar").isEquipped()) {
            player.setCash(player.getCash() - 2);
            userInterface.text = "'There you go, sir, one crummy energy bar,' he says. 'You must be in dire straits.'\n\nR(Mediocre Energy Bar added to inventory(HP+15). Cash -$2)";
            player.setItemToEquipped("Mediocre Energy Bar");
        }else{userInterface.text = "'Not enough cash, hombre,' he mutters.\n\nHe sits down and continues reading his book, then looks up:'Got some logs need chopping out back if you want to earn $40'";}
        userInterface.prepareText();


        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("Chop logs");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterLocalShop";
        game.choiceButton2 = "earningMoneyAtShop";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void earningMoneyAtShop(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/liftaxe.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Chopping Wood");

        userInterface.choice1.setText("< < <");
        if(player.getCash()<42){
            userInterface.text = "You have followed him into the courtyard out through the back of the shop. Thigh-high rank weeds grow out of the cracks in the paving. A pile of wood sits next to the door.\n\n'I'll give you two dollars for every split log... up to $40,' he hastily adds. 'Well... what you waiting for?'";
            userInterface.choice2.setText("Chop Log");
            game.choiceButton2 = "chopLog";
        } else{userInterface.text = "'You've done the work,' he says. 'Can't quite do these things like I used to. You should go get some food at the diner across the road. The beef tacos are pretty good.'";
            userInterface.choice2.setText("");
            game.choiceButton2 = "";
        }
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");

        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");
        if(!player.getItemByName("Rusted Key").isEquipped()&&player.getCash()>40){
            game.choiceButton1 = "vadigsKey";
        } else {game.choiceButton1="enterLocalShop";
        }

        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void chopLog(){
        Player player = getPlayer();
        player.setCash(player.getCash()+2);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/axedrop.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Chopping Wood");

        userInterface.text = "The handle is greasy, the axehead is damn heavy and threatens to fly off completely. You strain to chop the wood as the old man watches on with a dumb grin on his face.\n\n(+$2 cash)";
        userInterface.prepareText();

        userInterface.choice1.setText("Lift axe");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="earningMoneyAtShop";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void vadigsKey(){
        Player player = getPlayer();
        player.setItemToEquipped("Rusted Key");
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/rustedkey.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Chopping Wood");

        userInterface.text = "You are exhausted from splitting these logs. As you split another nondescript piece of wood, something shiny erupts from its centre. You bend down and pick up an old rusted key.A tattered note attached to it reads: 'I told you I would reward your hard work. Very impressive. Vadig.\n\n(Rusted Key has been added to inventory";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterLocalShop";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void enterCarGarage(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mechanic.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Rita's Garage and Parts");

        userInterface.text = "You enter the garage.A woman in overalls is working on a disassembled Ford Cortina and glares at you suspiciously. She appears exhausted and has dark rings under her eyes as she hasn't slept in days.\n\n'Can I help you?' She says.";
        userInterface.prepareText();

        userInterface.choice1.setText("Tell her your car broke down");
        userInterface.choice2.setText("Can I use your phone?");
        userInterface.choice3.setText("Leave garage");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "tellMechanic";
        game.choiceButton2 = "useMechanicPhone";
        game.choiceButton3 = "theTownSquare";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void tellMechanic(){
        Player player = getPlayer();
        player.setGameProgress(1);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mechanic.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Rita's Garage and Parts");

        userInterface.text = "'Well that's a mighty sad story,' she mutters.'Happening with increasing frequency around here, but I don't see how it's my problem.'\n\nShe ponders for a moment, then:'Maybe go see Mary at the newspaper offices. She's good with cars and has a thing for charity cases like yours.'";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("Can I use your phone?");
        userInterface.choice3.setText("Leave garage");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "enterCarGarage";
        game.choiceButton2 = "useMechanicPhone";
        game.choiceButton3 = "theTownSquare";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void useMechanicPhone(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mechanic.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Rita's Garage and Parts");

        userInterface.text = "'Can't just wander into town and demand things.'\n\nShe sighs and apologises: 'I'm sorry. There's been many a stranger come into down recently. Some may be regular folks, others turn out to be lunatics. I don't know you, so even if the phone was working it would still be a no.";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("Tell her your car broke down");
        userInterface.choice3.setText("Leave garage");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "enterCarGarage";
        game.choiceButton2 = "tellMechanic";
        game.choiceButton3 = "theTownSquare";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void newsPaperOffice(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/maryHyre2.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        userInterface.text = "You enter the offices of the Point Pleasant Enquirer located in a converted mobile home in a lot off the main square. It is surprisingly bright and airy inside. The sole journalist in the office stands up when she notices your wild look\n\n'Aha!' She says.'You've seen them too!'";
        userInterface.prepareText();

        userInterface.choice1.setText("What are you talking about?");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="maryTells";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void maryTells(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/maryHyre2.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        userInterface.text = "'Let me guess,' she says. 'You suspect you fell asleep at the wheel of your and you woke up in the morning at the side of the road.'\n\n'It's happened a bunch of times over the past few weeks, ever since everything started going crazy round here. Kooks and soldiers showing up and whatnot.'";

        userInterface.choice1.setText("Tell me more");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="maryTellsMore";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void maryTellsMore(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/ufo2.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        userInterface.text = "'Can I show you a video?' She says.\n\nWithout waiting for a reply she plays you a video on her phone of a large pill-shaped object floating above the desert outside Point Pleasant.\n\n'Does this look familiar?'";
        userInterface.prepareText();

        userInterface.choice1.setText("Shrug");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="maryTellsMoreAgain";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void maryTellsMoreAgain(){
        Player player = getPlayer();
        player.setGameProgress(2);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/maryHyre2.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        userInterface.text = "Although the import of the video is not immediately obvious, something about this UFO footage resonates makes your stomach drop.\n\n'If you would like to find out more, come see me at the Marlee Hotel later on. I have a hypnotist friend staying there helping people like you recover lost memories.'";
        userInterface.prepareText();

        userInterface.choice1.setText("Ask about Vadig");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="askAboutVadig";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void askAboutVadig(){
        Player player = getPlayer();
        player.setGameProgress(2);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/maryHyre2.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        userInterface.text = "'Your description of this man doesn't ring any bells,' she says, 'but we have had incidents in the town in recent days where strange men and women turn up trying to convince people that that they are local. They say that their sister works in the library, which doesn't make sense. The library shut down three years ago.'";
        userInterface.prepareText();

        userInterface.choice1.setText("Leave");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="theTownSquare";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void enterDiner(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/dinerMain.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Dynamite Diner");

        userInterface.text = "The diner is quiet. The owner, or owner, sits behind the counter doing a crossword. She doesn't look up.\n\nA man sitting in one of the booths perks up at your entrance. Like you, his hair is wild and his eyes are red and swollen. He tries to catch your eye and weakly smiles.";
        userInterface.prepareText();

        userInterface.choice1.setText("Order Beef Tacos($7)");
        userInterface.choice2.setText("Talk to man");
        userInterface.choice3.setText("Ask to use phone");
        userInterface.choice4.setText("Leave");
        userInterface.choice5.setText("");

        game.choiceButton1="beefTacos";
        game.choiceButton2 = "talkToManInDiner";
        game.choiceButton3 = "usePhoneInDiner";
        game.choiceButton4 = "theTownSquare";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void beefTacos(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/dinerMain.png");
        ImageIcon image2 = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/beeftacos.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Dynamite Diner");

        if(player.getCash()>=7){
            player.setCash(getPlayer().getCash()-7);
            player.setHealthPoints(getPlayer().getHealthPoints()+10);
            userInterface.text = "These are the worst beef tacos you've ever eaten, but they are somewhat nutritious.\n\n(HP +10. CASH -7)";
            userInterface.imageLabel.setIcon(image2);
        } else{userInterface.text = "You don't have enough cash. Maybe try doing some work.";}
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("Talk to man");
        userInterface.choice3.setText("Ask to use phone");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterDiner";
        game.choiceButton2 = "talkToManInDiner";
        game.choiceButton3 = "usePhoneInDiner";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void usePhoneInDiner(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/dinerMain.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Dynamite Diner");

        userInterface.text = "'Sorry, sugar,' says the waitress.'Phones are all busted in this stupid town. Everything has gone to hell. Even the beef we're getting is all weird. Something to do with the cattle mutilations I reckon.'\n\n'I gotta get out of this place,' she adds.";
        userInterface.prepareText();

        userInterface.choice1.setText("Order Beef Tacos($7)");
        userInterface.choice2.setText("Talk to man");
        userInterface.choice3.setText("< < <");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="beefTacos";
        game.choiceButton2 = "talkToManInDiner";
        game.choiceButton3 = "enterDiner";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void talkToManInDiner(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/realdinerman.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Dynamite Diner");

        if(player.getInsight()>=2){
        userInterface.text = ("'Now you know', the man says. It's as if he has been waiting for you.'Maybe you're a braver man than I. There's something out back of this diner that frightens me more than anything in this world. A man that isn't a man. A box...'\n\nAt this he breaks off into a fit of giggles and says no more.");
            userInterface.choice2.setText("Go out the back door");
            game.choiceButton2 = "dumpsterEncounter";

        }else{userInterface.text = "The man looks more crazed up close. His hands shake, jittering the surface of his black coffee.\n\n'You think you know but you don't,' he whispers without looking up. 'Not yet. I can see it in your eyes.'\n(2 Insight Required)";
            userInterface.choice2.setText("");
            game.choiceButton2 = "";
        }
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");

        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterDiner";

        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void marleeHotel(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/marleeHotel.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("The Marlee Hotel");

        if(player.getInsight()<2) {
            userInterface.text = "You enter the hushed lobby of the hotel. Everything in here is still, quiet and dusty. A sense of faded grandeur lingers in the immense paintings of Civil War battles and ornate chandeliers, yet the place smells of mildew.\n\nAbruptly, Mary Hyre appears and tells you how glad she is that you have come.";
            userInterface.choice1.setText("Go with her");
            game.choiceButton1="hypnotist";
        }else {userInterface.text = "You enter the hushed lobby of the hotel. Everything in here is still, quiet and dusty. A sense of faded grandeur lingers in the immense paintings of Civil War battles and ornate chandeliers, yet the place smells of mildew.";
            userInterface.choice1.setText("");
            game.choiceButton1="";
        }
        userInterface.prepareText();

        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");


        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void hypnotist(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/hypnotist1.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("The Marlee Hotel");

        userInterface.text = "You follow her into a bedroom on the first where a man in long jacket sits on an armchair by the window. His eyes are very large. He motions for you to sit on the chair opposite his.\n\n'I believe you are another experiencer,' he says. 'Do you consent to be hypnotised so we can help you discover the truth?'";
        userInterface.prepareText();

        userInterface.choice1.setText("Be hypnotised");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="hypnotised";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void hypnotised(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/hypnotist2.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("The Marlee Hotel");

        userInterface.text = "The gentleman waves his pocket watch in front of your eyes, as Mary Hyre sits on the bed and observes. No noise can be heard from outside the room. Only the hypnotist's sonorous voice as he counts down from 3...2...1";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="hypnotised2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void hypnotised2(){
        Player player = getPlayer();
        player.setInsight(getPlayer().getInsight()+2);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/presents.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("The Marlee Hotel");

        userInterface.text = "You see yourself driving along the highway at night, suddenly struck by a blinding light in the sky... a sensation of floating... a tall winged creature with red eyes lurking in the trees attacked by men with guns. However surreal these sensations and images, the one that sticks most is of Christmas presents floating in the water.\n(Insight increased by +2)";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="hypnotised3";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void hypnotised3(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/hyreInRoom.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("The Marlee Hotel");

        userInterface.text = "Upon waking, you tell Mary Hyre and the hypnotist what you experienced.\n\n'This is the most promising candidate yet,'Mary says to her companion and to you, 'You saw the Mothman! Please come back to the office later and I'll explain everything.'";
        userInterface.prepareText();

        userInterface.choice1.setText("Leave");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="theTownSquare";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void dumpsterEncounter(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/dumpster2.jpeg");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Dumpster Encounter");

        userInterface.text = "Behind the diner is a small lot filled with trash and overgrown weeds. Nothing appears untoward. You approach the dumpster filled with food waste and find a small ornate wooden box attached to the wall with a chain. It is very out of place.\n\nYou pick it up. A heart is carved onto the lid.";
        userInterface.prepareText();

        userInterface.choice1.setText("Leave");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterDiner";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton5 = "openBox";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void openBox(){
        Player player = getPlayer();
        player.setItemToEquipped("Ammonite");
        player.setInsight(getPlayer().getInsight()+1);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/ammonite.jpeg");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Dumpster Encounter");

        userInterface.text = "You unlock the box with the Rusted Key. Within is an ammonite fossil. A plunging sensation move through your body. A mental image of the Mothman, red eyes gleaming from a glass enclosure enshrouded by smoke. It feels like your brain is going to crack.\n\n(Insight increased by +1. Ammonite added to Inventory)";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="manInBlack";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton5 = "getRustedKey";
//        game.inventoryButton5 = "openBox";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void manInBlack(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/manInBlack.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Dumpster Encounter");

        userInterface.text = "'We demand that you must and will give us the object', says a squeaking voice behind you.\n\nYou turn and are confronted by an incredibly broad man in black trenchcoat and black fedora blocking the door to the diner.Quicker than humanly possible, he lunges towards you.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="MIBAttacks";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void MIBAttacks() {
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("agentK");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int enemyAttack = enemy.attackPlayer(player.getDefence(), attackRoll);

        player.takeDamage(enemyAttack);

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/black3.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Fight against MIB");

        userInterface.text = "MIB swings his immense fists down on your head.\n\nENEMY D20 ATTACK ROLL: " + attackRoll + " vs YOUR DEFENCE RATING: " + player.getDefence() + "\n\nMIB inflicts " + enemyAttack + " points of damage";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("Inspired Attack");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if (player.getHealthPoints() > 0) {
            game.choiceButton1 = "playerAttacksMIB";
            if(player.getInspiration()>0){
                game.choiceButton2 = "inspiredAttackAgainstMIB";}
        } else {
            game.choiceButton1 = "youAwaken";
            game.choiceButton2 = "youAwaken";
            player.unEquipItem("Ammonite");
            player.setHealthPoints(20);
            enemy.setHealthPoints(40);
        }

        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void playerAttacksMIB(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("agentK");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int playerAttack = player.attackEnemy(enemy.getDefence(), attackRoll);

        enemy.takeDamage(playerAttack);

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/black2.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Fight against MIB");

        userInterface.text = "MIB HP: "+enemy.getHealthPoints()+"\n\nYOUR D20 ATTACK ROLL: "+attackRoll+" vs MIB DEFENCE RATING: "+enemy.getDefence()+"\n\nYou grapple with MIB and inflict " + playerAttack+ " points of damage";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "MIBAttacks";
        } else{
            game.choiceButton1 = "winOverMIB";
        }
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void inspiredAttackAgainstMIB(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("agentK");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int roll = player.attackEnemy(enemy.getDefence(), attackRoll);

        int damageTotal = roll +8;

        enemy.takeDamage(damageTotal);

        player.setInspiration(player.getInspiration()-1);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/black1.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with MIB");

        userInterface.text = "MIB HP:"+enemy.getHealthPoints()+"\nYou used 1 point of Inspiration to add +8 damage to a successful or unsuccessful attack roll.\n\nD20 ATTACK ROLL: "+attackRoll+" vs MIB DEFENCE RATING: "+enemy.getDefence()+"\nYou inflict " + damageTotal+ " points of damage.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "MIBAttacks";
        } else{
            game.choiceButton1 = "winOverMIB";
        }
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void youAwaken(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/youAwaken.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("You awaken");

        userInterface.text = "You wake in an alleyway off the main square shaking off troubling dreams featuring a winged creature with glowing red eyes. You were not aware of losing consciousness, as if some outside force has some terrible hold over your destiny.";
        userInterface.prepareText();

        userInterface.choice1.setText("Leave alleyway");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="theTownSquare";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }


}
