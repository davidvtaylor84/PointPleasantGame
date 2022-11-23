package com.pointpleasant.PointPleasantGame.game;


import com.pointpleasant.PointPleasantGame.models.Player;
import com.pointpleasant.PointPleasantGame.models.enemies.Enemy;
import com.pointpleasant.PointPleasantGame.repositories.EnemyRepository;
import com.pointpleasant.PointPleasantGame.repositories.PlayerRepository;

import javax.swing.*;
import java.util.Optional;

public class Story {

    Game game;
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

    public void setPlayerDefault(){
        Player player = getPlayer();
        player.setMaxHealthPoints(40);
        player.setHealthPoints(38);
        player.setInsight(0);
        player.setDefence(8);
        player.setAttack(7);
        player.setInspiration(4);
        player.setCash(180);
        player.setGameProgress(0);
        player.getItems().get(0).setEquipped(false);
        player.getItems().get(1).setEquipped(false);
        player.getItems().get(2).setEquipped(false);
        player.getItems().get(3).setEquipped(false);
        player.getItems().get(4).setEquipped(false);
        player.getItems().get(5).setEquipped(false);
        player.getItems().get(6).setEquipped(false);
        player.getItems().get(7).setEquipped(false);
        player.getWeaponByName("Alloy Tube").setEquipped(false);
        player.getWeaponByName("Baseball Bat").setEquipped(false);
        player.getWeaponByName("Colt revolver").setEquipped(false);
        player.getWeaponByName("M16").setEquipped(false);
        this.game.getPlayerRepository().save(player);
    }

    public void setEnemyDefault(){
        Enemy enemy1 = getEnemyByName("Vadig");
        Enemy enemy2 = getEnemyByName("agentK");
        Enemy enemy3 = getEnemyByName("Hank");
        Enemy enemy4 = getEnemyByName("x42");
        Enemy enemy5 = getEnemyByName("John Hell");
        Enemy enemy6 = getEnemyByName("General Chambers");
        Enemy enemy7 = getEnemyByName("Phone");
        enemy1.setHealthPoints(20);
        enemy2.setHealthPoints(30);
        enemy3.setHealthPoints(50);
        enemy4.setHealthPoints(40);
        enemy5.setHealthPoints(40);
        enemy6.setHealthPoints(60);
        enemy7.setHealthPoints(150);
        this.game.getEnemyRepository().save(enemy1);
        this.game.getEnemyRepository().save(enemy2);
        this.game.getEnemyRepository().save(enemy3);
        this.game.getEnemyRepository().save(enemy4);
        this.game.getEnemyRepository().save(enemy5);
        this.game.getEnemyRepository().save(enemy6);
        this.game.getEnemyRepository().save(enemy7);
    }

    public void getPlayerDefault(){
        Player player = getPlayer();
        userInterface.maxHealthLabelStat.setText(Integer.toString(player.getMaxHealthPoints()));
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
        }else if(player.getGameProgress()>=6){
            youAwakenInTheBedFactory();
            if(player.getHealthPoints()<=0){
                player.setHealthPoints(10);
            }}
        else {youAwaken();
            if(player.getHealthPoints()<=0){
                player.setHealthPoints(20);
            }
        }
        getPlayerDefault();
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
            case "buyBaseballBat": buyBaseballBat();break;
            case "attacksWithBat": attacksWithBat();break;
            case "arrested": arrested();break;
            case "winOverMIB": winOverMIB();break;
            case "jailed": jailed();break;
            case "jailed2": jailed2();break;
            case "jailed3": jailed3();break;
            case "waitForMary": waitForMary();break;
            case "waitForMary2": waitForMary2();break;
            case "waitForMary3": waitForMary3();break;
            case "library": library();break;
            case "library2": library2();break;
            case "library3": library3();break;
            case "library4": library4();break;
            case "toMarysHouse": toMarysHouse();break;
            case "marysHouse": marysHouse();break;
            case "enterMarysHouse": enterMarysHouse();break;
            case "investigateMarysHouse": investigateMarysHouse();break;
            case "basement": basement();break;
            case "gaseousBlobAttacks": gaseousBlobAttacks();break;
            case "intoTheForest": intoTheForest();break;
            case "useTorchInForest": useTorchInForest();break;
            case "armyDetritus": armyDetritus();break;
            case "armyDetritus2": armyDetritus2();break;
            case "alienEncounter": alienEncounter();break;
            case "takeGunAndUniform": takeGunAndUniform();break;
            case "alienEncounter2": alienEncounter2();break;
            case "runAwayFromAlien": runAwayFromAlien();break;
            case "shootAtAlien": shootAtAlien();break;
            case "alienAttacks": alienAttacks();break;
            case "winOverAlien": winOverAlien();break;
            case "backToHouseAfterAlienAttack": backToHouseAfterAlienAttack();break;
            case "takeTube": takeTube();break;
            case "attackBlob": attackBlob();break;
            case "marysSafe": marysSafe();break;
            case "twoButtonOnSafe": twoButtonOnSafe();break;
            case "oneButtonOnSafe": oneButtonOnSafe();break;
            case "zeroButtonOnSafe": zeroButtonOnSafe();break;
            case "twoButtonOnSafe2": twoButtonOnSafe2();break;
            case "bedFactory": bedFactory();break;
            case "observeBedFactory": observeBedFactory();break;
            case "enterBedFactoryDeath":enterBedFactoryDeath();break;
            case "doorInBedFactory": doorInBedFactory();break;
            case "youAwakenInTheBedFactory": youAwakenInTheBedFactory();break;
            case "bedFactoryCorridor": bedFactoryCorridor();break;
            case "bedFactoryFloor": bedFactoryFloor();break;
            case "talkToForeman": talkToForeman();break;
            case "IAmWoody": IAmWoody();break;
            case "IAmNotWoody": IAmNotWoody();break;
            case "askForeman": askForeman();break;
            case "bribeForeman": bribeForeman();break;
            case "useSnackMachine": useSnackMachine();break;
            case "buyEnergyBarPlusFromMachine": buyEnergyBarPlusFromMachine();break;
            case "buyAverageEnergyBarFromMachine": buyAverageEnergyBarFromMachine(); break;
            case "buyMediocreEnergyBarFromMachine": buyMediocreEnergyBarFromMachine();break;
            case "refrigerationTruck": refrigerationTruck();break;
            case "investigateTruck": investigateTruck();break;
            case "investigateTruck2": investigateTruck2();break;
            case "investigateTruck3": investigateTruck3();break;
            case "fightSoldier": fightSoldier();break;
            case "soldierFightsBack": soldierFightsBack();break;
            case "inspiredAttackAgainstSoldier": inspiredAttackAgainstSoldier();break;
            case "shootAtSoldier": shootAtSoldier();break;
            case "winOverSoldier": winOverSoldier();break;
            case "investigateTruckCabin": investigateTruckCabin();break;
            case "takeUniform": takeUniform();break;
            case "openTruckDoors": openTruckDoors();break;
            case "untieMary": untieMary();break;
            case "untieMary2":untieMary2();break;
            case "untieMary3": untieMary3();break;
            case "untieMary4": untieMary4(); break;
            case "rescueMary": rescueMary();break;
            case "canteen": canteen();break;
            case "askPhoneAboutSoldiers": askPhoneAboutSoldiers();break;
            case "askPhoneAboutSoldiers2": askPhoneAboutSoldiers2();break;
            case "riddleOne": riddleOne();break;
            case "riddleTwo": riddleTwo();break;
            case "riddleThree": riddleThree();break;
            case "getTheM16": getTheM16();break;
            case "canteenWork": canteenWork();break;
            case "sinigangRecipe": sinigangRecipe();break;
            case "cookingOne": cookingOne();break;
            case "cookingTwo": cookingTwo();break;
            case "cookingThree": cookingThree();break;
            case "cookingFour": cookingFour();break;
            case "cookingFive": cookingFive();break;
            case "cookingSix": cookingSix();break;
            case "cookingSeven": cookingSeven();break;
            case "sinigangComplete": sinigangComplete();break;
            case "cookingError": cookingError();break;
            case "buySinigang": buySinigang();break;
            case "intoUniformDisguise": intoUniformDisguise();break;
            case "enterBedFactoryBasement": enterBedFactoryBasement();break;
            case "youAwakenMIB": youAwaken();player.unEquipItem("Ammonite");player.setHealthPoints(0);game.getPlayerRepository().save(player);break;
            case "generalChambersOfficeDoor":generalChambersOfficeDoor();break;
            case "generalChambersOffice": generalChambersOffice();break;
            case "generalChambersOffice2": generalChambersOffice2();break;
            case "generalChambersAttacks": generalChambersAttacks();break;
            case "shootAtGeneralChambers": shootAtGeneralChambers();break;
            case "grappleChambers": grappleChambers();break;
            case "inspiredAttackAgainstChambers": inspiredAttackAgainstChambers();break;
            case "baseballBatAgainstChambers": baseballBatAgainstChambers();break;
            case "winOverGeneralChambers": winOverGeneralChambers();break;
            case "winOverGeneralChambers2": winOverGeneralChambers2();break;
            case "winOverGeneralChambers3": winOverGeneralChambers3();break;
            case "goIntoLab": goIntoLab();break;
            case "investigateMothmanPrison": investigateMothmanPrison();break;
            case "freeMothman": freeMothman();break;
            case "freeMothman2": freeMothman2();break;
            case "imbibeSmoke": imbibeSmoke();break;
            case "imbibeSmoke2": imbibeSmoke2();break;
            case "endingOne": endingOne();break;
            case "endingOne2": endingOne2();break;
            case "endingOne3": endingOne3();break;
            case "endingOne4": endingOne4();break;
            case "endingTwo": endingTwo();break;
            case "endingTwo2": endingTwo2();break;
            case "endCredits": endCredits();break;

            case "titleScreenAfterCredits": userInterface.introButton.setActionCommand("startAfterIntro");visibilityManager.showTitleScreen();


            case "getArmyUniform": showInventoryItem("Army Uniform");break;
            case "getEnergyBarPlus": healthItem("Energy Bar+");userInterface.inventory2.setText("(Inventory slot 2)");break;
            case "getAverageEnergyBar": healthItem("Average Energy Bar");userInterface.inventory3.setText("(Inventory slot 3)");break;
            case "getMediocreEnergyBar": healthItem("Mediocre Energy Bar");userInterface.inventory4.setText("(Inventory slot 4)");break;
            case "getRustedKey": showInventoryItem("Rusted Key");break;
            case "getKeyCard": showInventoryItem("Keycard");break;
            case "getAmmonite": showInventoryItem("Ammonite");break;
            case "getWindupTorch": showInventoryItem("Windup Torch");break;

            case "getAlloyTube": showWeaponItem("Alloy Tube");break;
            case "getBaseballBat": showWeaponItem("Baseball Bat"); break;
            case "getColt": showWeaponItem("Colt revolver"); break;
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

        userInterface.text ="You wait for an hour. No cars pass. Everything is still and quiet save for the gentle rustling of wind through the crops. You have drunk the remnants of your water bottle.\n\nYou are now very hungry.";
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

        userInterface.text = ("'This will not do,' he says. 'I was going to give you a special key for your courage. Now I won't. You might still get it yet if you prove yourself to be a HARD WORKER. Thanks for the cash. Take this.'\n\nVadig hands over an Energy Bar(+25 HP) and ambles off down the road.");
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

        int damageTotal = roll +3;

        enemy.takeDamage(damageTotal);

        player.setInspiration(player.getInspiration()-1);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/grappleVadig.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with Vadig");

        userInterface.text = "Vadig HP:"+enemy.getHealthPoints()+"\nYou used 1 point of Inspiration to add +3 damage to a successful or unsuccessful attack roll.\n\nD20 ATTACK ROLL: "+attackRoll+" vs VADIG DEFENCE RATING: "+enemy.getDefence()+"\nYou inflict " + damageTotal+ " points of damage.";
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
        userInterface.choice2.setText("Inspired Grapple");
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

        userInterface.text = "Vadig falls to the ground and laughs.\n\n'Well done', he says. 'I had to test you for what is to come.'\n\nHe stands up slowly and hands you a rusted key.\n(+2 Defence. +3 Attack)";
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

        userInterface.text = "'You must visit my sister in the library in town.'\n\nHe nods and runs off into the field before descending some unseen staircase hidden by scrub.\n\n(Rusted Key has been added to Inventory)";
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

        userInterface.text = "You can find no sign of a staircase or door amidst the dirt and dried out cornstalks, only an Average Energy Bar(+20 HP) with a note attached.\n\nIt reads: 'Eat this if you are feeling weak. It can help.";
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
            userInterface.text = ("After walking for an hour, you enter Point Pleasant. It is a small town, a population of around 4,000, according to the signage on approach. The main thoroughfare features thrift stores, bars, locally owned shops. You notice, after looking in a shop window, that your eyes are rimmed red and swollen.");
        } else {userInterface.text = "After walking for an hour, you enter Point Pleasant. It is a small town, a population of around 4,000, according to the signage on approach. The main thoroughfare features thrift stores, bars, locally owned shops. You notice, after looking in a shop window, that your eyes are rimmed red and swollen.\n\nYou realise that your wallet is gone. You only have $4 in change.";}
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
        userInterface.choice3.setText("Dynamite Diner");

        game.choiceButton1 = "enterLocalShop";
        game.choiceButton3 = "enterDiner";

        if(player.getGameProgress()>=1&&player.getGameProgress()<=2){
            userInterface.choice4.setText("Point Pleasant Enquirer");
            game.choiceButton4 = "newspaperOffice";
        } else if(player.getGameProgress()>=3){
            userInterface.choice4.setText("Point Pleasant Enquirer");
            game.choiceButton4 ="waitForMary";
        } else{userInterface.choice4.setText("");
            game.choiceButton4 = "";}

        if(player.getGameProgress()==2){
            userInterface.choice5.setText("The Marlee Hotel");
            game.choiceButton5 = "marleeHotel";
        } else if(player.getGameProgress()>=3){
            userInterface.choice5.setText("35 Tom Duck Way");
            game.choiceButton5 ="library";
        } else{userInterface.choice5.setText("");
            game.choiceButton5 = "";}

        if(player.getGameProgress()>=4){
            userInterface.choice2.setText("To Mary's House");
            game.choiceButton2 = "toMarysHouse";
        } else {
            userInterface.choice2.setText("Rita's Car Garage");
            game.choiceButton2 = "enterCarGarage";
        }


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

        userInterface.text = "It is dry and dusty inside the store. The shelves are threadbare. The shopkeeper is a small man with no chin and thick glasses sitting in a chair to the side. You immediately erupt into a fit of coughing. It's dusty.\n\nThe man ignores you, his head buried in a book entitled, 'The History of Glue'.";
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

        userInterface.text = "'A lot of strange things going on in town at the moment,' he says. 'I think it has something to do with the power plant three towns over. Leaking poisonous fumes or somethin, causing hallucinations. Might explain your swollen eyes as well.'\n\nHe looks you up and down:'You gonna buy anything?'";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("What can I buy?");
        userInterface.choice3.setText("Can I use your phone?");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterLocalShop";
        game.choiceButton2 = "whatToBuy";
        game.choiceButton3 = "useShopkeepersPhone";
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

        userInterface.choice4.setText("");
        userInterface.choice5.setText("Ask about earning money");

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

        if(player.getWeaponByName("Baseball Bat").isEquipped()) {
            userInterface.choice4.setText("");
            game.choiceButton4 = "";
        } else{
            userInterface.choice4.setText("Baseball Bat($20)");
            game.choiceButton4 = "buyBaseballBat";
        }

        game.choiceButton1="enterLocalShop";
        game.choiceButton5 = "earningMoneyAtShop";

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
            userInterface.text = "'There you go, sir, one torch,' he says. 'This is a classic.'\n\n(Windup Torch added to Inventory. Cash -$30)";
            player.setItemToEquipped("Windup Torch");
        }else{userInterface.text = "'Not enough cash, hombre,' he mutters.\n\nHe sits down and continues reading his book, then looks up:'Got some logs need chopping out back if you want to earn $40'";}
        userInterface.prepareText();


        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("Earn some money");
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
            userInterface.text = "'There you go, sir, one crummy energy bar,' he says. 'You must be in dire straits.'\n\n(Mediocre Energy Bar added to Inventory(HP+15). Cash -$2)";
            player.setItemToEquipped("Mediocre Energy Bar");
        }else{userInterface.text = "'Not enough cash, hombre,' he mutters.\n\nHe sits down and continues reading his book, then looks up:'Got some logs need chopping out back if you want to earn $40'";}
        userInterface.prepareText();


        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("Earn some money");
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

    public void buyBaseballBat(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mainshopkeeper.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Pleasant Store");

        if(player.getCash()>=20 && !player.getWeaponByName("Baseball Bat").isEquipped()) {
            player.setCash(player.getCash() - 20);
            userInterface.text = "'There you go, sir, one baseball bat,' he says. 'Don't know what the hell you need this for. Hope you're not a lunatic.'\n\nBaseball Bat added to Inventory. Cash -$20)";
            player.setWeaponToEquipped("Baseball Bat");
        }else{userInterface.text = "'Not enough cash, hombre,' he mutters.\n\nHe sits down and continues reading his book, then looks up:'Got some logs need chopping out back if you want to earn $40'";}
        userInterface.prepareText();


        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("Earn some money");
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


        game.choiceButton1="enterLocalShop";

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

        if(!player.getItemByName("Rusted Key").isEquipped()&&player.getCash()>30){
            game.choiceButton1 = "vadigsKey";
        } else {game.choiceButton1="earningMoneyAtShop";}
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

        userInterface.text = "You are exhausted from splitting these logs. As you split another nondescript piece of wood, something shiny erupts from its centre. You bend down and pick up an old rusted key. A tattered note attached to it reads: 'I told you I would reward your hard work. Very impressive. Vadig.\n\n(Rusted Key has been added to Inventory)";
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

        userInterface.text = "You enter the garage.A woman in overalls is working on a disassembled Ford Cortina and glares at you suspiciously. She appears exhausted and has dark rings under her eyes as if she hasn't slept in days.\n\n'Can I help you?' She says.";
        userInterface.prepareText();

        userInterface.choice1.setText("Tell her your travails");
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

        userInterface.text = "'Well that's a mighty sad story,' she mutters. 'Happening with increasing frequency around here, but I don't see how it's my problem.'\n\nShe ponders for a moment, then: 'Maybe go see Mary at the newspaper offices. She's good with cars and has a thing for charity cases like yours.'";
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

        userInterface.text = "'Can't just wander into town and demand things.'\n\nShe sighs and apologises: 'I'm sorry. There's been many a stranger come into town recently. Some may be regular folks, others turn out to be lunatics. I don't know you, so even if the phone was working it would still be a no.";
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

        if(player.getInsight()<=2){
        userInterface.text = "You enter the offices of the Point Pleasant Enquirer located in a converted mobile home in a lot off the main square. It is surprisingly bright and airy inside. The sole journalist in the office stands up when she notices your wild look\n\n'Aha!' She says.'You've seen them too!'";
        userInterface.choice1.setText("What are you talking about?");
        game.choiceButton1="maryTells";
        }else{userInterface.text = "'Oh, you're back so soon,' says Mary. 'I have an incredible amount of work to do. Can you come back in an hour or so? Everything is going crazy around here. Bright lights in the sky! Winged creatures swooping out of the air! Wild times!'";
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

    public void maryTells(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/maryHyre2.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        userInterface.text = "'Let me guess,' she says. 'You suspect you fell asleep at the wheel of your and you woke up in the morning at the side of the road.'\n\n'It's happened a bunch of times over the past few weeks, ever since everything started going crazy round here. Kooks and soldiers showing up and whatnot.'";
        userInterface.prepareText();

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

        userInterface.text = "Although the import of the video is not immediately obvious, something about this UFO footage resonates and makes your stomach drop.\n\n'If you would like to find out more, come see me at the Marlee Hotel later on. I have a hypnotist friend staying there helping people like you recover lost memories.'";
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
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/maryHyre2.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        userInterface.text = "'Your description of this man doesn't ring any bells,' she says, 'but we have had incidents in the town in recent days where strange people turn up and try to convince people that that they are from here.\n\n'Vadig said that his sister works in the library?,' she adds, 'That doesn't make sense. The library shut down three years ago.'";
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

        if(player.getGameProgress()>=3){
            userInterface.choice2.setText("");
            game.choiceButton2 = "";
            userInterface.text = "The diner is quiet. The waitress, or owner, sits behind the counter doing a crossword. She doesn't look up.";
        } else{
            userInterface.text = "The diner is quiet. The waitress, or owner, sits behind the counter doing a crossword. She doesn't look up.\n\nA man sitting in one of the booths perks up at your entrance. Like you, his hair is wild and his eyes are red and swollen. He tries to catch your eye and weakly smiles.";
            userInterface.choice2.setText("Talk to man");
            game.choiceButton2 = "talkToManInDiner";
        }
        userInterface.prepareText();

        userInterface.choice1.setText("Order Beef Tacos($7)");
        userInterface.choice3.setText("Ask to use phone");
        userInterface.choice4.setText("Leave");
        userInterface.choice5.setText("");

        game.choiceButton1="beefTacos";
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
        userInterface.choice2.setText("");
        userInterface.choice3.setText("Ask to use phone");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterDiner";
        game.choiceButton2 = "";
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
        userInterface.choice3.setText("< < <");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="beefTacos";

        game.choiceButton3 = "enterDiner";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        if(player.getGameProgress()>=3){
            userInterface.choice2.setText("");
            game.choiceButton2 = "";
        } else{
            userInterface.choice2.setText("Talk to man");
            game.choiceButton2 = "talkToManInDiner";
        }

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

        userInterface.text = "You follow her into a bedroom on the first floor where a man in long jacket sits on an armchair by the window. His eyes are very large. He motions for you to sit on the chair opposite his.\n\n'We believe you are another experiencer,' he says. 'Do you consent to be hypnotised so we can help you discover the truth?'";
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

        userInterface.text = "You see yourself driving along the highway at night, struck by a blinding light in the sky... a sensation of floating... a tall winged creature with red eyes lurking in the trees attacked by armed men.\n\nHowever surreal these sensations and images, the one that mysteriously affects you most is of Christmas presents floating in the water.(Insight increased by +2)";
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

        if(player.getItemByName("Rusted Key").isEquipped())
            {game.inventoryButton5 = "openBox";}

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

        userInterface.text = "'You will give me that object', says a squeaking voice behind you.\n\nYou turn and are confronted by an incredibly broad man in black trenchcoat and black fedora blocking the door to the diner.Quicker than humanly possible, he lunges towards you.";
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

        userInterface.choice1.setText("Grapple");
        userInterface.choice2.setText("Inspired Grapple");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if (player.getHealthPoints() <= 0) {
            game.choiceButton1 = "youAwakenMIB";
            game.choiceButton2 = "youAwakenMIB";
        } else {
            game.choiceButton1 = "playerAttacksMIB";
            player.unEquipItem("Ammonite");
            if(player.getInspiration()>0){
                game.choiceButton2 = "inspiredAttackAgainstMIB";}
        }
        if(player.getWeaponByName("Baseball Bat").isEquipped() && player.getHealthPoints()>0){
        game.weapon2 = "attacksWithBat";}

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

        if(enemy.getHealthPoints()>0){
            game.weapon2 = "";
        } else{
            game.choiceButton1 = "winOverMIB";
        }


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

        int damageTotal = roll +3;

        enemy.takeDamage(damageTotal);

        player.setInspiration(player.getInspiration()-1);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/black1.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with MIB");

        userInterface.text = "MIB HP:"+enemy.getHealthPoints()+"\nYou used 1 point of Inspiration to add +3 damage to a successful or unsuccessful attack roll.\n\nD20 ATTACK ROLL: "+attackRoll+" vs MIB DEFENCE RATING: "+enemy.getDefence()+"\nYou inflict " + damageTotal+ " points of damage.";
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

        game.weapon2 = "";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void attacksWithBat(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("agentK");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int damageTotal = player.attackEnemyWithWeapon(enemy.getDefence(), attackRoll, "Baseball Bat");

        enemy.takeDamage(damageTotal);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/baseball.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with MIB");

        userInterface.text = "MIB HP:"+enemy.getHealthPoints()+"\nYou used the Baseball Bat to add +9 damage to a successful attack roll.\n\nD20 ATTACK ROLL: "+attackRoll+" vs MIB DEFENCE RATING: "+enemy.getDefence()+"\nYou inflict " + damageTotal+ " points of damage.";
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

        game.weapon2 = "";
        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void youAwaken(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("agentK");
        enemy.setHealthPoints(30);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/youAwaken.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("You awaken");

        userInterface.text = "You wake in an alleyway off the main square shaking off troubling dreams featuring a winged creature with glowing red eyes. You were not aware of losing consciousness, as if some outside force has some terrible hold over your destiny.\n\nYou look at your watch. Somehow you've travelled back an hour.";
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
        this.game.getEnemyRepository().save(enemy);
    }

    public void winOverMIB(){
        Player player = getPlayer();
        player.setAttack(player.getAttack()+3);
        player.setDefence(player.getDefence()+2);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mibdead.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Dumpster Encounter");

        userInterface.text = "The broad body crumples to the floor, his body thudding on the asphalt. A purple noxious gas pours forth from under his clothing. His body dissolves into a putrid puddle, leaving only a heap of black clothing.\n\n'Don't move creep!' Yells a voice behind you.\n(Defence increased +2. Attack increased +3)";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="arrested";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon2 = "getBaseballBat";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void arrested(){
        Player player = getPlayer();
        player.unEquipItem("Baseball Bat");
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/cop.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Dumpster Encounter");

        userInterface.text = "You turn and are confronted by a heavy-set cop with a bullish demeanour.\n\n'What the hell ?!'He says.'I'm sick of you weirdos stinking up our town.'\n\nYou drop the Baseball Bat, look at the clothes pile and realise that this cop would not care for your explanation.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="jailed";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

//    Game part 2
    public void jailed(){
        Player player = getPlayer();
        player.setGameProgress(3);
        inventoryButtons();
         weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/jailed3.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Sheriff's Department");

        userInterface.text = "You have been sitting in the jail cell of the Point Pleasant Sheriff's Dept for three hours arrested on suspicion of criminal activity. It is dank in there with only a small window high-up in the wall to let in the paltry light.There is an old sleeping drunk in there locked in to dry off.\n(Baseball bat removed from Inventory)";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="jailed2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void jailed2(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/jailed.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Sheriff's Department");

        userInterface.text = "Eventually he sits up.\n\n'I know you,' he says, his diction slurred.'I had a dream about you. In the dream, a woman told me she wanted to meet you at her house. I'd never seen her in my life. She gave me an address. It's at 35 Tom Duck Way. That's a real address by the way. There's nothing there though. Weird, huh?'";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="jailed3";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void jailed3(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/copJail.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Sheriff's Department");

        userInterface.text = "You ignore the man, too tired and sore. Eventually the Sheriff comes in, the same burly man who arrested you.\n\n'Mary vouched for you and I'm gonna let you go,'he say,'but I still think you're up to no good. No way of checking with the computers down. Keep out of trouble. You should go see her.'";
        userInterface.prepareText();

        userInterface.choice1.setText("Leave jail");
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

    public void waitForMary(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/derekTwo.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        userInterface.text = "You enter the small office and a small balding man you have never seen before looks up from his computer.\n\n'Oh it's you!' He exclaims,'Mary has filled me in. The name's Derek. I'm the Copy Editor. She isn't here at the moment but you're free to wait for her if you'd like.'";
        userInterface.prepareText();

        userInterface.choice1.setText("Wait for Mary");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="waitForMary2";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void waitForMary2(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/derekOne.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        userInterface.text = "Half an hour passes. The room is soundproofed against the outside world. Only the sound of Derek typing on his keyboard disturbs the silence. He has a deadline to meet. Every so often he sighs loudly, frustrated that the internet and phones are still out.";
        userInterface.prepareText();

        userInterface.choice1.setText("Wait for Mary");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="waitForMary3";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void waitForMary3(){
        Player player = getPlayer();
        player.setGameProgress(4);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/derekThree.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Enquirer");

        userInterface.text = "Two hours pass. Derek looks at his watch. He is worried.\n\n'Dammit!' He says. 'She should be back by now. Where the hell could she have gotten to? Do me favour. Here's Mary's address. Go check on her.'";
        userInterface.prepareText();

        userInterface.choice1.setText("");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void library(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/blackdoors.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Tom Duck Way");

        if(player.getInsight()>=5) {
            userInterface.text = "Tom Duck Way is located down a narrow alleyway off the town square. It is part of an old derelict looking building with smashed in windows.\n\nA large oak door you were certain was not there before has appeared. Parked next to it is an imposing black sedan.";
            userInterface.choice1.setText("Enter Building");
            game.choiceButton1="library2";
        }else {
            userInterface.text = "Tom Duck Way is located down a narrow alleyway off the town square. It is part of an old derelict looking building with smashed in windows. A series of plain black doors line the wall, each marked by brass numbers. It is difficult to discern what the purpose of this building was. The numbers however only go up to 28.\n(+5 Insight required)";
            userInterface.choice1.setText("");
            game.choiceButton1="";
        }
        userInterface.prepareText();


        userInterface.choice2.setText("Back to Town Square");
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

    public void library2(){
        Player player = getPlayer();
        player.setGameProgress(5);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/vsister.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Library");

        userInterface.text = "You enter a large library overflowing with books on tables, under tables, piled around the floor.\n\nAt its centre is an oak desk where a very pale young woman with dolled-up hair wearing a green dress with squared shoulders. She's dressed as if she had just stepped out of the 1940's.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="library3";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void library3(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/vsister2.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Library");

        userInterface.text = "'I've been expecting you,' she says as she stands up and walk around the desk.\n\nAt once she is standing too close. She smells of burnt plastic: 'I just wanted to tell you that my birthday is the 21st February.' Her smile unnervingly wide.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="library4";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void library4(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/vsister3.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Point Pleasant Library");

        userInterface.text = "She cackles and grabs you by the hand and shakes it forcefully: 'I'd like a bed from the bed factory as a present.\n\n'21st February,' she repeats and freezes, looking up into the corner of the room. She doesn't move. Doesn't appear to breathe. She is as mad as her brother.";
        userInterface.prepareText();

        userInterface.choice1.setText("");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void toMarysHouse(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/beds.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("To Mary's House");

        userInterface.text = "You walk along a gravel path alongside the woods and down below the hill, a run-down industrial estate. A few men and woman shuttle back and forth between buildings loading packaged double beds into the back of a truck.";
        userInterface.prepareText();

        userInterface.choice1.setText("To Mary's House");
        userInterface.choice2.setText("Back To Town");
        if(player.getGameProgress()>=5){
            userInterface.choice3.setText("Bed Factory");
            game.choiceButton3 = "bedFactory";
        } else{userInterface.choice3.setText("");
            game.choiceButton3 = "";}

        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="marysHouse";
        game.choiceButton2 = "theTownSquare";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void marysHouse(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/maryshouse.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's House");

        userInterface.text = "Mary's house is a single-storey terracotta-walled bungalow with a gabled roof and overhanging eaves. It stands alone, swathed in mist, with its back against a very thick and imposing forest.\n\nThe next closest house is five minutes away.";
        userInterface.prepareText();

        userInterface.choice1.setText("Enter");
        userInterface.choice2.setText("Back towards town");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterMarysHouse";
        game.choiceButton2 = "toMarysHouse";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void enterMarysHouse(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("Hank");
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/marysinterior.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's House");


        userInterface.text = "The main area of the house combines a kitchenette and living room. Dark, earthy tones predominate. Framed photos of her family, nieces and nephews, brothers, parents, are in abundance.\n\nThe shelves in the main living area are bursting with books.";

        userInterface.prepareText();

        if(enemy.getHealthPoints()==0 && !player.getItemByName("Keycard").isEquipped()){
            game.choiceButton3 = "marysSafe";
            userInterface.choice3.setText("Basement");
        } else if(enemy.getHealthPoints()==0 && player.getItemByName("Keycard").isEquipped()){
            game.choiceButton3 = "";
            userInterface.choice3.setText("");}
        else{game.choiceButton3 = "basement";
            userInterface.choice3.setText("Basement");}

        userInterface.choice1.setText("Investigate");
        userInterface.choice2.setText("Go out the back door");
        userInterface.choice4.setText("Leave");
        userInterface.choice5.setText("");

        game.choiceButton1="investigateMarysHouse";
        game.choiceButton2 = "intoTheForest";
        game.choiceButton4 = "marysHouse";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void investigateMarysHouse(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("Hank");
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/marysinterior.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's House");

        userInterface.text = "You pick through the letters and pieces of paper lying around her laptop on the breakfast bar. You then spot a note lying propped up on the coffee table.\n\nIt reads: 'Heard some strange noises out back. I'm frightened but have gone to investigate. Am afraid someone wants to get into my safe.'";
        userInterface.prepareText();

        if(enemy.getHealthPoints()==0){
            game.choiceButton3 = "marysSafe";
        } else{
            game.choiceButton3 = "basement";
        }

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("Go out the back door");
        userInterface.choice3.setText("Basement");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterMarysHouse";
        game.choiceButton2 = "intoTheForest";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void basement(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/greenfog.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's House Basement");

        userInterface.text = "You round the bottom of the stairs. The first thing you notice is a thick green fog entirely localised at the far end amidst cardboard boxes and an old exercise bike.\n\nThe fog rumbles and groans. Through it, you can see a small safe embedded in the wall.";
        userInterface.prepareText();

        userInterface.choice1.setText("Go back upstairs");
        userInterface.choice2.setText("Approach Safe");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterMarysHouse";
        game.choiceButton2 = "gaseousBlobAttacks";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        if(player.getWeaponByName("Alloy Tube").isEquipped()){
            game.weapon1 = "attackBlob";}

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void gaseousBlobAttacks(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("Hank");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int enemyAttack = enemy.attackPlayer(player.getDefence(), attackRoll);

        player.takeDamage(enemyAttack);

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/fogattack.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's House Basement");

        userInterface.text = "The fog extends a tendril and lashes out at you.\n\nENEMY D20 ATTACK ROLL: " + attackRoll + " vs YOUR DEFENCE RATING: " + player.getDefence() + "\n\nGaseous Blob inflicts " + enemyAttack + " points of damage. It is immune to conventional attack.";
        userInterface.prepareText();

        if (player.getHealthPoints() > 0) {
            game.choiceButton1 = "enterMarysHouse";
            game.choiceButton2 = "gaseousBlobAttacks";
            game.choiceButton3 = "gaseousBlobAttacks";
            userInterface.choice1.setText("Flee");
            userInterface.choice2.setText("Grapple");
            userInterface.choice3.setText("Inspired Grapple");
        } else {
            game.choiceButton1 = "youAwaken";
            game.choiceButton2 = "";
            game.choiceButton3 = "";
            userInterface.choice1.setText("> > >");
            userInterface.choice2.setText("");
            userInterface.choice3.setText("");
        }

        if(player.getWeaponByName("Alloy Tube").isEquipped()){
            game.weapon1 = "attackBlob";}

        userInterface.choice1.setText("Flee");
        userInterface.choice2.setText("Grapple");
        userInterface.choice3.setText("Inspired Grapple");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
        this.game.getEnemyRepository().save(enemy);
    }

    public void intoTheForest(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/forest.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's back garden");

        userInterface.text = "You enter the back garden. Beyond the trim lawn, the thick red oak trees of the forest are closely knitted. There is no birdsong, only the shushing of the leaves in wind.\n\nIt's so dark in there that you would not be able to find your way through without a light source.";
        userInterface.prepareText();

        userInterface.choice1.setText("Go back in house");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="enterMarysHouse";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        if(player.getItemByName("Windup Torch").isEquipped())
        {game.inventoryButton8 = "useTorchInForest";}

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void useTorchInForest(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/torch.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bedlam Forest");

        userInterface.text = "You turn on the light and enter the forest, glad of your sentimental nature when you saw the torch in the shop. You pick your way over the dead leaves and thick roots that snag on your boots as you walk.\n\nYou can hear a distant buzzing sound and glimpse an eerie blue light up ahead.";
        userInterface.prepareText();

        userInterface.choice1.setText("Go back to garden");
        userInterface.choice2.setText("Push on");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="intoTheForest";
        game.choiceButton2 = "armyDetritus";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";


        game.inventoryButton8 = "getWindupTorch";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void armyDetritus(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/soldiers.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bedlam Forest");

        userInterface.text = "You come across a clearing upon which sits an upturned US army jeep. Casting around the light from your torch, you discover five dead soldiers in a shallow leafy embankment, and near them, a pile of black clothing lying in a noxious puddle.";
        userInterface.prepareText();

        userInterface.choice1.setText("Go back to garden");
        userInterface.choice2.setText("Investigate");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(player.getWeaponByName("Alloy Tube").isEquipped()){
            game.choiceButton3 = "";
            userInterface.choice3.setText("");
        } else{
            game.choiceButton3 = "alienEncounter";
            userInterface.choice3.setText("Towards the blue light");
        }

        game.choiceButton1="intoTheForest";
        game.choiceButton2 = "armyDetritus2";
        game.choiceButton4 = "";
        game.choiceButton5 = "";


        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void armyDetritus2(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/jeep.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bedlam Forest");

        if(player.getItemByName("Ammonite").isEquipped()){
            userInterface.text = "You search through the upturned jeep, trying to ignore the corpses littering the ground. In a regulation issue duffel bag you find several guns and army uniforms. It looks they died fighting whatever it was wearing the pile of black clothing.";
        } else{userInterface.text = "You search through the upturned jeep, trying to ignore the corpses littering the ground. In a regulation issue duffel bag you find several small guns and uniforms. Searching through the black clothing, you find a strange fossil.\n\n(Ammonite added to Inventory)";
            player.setItemToEquipped("Ammonite");}
        userInterface.prepareText();

        if(player.getWeaponByName("Colt revolver").isEquipped()){
            userInterface.choice2.setText("");
            game.choiceButton2 = "";
        } else{
            userInterface.choice2.setText("Take Pistol");
            game.choiceButton2 = "takeGunAndUniform";
        }

        userInterface.choice1.setText("< < <");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="armyDetritus";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";


        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void alienEncounter(){
        Player player = getPlayer();
        player.setInsight(player.getInsight()+2);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/saucer.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bedlam Forest");

        userInterface.text = "Walking on to the blue light, some invisible force knocks you back and a great white flash blinds you through the silhouetted trees. Above the clearing now spins a metallic flying saucer, the hull gently pulsating blue. This is what you saw before you blacked out on the road.\n\n(Insight increased by +2)";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="alienEncounter2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";


        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void takeGunAndUniform(){
        Player player = getPlayer();
        player.setWeaponToEquipped("Colt revolver");
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/gunny.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bedlam Forest");

        userInterface.text = "The gun feels unnatural in your hand. Alongside the items are bullets which you fill your pockets with. These are strange times. You feel as though you are being directed by some unnatural force to do things you wouldn't otherwise do.\n\n(Colt revolver added to Inventory)";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="armyDetritus";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void alienEncounter2(){
        Player player = getPlayer();
        player.takeDamage(2);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/laser.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bedlam Forest");

        userInterface.text = "A green bolt strikes your shoulder, the pain is immense, and you scrabble backwards behind behind a small boulder. Blood pours from the wound. Luckily the gash is not deep. A squat creature with a bulbous grey head and large black almond eyes is shooting at you with some kind of laser gun.\n\n(HP decreased by -2)";
        userInterface.prepareText();

        userInterface.choice1.setText("Flee");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="runAwayFromAlien";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        if(player.getWeaponByName("Colt revolver").isEquipped())
        {game.weapon3 ="shootAtAlien";}

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void runAwayFromAlien(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/runningaway.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bedlam Forest");

        userInterface.text = "Your breathing is ragged as you stumble through the forest dodging green lasers that zip past your head and legs. Luckily the alien is a poor shot. You're able to hide between the trees and where they grow thick close to Mary's house, you are able to evade him completely in the darkness there.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="intoTheForest";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";


        game.weapon3 ="getColt";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void shootAtAlien(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("x42");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int damageTotal = player.attackEnemyWithWeapon(enemy.getDefence(), attackRoll, "Colt revolver");

        enemy.takeDamage(damageTotal);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/shot.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Gun Fight with X-42");

        userInterface.text = "X-42 HP:"+enemy.getHealthPoints()+"\nYou shoot the Colt Revolver to add +12 damage to a successful attack roll.\n\nD20 ATTACK ROLL: "+attackRoll+" vs X-42 DEFENCE RATING: "+enemy.getDefence()+"\nYou inflict " + damageTotal+ " points of damage.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "alienAttacks";
        } else{
            game.choiceButton1 = "winOverAlien";
        }
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon3 ="getColt";
        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void alienAttacks(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("x42");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int enemyAttack = enemy.attackPlayer(player.getDefence(), attackRoll);

        player.takeDamage(enemyAttack);

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/laser2.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Gun Fight with X-42");

        userInterface.text = "X-42 shoots his zap gun.\n\nENEMY D20 ATTACK ROLL: " + attackRoll + " vs YOUR DEFENCE RATING: " + player.getDefence() + "\n\nX-42 inflicts " + enemyAttack + " points of damage";
        userInterface.prepareText();


        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if (player.getHealthPoints() <= 0) {
            game.choiceButton1 = "youAwaken";
            userInterface.choice1.setText("> > >");
        } else {
            game.choiceButton1 = "";
            userInterface.choice1.setText("");
        }

        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        if(player.getWeaponByName("Colt revolver").isEquipped()&&player.getHealthPoints()>0)
        {game.weapon3 ="shootAtAlien";}

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void winOverAlien(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/alienfalls.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bedlam Forest");

        userInterface.text = "The grey alien slumps forward and tumbles down the embankment, scoring a line down the leaves as he falls. He is dead. Blue blood pours from his head.\n\nYou pick up the zap gun. Nothing happens when you pull the trigger. It's out of charge. Attached to its belt is a shiny alloy tube.";
        userInterface.prepareText();

        userInterface.choice1.setText("Take Alloy Tube");
        userInterface.choice2.setText("Go back to the house");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="takeTube";
        game.choiceButton2 = "backToHouseAfterAlienAttack";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";


        game.weapon3 ="getColt";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }
    public void takeTube(){
        Player player = getPlayer();
        player.setWeaponToEquipped("Alloy Tube");
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/alloytube.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bedlam Forest");

        userInterface.text = "This extraordinarily light, metallic tube is featureless save for a slight fingerprint sized depression in its side.\n\nYou press down on this and it makes the slight imperceptible sound of a vacuum cleaner.";
        userInterface.prepareText();

        userInterface.choice1.setText("");
        userInterface.choice2.setText("Go back to the house");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="";
        game.choiceButton2 = "backToHouseAfterAlienAttack";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";



        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void backToHouseAfterAlienAttack(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/runningaway.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bedlam Forest");

        userInterface.text = "You pick your way back to the house using the Windup Torch. No other sounds or lights appear through the forest.\n\nYou need to find Mary. She seems like the only person in this town who knows what is really going on.";
        userInterface.prepareText();

        userInterface.choice1.setText("");
        userInterface.choice2.setText("Go back to the house");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="";
        game.choiceButton2 = "intoTheForest";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }
    public void attackBlob(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("Hank");
        enemy.setHealthPoints(0);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/attackblob.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's House Basement");

        userInterface.text = "You put your thumb to the depression on the alloy tube and the gaseous blob groans. It writhes in the air for a moment, green tendrils lashing out in all directions until it succumbs to the effects of the device you are holding and is slowly, reluctantly, sucked into the tube.\n\nYou can now get to the safe on the wall.";
        userInterface.prepareText();

        userInterface.choice1.setText("Examine the safe");
        userInterface.choice2.setText("Leave the basement");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="marysSafe";
        game.choiceButton2 = "enterMarysHouse";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon1 = "getAlloyTube";

        game.inventoryButton8 = "getWindupTorch";
        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
        this.game.getEnemyRepository().save(enemy);
    }

    public void marysSafe(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/thesafe.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's House Basement");

        userInterface.text = "You approach the safe in the basement wall. It's the kind that takes four digit passwords.\n\nExamining the keypad, you notice that the numbers 0,1, and 2 are most worn.";
        userInterface.prepareText();

        userInterface.choice1.setText("1");
        userInterface.choice2.setText("2");
        userInterface.choice3.setText("0");
        userInterface.choice4.setText("Reset");
        userInterface.choice5.setText("Leave the basement");

        game.choiceButton1="";
        game.choiceButton2 = "twoButtonOnSafe";
        game.choiceButton3 = "";
        game.choiceButton4 = "marysSafe";
        game.choiceButton5 = "enterMarysHouse";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void twoButtonOnSafe(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/thesafe.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's House Basement");

        userInterface.mainTextArea.setText("You approach the safe in the basement wall. It's the kind that takes four digit passwords.\n\nExamining the keypad, you notice that the numbers 0,1, and 2 are most worn.");

        userInterface.choice1.setText("1");
        userInterface.choice2.setText("2");
        userInterface.choice3.setText("0");
        userInterface.choice4.setText("Reset");
        userInterface.choice5.setText("Leave the basement");

        game.choiceButton1="oneButtonOnSafe";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "marysSafe";
        game.choiceButton5 = "enterMarysHouse";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void oneButtonOnSafe(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/thesafe.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's House Basement");

        userInterface.mainTextArea.setText("You approach the safe in the basement wall. It's the kind that takes four digit passwords.\n\nExamining the keypad, you notice that the numbers 0,1, and 2 are most worn.");

        userInterface.choice1.setText("1");
        userInterface.choice2.setText("2");
        userInterface.choice3.setText("0");
        userInterface.choice4.setText("Reset");
        userInterface.choice5.setText("Leave the basement");

        game.choiceButton1="";
        game.choiceButton2 = "";
        game.choiceButton3 = "zeroButtonOnSafe";
        game.choiceButton4 = "marysSafe";
        game.choiceButton5 = "enterMarysHouse";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void zeroButtonOnSafe(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/thesafe.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's House Basement");

        userInterface.mainTextArea.setText("You approach the safe in the basement wall. It's the kind that takes four digit passwords.\n\nExamining the keypad, you notice that the numbers 0,1, and 2 are most worn.");

        userInterface.choice1.setText("1");
        userInterface.choice2.setText("2");
        userInterface.choice3.setText("0");
        userInterface.choice4.setText("Reset");
        userInterface.choice5.setText("Leave the basement");

        game.choiceButton1="";
        game.choiceButton2 = "twoButtonOnSafe2";
        game.choiceButton3 = "";
        game.choiceButton4 = "marysSafe";
        game.choiceButton5 = "enterMarysHouse";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }
    public void twoButtonOnSafe2(){
        Player player = getPlayer();
        player.setItemToEquipped("Keycard");
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/thesafe.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Mary's House Basement");

        userInterface.text = "The safe clicks open and reveals a wooden jewellery box, some piles of cash and a plain brown manilla envelope. You open the envelope and out slips a plain white keycard. This must be what Mary was protecting. You take the card and lock the safe.\n\n(Keycard added to Inventory)";
        userInterface.prepareText();

        userInterface.choice1.setText("Leave basement");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "enterMarysHouse";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void bedFactory(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/thebeds.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "Beneath the hill overlooking the industrial estate, you observe from behind a parked car. You don't see anything unusual besides people ferrying cellophane-covered beds to trucks from the open mouth of a factory door. Most of the workers look bored and tired.\n\nYou wonder why Vadig's sister sent you here.";
        userInterface.prepareText();

        userInterface.choice1.setText("Leave");

        if(player.getGameProgress()>=8) {
            userInterface.choice2.setText("Go to alcove door");
            game.choiceButton2 = "doorInBedFactory";
        }else{
            userInterface.choice2.setText("Wait and Observe");
            game.choiceButton2 = "observeBedFactory";
        }


        userInterface.choice5.setText("");

        if(player.getGameProgress()>=6){
            userInterface.choice3.setText("Investigate I.Cold truck");
            game.choiceButton3 = "refrigerationTruck";
            userInterface.choice4.setText("Back to Factory Floor");
            game.choiceButton4 = "bedFactoryFloor";
        } else{
            userInterface.choice3.setText("");
            game.choiceButton3 = "";
            userInterface.choice4.setText("");
            game.choiceButton4 = "";
        }

        game.choiceButton1= "toMarysHouse";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void doorInBedFactory(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/alcovedoor.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "A white door stands in the alcove. A black keycard reader is set into the wall at the side. .\n\nYour heart beats heavily in your chest. You have no idea what you will find beyond this portal.";
        userInterface.prepareText();

        userInterface.choice1.setText("Leave");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "bedFactory";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton6 = "enterBedFactoryDeath";

        if(player.getItemByName("Army Uniform").isEquipped()){
            game.inventoryButton1 = "intoUniformDisguise";
        }

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void observeBedFactory(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/jeepfactory.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "After 20 minutes of observation, you eventually catch a break.\n\nA US army jeep parks up next to an alcove in the side of the building and a soldier wearing green fatigues steps out and enters the door there.\n\nThe jeep speeds off.";
        userInterface.prepareText();

        userInterface.choice1.setText("Leave");
        userInterface.choice2.setText("Go to the door");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "toMarysHouse";
        game.choiceButton2 = "doorInBedFactory";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";


//        game.inventoryButton6 = "getKeyCard";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void enterBedFactoryDeath(){
        Player player = getPlayer();
        player.setHealthPoints(10);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/gunfiregloom.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "You use the keycard. The door clicks open.\n\nAn excruciating burning sensation rips through your chest as you see sparks of fiery light explode in the gloom at the bottom of the stairs. Bleeding out on the floor, you realise that stepping through that door was a foolish idea, looking as you do, like a wild eyed stranger.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "youAwakenInTheBedFactory";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";


        game.inventoryButton6 = "getKeyCard";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void youAwakenInTheBedFactory(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/youAwakenInCloset.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "An age passes in which a floating sensation suffuses every cell, and you are elevated through a floor into a darkened room, where cold linoleum is pressed to your face. You slowly stand, feeling weak, and realise you are in a cleaning cupboard.\n\nEven death is out of your hands.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "bedFactoryCorridor";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void bedFactoryCorridor(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/corridorMain.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "You are in a narrow corridor, you assume, inside the bed factory. Workers shuttle back and forth carrying beds past the open doorway at the end which leads to the factory floor and the exit.\n\nTo your right, the corridor leads to a busy canteen. In front of you is a snack machine.";
        userInterface.prepareText();

        userInterface.choice1.setText("Factory floor");
        userInterface.choice2.setText("Canteen");
        userInterface.choice3.setText("Use Snack Machine");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "bedFactoryFloor";
        game.choiceButton2 = "canteen";
        game.choiceButton3 = "useSnackMachine";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void bedFactoryFloor(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/bedfactoryfloor.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "The main factory floor is a large silvery warehouse room with fluorescent lighting. Workers in blue overalls stand at machines emitting loud whirring noises, whilst others work at benches with half-finished mattresses on top.\n\nA foreman in a short-sleeved shirt stands to the side.";
        userInterface.prepareText();

        userInterface.choice1.setText("Talk to foreman");
        userInterface.choice2.setText("Leave factory");
        userInterface.choice3.setText("Return to Corridor");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "talkToForeman";
        game.choiceButton2 = "bedFactory";
        game.choiceButton3 = "bedFactoryCorridor";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void talkToForeman(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/foremanGuy.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "The foreman is a large weary man with a weathered face. He would've been quite handsome in his youth.\n\n'Who are the hell are you?' He says, looking you up and down. 'Wait a minute! Are you Woody?'";
        userInterface.prepareText();

        userInterface.choice1.setText("Yes");
        userInterface.choice2.setText("No");
        userInterface.choice3.setText("Leave factory");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "IAmWoody";
        game.choiceButton2 = "IAmNotWoody";
        game.choiceButton3 = "bedFactory";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void IAmWoody(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/foremanGuy.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "'Goddammit!' He yells, pointing at your chest. 'You were supposed to start here yesterday. I don't have a job for you now.'\n\nHe assesses your appearance. Your hair is wild. You look a mess.\n\n'The canteen could give you some work,' he adds.";
        userInterface.prepareText();

        userInterface.choice1.setText("Ask about soldiers");
        userInterface.choice2.setText("Go to Canteen");
        userInterface.choice3.setText("Leave factory");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "askForeman";
        game.choiceButton2 = "bedFactoryCorridor";
        game.choiceButton3 = "bedFactory";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void IAmNotWoody(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/foremanGuy.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "'What the hell are you doing here then?!' He yells. 'This isn't a tourist joint.'\n\nHe points to the door: 'The exit is that way. Scram!'";
        userInterface.prepareText();

        userInterface.choice1.setText("Ask about soldiers");
        userInterface.choice2.setText("Go to Canteen");
        userInterface.choice3.setText("Leave factory");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "askForeman";
        game.choiceButton2 = "bedFactoryCorridor";
        game.choiceButton3 = "bedFactory";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void askForeman(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/nervousForeman.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "The foreman is instantly nervous. He glances around to see if anyone else is paying attention to you both then leans in.\n\n'You didn't see anything,' he hisses. 'There are no soldiers. Forget what you think you saw.'";
        userInterface.prepareText();

        userInterface.choice1.setText("Bribe him($60)");
        userInterface.choice2.setText("Go to Canteen");
        userInterface.choice3.setText("Leave factory");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "bribeForeman";
        game.choiceButton2 = "bedFactoryCorridor";
        game.choiceButton3 = "bedFactory";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void bribeForeman(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/nervousForeman.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        if(player.getCash()>=60){
            player.setCash(player.getCash()-60);
            player.setGameProgress(6);
            userInterface.text = "'You working for the Enquirer?' He mutters. 'Look, I don't want to get in trouble but something is going on in the basement. I also suggest you check out the I.Cold Refrigeration truck outside. I heard some strange noises coming from it this morning.'\n(Cash -$60)";
        } else{
            userInterface.text = "'Get the hell away from me?' He says through clenched teeth.\n\nHe turns away red-faced.\n\n($50 Cash required)";
        }
        userInterface.prepareText();

        userInterface.choice1.setText("Go to Canteen");
        userInterface.choice2.setText("Leave factory");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "bedFactoryCorridor";
        game.choiceButton2 = "bedFactory";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void useSnackMachine(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/snackmachine.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "This machine only sells Energy Bars. They are tasteless things but you feel much better after eating them. Probably because they contain a silly amount of sugar.";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice5.setText("");

        game.choiceButton1= "bedFactoryCorridor";

        if(player.getItemByName("Energy Bar+").isEquipped()) {
            userInterface.choice2.setText("");
            game.choiceButton2 = "";
        } else{
            userInterface.choice2.setText("Buy Energy Bar+($4)");
            game.choiceButton2 = "buyEnergyBarPlusFromMachine";
        }

        if(player.getItemByName("Average Energy Bar").isEquipped()) {
            userInterface.choice3.setText("");
            game.choiceButton3 = "";
        } else{
            userInterface.choice3.setText("Buy Average Energy Bar($3)");
            game.choiceButton3 = "buyAverageEnergyBarFromMachine";
        }

        if(player.getItemByName("Mediocre Energy Bar").isEquipped()) {
            userInterface.choice4.setText("");
            game.choiceButton4 = "";
        } else{
            userInterface.choice4.setText("Buy Mediocre Energy Bar($2)");
            game.choiceButton4 = "buyMediocreEnergyBarFromMachine";
        }
        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void buyEnergyBarPlusFromMachine(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/snackmachine.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        if(player.getCash()>=4 && !player.getItemByName("Energy Bar+").isEquipped()) {
            player.setCash(player.getCash() - 4);
            userInterface.text = "One Bazlinton's Energy Bar+ falls into the tray.\n\n(Energy Bar+ added to Inventory(HP+15). Cash -$4)";
            player.setItemToEquipped("Energy Bar+");
        }else{userInterface.text = "Not enough cash. Maybe try working for it. Everyone has to have a job in this economy.";}
        userInterface.prepareText();


        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="useSnackMachine";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void buyAverageEnergyBarFromMachine(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/snackmachine.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        if(player.getCash()>=3 && !player.getItemByName("Average Energy Bar").isEquipped()) {
            player.setCash(player.getCash() - 3);
            userInterface.text = "One Creeper's Energy Bar falls into the tray.\n\n(Average Energy Bar added to Inventory(HP+15). Cash -$3)";
            player.setItemToEquipped("Average Energy Bar");
        }else{userInterface.text = "Not enough cash. Maybe try working for it. Everyone has to have a job in this economy.";}
        userInterface.prepareText();


        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="useSnackMachine";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void buyMediocreEnergyBarFromMachine(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/snackmachine.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        if(player.getCash()>=2 && !player.getItemByName("Mediocre Energy Bar").isEquipped()) {
            player.setCash(player.getCash() - 2);
            userInterface.text = "One Indrid's Energy Bar falls into the tray.\n\n(Mediocre Energy Bar added to Inventory(HP+15). Cash -$3)";
            player.setItemToEquipped("Mediocre Energy Bar");
        }else{userInterface.text = "Not enough cash. Maybe try working for it. Everyone has to have a job in this economy.";}
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1="useSnackMachine";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void refrigerationTruck(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("John Hell");
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/fridge.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "The truck is an immense white freighter with the words 'I.Cold Refrigeration' written on its side. It stands alone in the middle of the parking area under a lamp post far from the bustle of the bed factory. There doesn't appear to be anyone in the cabin.";
        userInterface.prepareText();


        userInterface.choice2.setText("Go to back into factory");
        userInterface.choice3.setText("Leave");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()<=0){
            userInterface.choice1.setText("Investigate truck");
            game.choiceButton1= "investigateTruckCabin";
        } else if (player.getGameProgress()>=8){
            userInterface.choice1.setText("");
            game.choiceButton1= "";
        }else
        {game.choiceButton1= "investigateTruck";
            userInterface.choice1.setText("Investigate truck");}

        game.choiceButton2 = "bedFactoryFloor";
        game.choiceButton3 = "bedFactory";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void investigateTruck(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/fridge.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "You walk around the truck. Unusually, it's immense backdoors can be locked using the an internal mechanism, probably unlocked using a button in the cabin. Listening closely, you can hear something whimpering deep within.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("Go to back into factory");
        userInterface.choice3.setText("Leave");
        userInterface.choice5.setText("");

        if(player.getGameProgress()==7){
            userInterface.choice4.setText("Open Truck's Back Doors");
            game.choiceButton4 = "rescueMary";
            game.choiceButton1= "investigateTruckCabin";
        } else {
            userInterface.choice4.setText("");
            game.choiceButton4 = "";
            game.choiceButton1= "investigateTruck2";
        }

        game.choiceButton2 = "bedFactoryFloor";
        game.choiceButton3 = "bedFactory";

        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void investigateTruck2(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/soldierintruck.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "You step up onto the footplate so you can look into the cabin. The door is suddenly thrust open from the inside and you fall back onto the tarmac.\n\nA soldier, wearing full combat gear, looks down at you: 'You have ten seconds to get out of here, or I'm gonna put your curious ass in the back of this truck.'";
        userInterface.prepareText();

        userInterface.choice1.setText("Ask him what's inside");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("Leave");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "investigateTruck3";
        game.choiceButton2 = "";
        game.choiceButton3 = "bedFactory";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void investigateTruck3(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/shove.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "The soldier, a young man with a deep tan and regulation haircut, who appears to be alone, steps down from the truck and shoves you in the direction of the bed factory.\n\n'I told you to get the hell out of here,' says the soldier. 'You're gonna be in real trouble if you don't.'";
        userInterface.prepareText();

        userInterface.choice1.setText("Fight back");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("Leave");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "fightSoldier";
        game.choiceButton2 = "";
        game.choiceButton3 = "bedFactory";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void fightSoldier(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("John Hell");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int playerAttack = player.attackEnemy(enemy.getDefence(), attackRoll);

        enemy.takeDamage(playerAttack);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/soldierfights.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with Soldier");

        userInterface.text = "SOLDIER HP: "+enemy.getHealthPoints()+"\n\nYOUR D20 ATTACK ROLL: "+attackRoll+" vs SOLDIER DEFENCE RATING: "+enemy.getDefence()+"\n\nYou grapple with the Soldier and inflict " + playerAttack+ " points of damage";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "soldierFightsBack";
        } else{
            game.choiceButton1 = "winOverSoldier";
        }
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon3 = "getColt";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void soldierFightsBack(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("John Hell");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int enemyAttack = enemy.attackPlayer(player.getDefence(), attackRoll);

        player.takeDamage(enemyAttack);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/soldierfightsplayer.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with Soldier");

        userInterface.text = "The soldier attempts to wrestle you to the ground.\n\nENEMY D20 ATTACK ROLL: "+attackRoll+" vs YOUR DEFENCE RATING: "+player.getDefence()+"\n\nThe soldier inflicts " + enemyAttack+ " points of damage";
        userInterface.prepareText();

        userInterface.choice1.setText("Fight Back");
        userInterface.choice2.setText("Inspired Grapple");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(player.getHealthPoints()>0){
            game.choiceButton1 = "fightSoldier";
            if(player.getInspiration()>0){
                game.choiceButton2 = "inspiredAttackAgainstSoldier";}
            else {game.choiceButton2 = "";}
        } else{
            game.choiceButton1 = "breakdown";
            game.choiceButton2 = "";
        }

        if(player.getWeaponByName("Colt revolver").isEquipped())
        {game.weapon3 ="shootAtSoldier";}

        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void inspiredAttackAgainstSoldier(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("John Hell");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int roll = player.attackEnemy(enemy.getDefence(), attackRoll);

        int damageTotal = roll +3;

        enemy.takeDamage(damageTotal);

        player.setInspiration(player.getInspiration()-1);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/inspAttackAgainstSoldier.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with Soldier");

        userInterface.text = "Soldier HP:"+enemy.getHealthPoints()+"\nYou used 1 point of Inspiration to add +3 damage to a successful or unsuccessful attack roll.\n\nD20 ATTACK ROLL: "+attackRoll+" vs SOLDIER DEFENCE RATING: "+enemy.getDefence()+"\nYou inflict " + damageTotal+ " points of damage.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "soldierFightsBack";
        } else{
            game.choiceButton1 = "winOverSoldier";
            userInterface.choice2.setText("");
        }
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon3 = "getColt";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void shootAtSoldier(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/shotSniper.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Fight with Soldier");

        userInterface.text = "You shoot at the soldier with your pistol. It misses, but the sound draws the attention of the workers. A sniper on the factory roof, who had dozed off at his post, has been roused by the gunfire. He quickly finds his target and shoots.\n\nYOU DIED.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "youAwakenInTheBedFactory";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon3 = "getColt";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void winOverSoldier(){
        Player player = getPlayer();
        player.setAttack(getPlayer().getAttack()+2);
        player.setDefence(getPlayer().getDefence()+3);
        player.setInspiration(getPlayer().getInspiration()+2);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/winoversoldier.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Fight with Soldier");

        userInterface.text = "You get the soldier into a headlock. You are amazed by your own strength and martial prowess. Forty-eight hours ago, you would have fled from such matters, even when the cause was just. The soldier has lost consciousness in your arms.\n(Attack increased by +2. Defence increased by +3. Inspiration increased by +2)";
        userInterface.prepareText();

        userInterface.choice1.setText("Investigate Truck Cabin");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "investigateTruckCabin";
        game.choiceButton2 = "bedFactory";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon3 = "getColt";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void investigateTruckCabin(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/fastfood.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Refrigeration Truck");

        userInterface.text = "You climb into the cabin and find evidence that the soldier has been in the truck all day. On the passenger seat is an empty burger box, an empty soda can and a book titled Messengers of Deception. The back door release is above the dashboard radio and under the passenger seat is a set of fatigues.";
        userInterface.prepareText();


        userInterface.choice2.setText("Press Back Door Release");
        userInterface.choice3.setText("Leave Cabin");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(player.getItemByName("Army Uniform").isEquipped()){
            userInterface.choice1.setText("");
            game.choiceButton1= "";
        }else{
        userInterface.choice1.setText("Take Uniform");
        game.choiceButton1= "takeUniform";}

        game.choiceButton2 = "openTruckDoors";
        game.choiceButton3 = "investigateTruck";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void takeUniform(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();
        player.setItemToEquipped("Army Uniform");

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/fastfood.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Refrigeration Truck");

        userInterface.text = "You stuff the uniform into your rucksack in the hopes that it'll come in useful later.\n\n(Army Uniform added to inventory)";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "investigateTruckCabin";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void openTruckDoors(){
        Player player = getPlayer();
        player.setGameProgress(getPlayer().getGameProgress()+1);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/greenbutton.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Refrigeration Truck");

        userInterface.text = "You press on a green button and you hear the doors to the truck click open. The strange whimpering you heard earlier is louder now.";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "investigateTruckCabin";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void rescueMary(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/maryintruck.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Refrigeration Truck");

        userInterface.text = "To your relief, you find only Mary tied to a chair at the back of the truck surrounded by an array of high-tech surveillance equipment and army gear. Her hands are tied behind her back and her mouth is bound and gagged. Mary is relieved when she finally realises it is you. She has been sitting in the dark too long.";
        userInterface.prepareText();

        userInterface.choice1.setText("Untie her");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "untieMary";
        game.choiceButton2 = "refrigerationTruck";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void untieMary(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/untieMaryImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Refrigeration Truck");

        userInterface.text = "'Oh thank heavens, it's you!' She exclaims. 'I've been locked in here for hours. I think they were scared that I would blab to the world about what they're doing here. I finally figured it all out.'";
        userInterface.prepareText();

        userInterface.choice1.setText("What is going on?");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "untieMary2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void untieMary2(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/untieMaryImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Refrigeration Truck");

        userInterface.text = "'I believe the creature known as the Mothman has been captured by an alliance of the Galactic Federation and the US Army. They're keeping it in the basement, intending to use its power of prophecy to control the future. The Army engineered the problems with the power plant knowing that it would attract the Mothman.'";
        userInterface.prepareText();

        userInterface.choice1.setText("What is the galactic federation?");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "untieMary3";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void untieMary3(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/untieMaryImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Refrigeration Truck");

        userInterface.text = "'A nefarious faction of grey aliens, fighting against another faction who work with the Mothman. The latter are the ones that captured you and implanted a chip in your head. The Mothman is using it's psychic power from captivity to lock onto this chip and direct you towards its rescue since the aliens are obligated not to interfere in Earth matters.'";
        userInterface.prepareText();

        userInterface.choice1.setText("Tell her your travails");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "untieMary4";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void untieMary4(){
        Player player = getPlayer();
        player.unEquipWeapon("Colt revolver");
        player.setGameProgress(8);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/untieMaryImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Refrigeration Truck");

        userInterface.text = "'Excellent! You have the keycard,' she says. 'You need to get down there and confront the General.'\n\nShe ponders for a moment: 'I'll take care of the unconscious soldier. Tie him up and hide him behind the wheels. Don't worry. I'm stronger than I look. Gimme that gun.'\n\n(Colt revolver removed from Inventory)";
        userInterface.prepareText();

        userInterface.choice1.setText("Go");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "bedFactory";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void canteen(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/canteenImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "The canteen, a square room with one large window behind the counter and a small kitchen alcove off to the side, is empty. Metal tables and chairs are scattered around with little care for their arrangement. A heavy-set man stands in semi-darkness within the kitchen alcove stirring a pot. He is grinning at you. His lips are bright red.";
        userInterface.prepareText();

        userInterface.choice1.setText("Ask him about earning money");
        userInterface.choice2.setText("Ask about the soldiers");
        userInterface.choice3.setText("Buy some Sinigang na Baboy($7)");
        userInterface.choice4.setText("Back to corridor");
        userInterface.choice5.setText("");

        game.choiceButton1= "canteenWork";
        game.choiceButton2 = "askPhoneAboutSoldiers";
        game.choiceButton3 = "buySinigang";
        game.choiceButton4 = "bedFactoryCorridor";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void askPhoneAboutSoldiers(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/phoneImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "'I haven't seen anything,' he declares, laughing.'I am blind you see.'\n\nHe waves his hand in front of his eyes.\n\n'You may want to ask the foreman. I think he saw or heard something this morning, though he is reluctant to talk about it.'";
        userInterface.prepareText();

        if(player.getWeaponByName("M16").isEquipped()) {
            userInterface.choice1.setText("< < <");
            game.choiceButton1 = "canteen";
        }else{
            userInterface.choice1.setText("> > >");
            game.choiceButton1 = "askPhoneAboutSoldiers2";
        }

        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");


        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void askPhoneAboutSoldiers2(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/phoneImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "He leans in. His breath, like Vadig's, smells of almonds: 'I did however pick up something which might be of use to you. You must answer four riddles. One wrong answer and it's instant death.'\n\nHe draws his thumb across his throat.";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("Attempt Riddles");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "canteen";
        game.choiceButton2 = "riddleOne";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void riddleOne(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/phoneImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "'Excellent!' He exclaims and claps his hands. 'Okay. The first riddle.\n\n'What comes once in a minute, twice in a moment, but never in a thousand years?'";
        userInterface.prepareText();

        userInterface.choice1.setText("Thirty-one seconds");
        userInterface.choice2.setText("1/1000 of a decade");
        userInterface.choice3.setText("One-tenth of a century");
        userInterface.choice4.setText("The letter 'M");
        userInterface.choice5.setText("");

        game.choiceButton1= "youAwakenInTheBedFactory";
        game.choiceButton2 = "youAwakenInTheBedFactory";
        game.choiceButton3 = "youAwakenInTheBedFactory";
        game.choiceButton4 = "riddleTwo";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void riddleTwo(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/phoneImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "'That was an easy one,' he smiles. The garish red lips, you notice, are lipstick. He has no lips.\n\n'Next riddle - Vadig, 12 years old, is three times as old as Indrid. How old will they be when they are twice as old as Indrid?'";
        userInterface.prepareText();

        userInterface.choice1.setText("18");
        userInterface.choice2.setText("14");
        userInterface.choice3.setText("16");
        userInterface.choice4.setText("24");
        userInterface.choice5.setText("");

        game.choiceButton1= "youAwakenInTheBedFactory";
        game.choiceButton2 = "youAwakenInTheBedFactory";
        game.choiceButton3 = "riddleThree";
        game.choiceButton4 = "youAwakenInTheBedFactory";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void riddleThree(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/phoneImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "'Haha!' The leans in closer. 'Doing well, my child. You may conquer the world yet?'\n\n'Final riddle. A bakery has three slices of beef cut into eighths. Three quarters of all pieces are sold. How many pieces were not sold?'";
        userInterface.prepareText();

        userInterface.choice1.setText("6");
        userInterface.choice2.setText("8");
        userInterface.choice3.setText("9");
        userInterface.choice4.setText("12");
        userInterface.choice5.setText("");

        game.choiceButton1= "getTheM16";
        game.choiceButton2 = "youAwakenInTheBedFactory";
        game.choiceButton3 = "youAwakenInTheBedFactory";
        game.choiceButton4 = "youAwakenInTheBedFactory";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void getTheM16(){
        Player player = getPlayer();
        player.setWeaponToEquipped("M16");
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/m16Image.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "'Congratulations,' he punches your shoulder, reaches below the counter and lifts up a US army standard issue M16 rifle.\n\nYou warily take it. One worker stands at the snack machine in the corridor and glances in but he notices nothing untoward.\n(M16 added to Inventory)";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "canteen";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void canteenWork(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/sinigangRecipeImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "'Absolutely, dear fellow,' he slaps a hand down on the counter. 'I can't cook this stuff all by myself. Today's dish is Sinigang na Baboy. The workers just want fries, burgers or salads. To hell with them.\n\n'You must cook it to the following specifications. I'll give you $80. Ready?'";
        userInterface.prepareText();

        userInterface.choice1.setText("Yes");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "sinigangRecipe";
        game.choiceButton2 = "canteen";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void sinigangRecipe(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/sinigangRecipeImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "'In a pot, combine the chopped pork and water. Bring to a boil. Add tomatoes, onion and fish sauce and simmer for 1 hour. Add gabi and cook for 6 minutes. Add long beans and cook for 2 minutes. Add eggplant and cook for 2 minutes. Put in tamarind base. Finally, add bok choy and cook for one minute. Got it?'";
        userInterface.prepareText();

        userInterface.choice1.setText("Yes");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "cookingOne";
        game.choiceButton2 = "canteen";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void cookingTwo(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/cookingImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "You bring the pork and water to a boil as the canteen cook outlined and move onto the next stage.\n\nThe cook is staring into nothingness, a demented grin on his face.\n\nThe next ingredients are?";
        userInterface.prepareText();

        userInterface.choice1.setText("Onion, Tomatoes, Soy");
        userInterface.choice2.setText("Garlic, green beans, Soy");
        userInterface.choice3.setText("Tomatoes, Onion, Fish Sauce");
        userInterface.choice4.setText("Fish sauce, Garlic, Bok Choy");
        userInterface.choice5.setText("");

        game.choiceButton1= "cookingError";
        game.choiceButton2 = "cookingError";
        game.choiceButton3 = "cookingThree";
        game.choiceButton4 = "cookingError";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void cookingOne(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/cookingImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "You go into the darkened kitchen and turn on the light. After washing your hands, you stand at the stove and get ready to cook. You really don't have time for all this nonsense. Where to start?";
        userInterface.prepareText();

        userInterface.choice1.setText("Combine pork and water");
        userInterface.choice2.setText("Combine pork and vinegar");
        userInterface.choice3.setText("Combine pork and fish sauce");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "cookingTwo";
        game.choiceButton2 = "cookingError";
        game.choiceButton3 = "cookingError";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void cookingThree(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/cookingImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "You let the broth simmer for an hour after adding the tomatoes, onion and fish sauce.\n\nIn the meantime, the cook has been drinking water straight from a bowl. His lipstick marks the rim.";
        userInterface.prepareText();

        userInterface.choice1.setText("Add Brie");
        userInterface.choice2.setText("Add Long Beans");
        userInterface.choice3.setText("Add Gabi");
        userInterface.choice4.setText("Add Bok Choy");
        userInterface.choice5.setText("");

        game.choiceButton1= "cookingError";
        game.choiceButton2 = "cookingError";
        game.choiceButton3 = "cookingFour";
        game.choiceButton4 = "cookingError";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void cookingFour(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/cookingImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "You have added the gabi. You have never encountered this ingredient before. Apparently it's poisonous when eaten raw.\n\nYou let it cook for 6 minutes, then?";
        userInterface.prepareText();

        userInterface.choice1.setText("Add Rice");
        userInterface.choice2.setText("Add Long Beans");
        userInterface.choice3.setText("Add Bok Choy");
        userInterface.choice4.setText("Add Eggplant");
        userInterface.choice5.setText("");

        game.choiceButton1= "cookingError";
        game.choiceButton2 = "cookingFive";
        game.choiceButton3 = "cookingError";
        game.choiceButton4 = "cookingError";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void cookingFive(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/cookingImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "You add the long beans and let it cook for two minutes. The cook has vanished from view but you get the odd feeling that he is standing behind the wall to the kitchen alcove.";
        userInterface.prepareText();

        userInterface.choice1.setText("Add Tamarind");
        userInterface.choice2.setText("Add Long Beans");
        userInterface.choice3.setText("Add Bok Choy");
        userInterface.choice4.setText("Add Eggplant");
        userInterface.choice5.setText("");

        game.choiceButton1= "cookingError";
        game.choiceButton2 = "cookingError";
        game.choiceButton3 = "cookingError";
        game.choiceButton4 = "cookingSix";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void cookingSix(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/cookingImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "You have added the eggplant and let it cook for two minutes.\n\nThe cook is now humming what sounds like 'Bridge Over Troubled Water by Simon & Garfunkel.";
        userInterface.prepareText();

        userInterface.choice1.setText("Add Chilli");
        userInterface.choice2.setText("Add Tamarind base");
        userInterface.choice3.setText("Add Bok Choy");
        userInterface.choice4.setText("Add Potato");
        userInterface.choice5.setText("");

        game.choiceButton1= "cookingError";
        game.choiceButton2 = "cookingSeven";
        game.choiceButton3 = "cookingError";
        game.choiceButton4 = "cookingError";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void cookingSeven(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/cookingImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "You add the Tamarind base. The cook stands beside you impatiently. He is cackling softly to himself. You only have one ingredient left to add.";
        userInterface.prepareText();

        userInterface.choice1.setText("Add Chicken");
        userInterface.choice2.setText("Add Olives");
        userInterface.choice3.setText("Add Fish Sauce");
        userInterface.choice4.setText("Add Bok Choy");
        userInterface.choice5.setText("");

        game.choiceButton1= "cookingError";
        game.choiceButton2 = "cookingError";
        game.choiceButton3 = "cookingError";
        game.choiceButton4 = "sinigangComplete";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void sinigangComplete(){
        Player player = getPlayer();
        player.setCash(player.getCash()+80);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "'Well done,' he says. 'You have cooked lunch though I don't think anyone here will eat it. They don't want unusual foods.'\n\nHe hands over $80 in cash and adds:'You earned this.'\n(Cash increased by +$80)";
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "canteen";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void cookingError(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/cookingerror.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        userInterface.text = "'No! No! No!' He collapses against the wall dramatically, then picks up the cooking pot and pours it into the sink. 'You did it wrong. You're going to have to start over. Must I repeat the recipe?'";
        userInterface.prepareText();

        userInterface.choice1.setText("Ask for recipe");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "sinigangRecipe";
        game.choiceButton2 = "canteen";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void buySinigang(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/sinigang.jpeg");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Bed Factory Canteen");

        if(player.getCash()>=7){
            userInterface.text = "The cook serves you a bowl of Sinigang na Baboy with rice. It's the most delicious thing you have eaten in a long time, also the first Filipino dish you have tried. You need to try more if you survive this mess. It's also very healthy.\n(Health increased by +17. Cash decreased by -$7)";
            player.setCash(player.getCash()-7);
            player.setHealthPoints(player.getHealthPoints()+17);
        } else{
            userInterface.text = "'I don't intend to give you a free meal,' the cook chuckles. 'Everyone must have a job in this economy. This universe is a harsh mistress, like the moon.'";
        }
        userInterface.prepareText();

        userInterface.choice1.setText("< < <");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "canteen";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void intoUniformDisguise(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/uniformImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Meera's Bed Factory");

        userInterface.text = "Now properly attired you feel as though you will be able to enter this side door without being gunned down. You are ready to face whatever awaits you in the bed factory basement. It simply remains for you to keep your cool, no matter what happens.";
        userInterface.prepareText();

        userInterface.choice1.setText("Leave");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "bedFactory";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton6 = "enterBedFactoryBasement";
        game.inventoryButton1 = "getArmyUniform";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void enterBedFactoryBasement(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/sandbagsImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Factory Basement");

        userInterface.text = "You use the keycard and walk down a flight of stairs towards some soldiers standing in the gloom at the bottom behind some sandbags. Once they see the uniform they point their M16s away and allow you to squeeze past into long narrow corridor.\n\nThe door has locked behind you. There is no going back.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "generalChambersOfficeDoor";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton6 = "getKeyCard";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void generalChambersOfficeDoor(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/whiteDoorImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Factory Basement");

        userInterface.text = "You walk to the end of the corridor lit by strip lighting. A single unmarked door lies at its end. You put your ear to it and hear the whirr of machinery, but underneath this an unearthly drone resounds.";
        userInterface.prepareText();

        userInterface.choice1.setText("Enter Room");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "generalChambersOffice";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton6 = "getKeyCard";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void generalChambersOffice(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/chambersDeskImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("General Chambers' Office");

        userInterface.text = "You enter a long grey-carpeted room with a low ceiling and blank walls. At its end is a large oak desk. Behind it sits a large man in a General's gray uniform with various coloured badges on his lapel. He is sitting in front of white double doors.\n\nHe stands when he sees you enter.";
        userInterface.prepareText();


        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "generalChambersOffice2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void generalChambersOffice2(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/chambersDeskImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("General Chambers' Office");

        userInterface.text = "'It's you!' He exclaims. He is a large older man with sunburn much like your own. 'How did you get in here? The creature foretold that you would come and be my doom but but I took all precautions. You won't get past me! The creature is mine.'\n\nHe pulls out his own M16 and starts firing.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "generalChambersAttacks";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void generalChambersAttacks(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("General Chambers");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int enemyAttack = enemy.attackPlayer(player.getDefence(), attackRoll);

        player.takeDamage(enemyAttack);

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/chambersFires.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Fight with General Chambers");

        userInterface.text = "General Chambers shoots his M16.\n\nENEMY D20 ATTACK ROLL: " + attackRoll + " vs YOUR DEFENCE RATING: " + player.getDefence() + "\n\nGeneral Chambers inflicts " + enemyAttack + " points of damage.";
        userInterface.prepareText();

        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if (player.getHealthPoints() <= 0) {
            game.choiceButton1 = "youAwaken";
            userInterface.choice1.setText("> > >");
            game.choiceButton2 = "";
            userInterface.choice2.setText("");
        } else {
            game.choiceButton1 = "grappleChambers";
            userInterface.choice1.setText("Grapple Chambers");
            if(player.getInspiration()>0){
            game.choiceButton2 = "inspiredAttackAgainstChambers";
            userInterface.choice2.setText("Inspired Attack");}
        }

        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        if(player.getWeaponByName("M16").isEquipped()&&player.getHealthPoints()>0)
        {game.weapon4 ="shootAtGeneralChambers";}

        if(player.getWeaponByName("Baseball Bat").isEquipped()&&player.getHealthPoints()>0){
            game.weapon2 = "baseballBatAgainstChambers";
        }

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void shootAtGeneralChambers(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("General Chambers");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int damageTotal = player.attackEnemyWithWeapon(enemy.getDefence(), attackRoll, "M16");

        enemy.takeDamage(damageTotal);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/firingGunImage.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with General Chambers");

        if(player.getWeaponByName("M16").getAmmo()>0){
            enemy.takeDamage(damageTotal);
            userInterface.text = "M16 has " + player.getWeaponByName("M16").getAmmo()+ " bullets left.\n\nGeneral Chambers HP:"+enemy.getHealthPoints()+"\nYou shoot the M16 to add +14 damage to a successful attack roll.\n\nD20 ATTACK ROLL: "+attackRoll+" vs GENERAL CHAMBERS DEFENCE RATING: "+enemy.getDefence()+"\nYou inflict " + damageTotal+ " points of damage.";
        } else{ userInterface.text = "You pull on the trigger. Nothing happens. Out of bullets, hombre.";}
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "generalChambersAttacks";
        } else{
            game.choiceButton1 = "winOverGeneralChambers";
        }
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon1 = "getAlloyTube";
        game.weapon2 = "getBaseballBat";
        game.weapon4 ="getM16";

        player.getWeaponByName("M16").setAmmo(player.getWeaponByName("M16").getAmmo()-1);
        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void grappleChambers(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("General Chambers");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int playerAttack = player.attackEnemy(enemy.getDefence(), attackRoll);

        enemy.takeDamage(playerAttack);

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/grappleChambers.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Fight with General Chambers");

        userInterface.text = "General Chambers HP: "+enemy.getHealthPoints()+"\n\nYOUR D20 ATTACK ROLL: "+attackRoll+" vs GENERAL CHAMBERS DEFENCE RATING: "+enemy.getDefence()+"\n\nYou grapple with the General and inflict " + playerAttack+ " points of damage";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "generalChambersAttacks";
        } else{
            game.choiceButton1 = "winOverGeneralChambers";
        }
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon1 = "getAlloyTube";
        game.weapon2 = "getBaseballBat";
        game.weapon4 ="getM16";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void inspiredAttackAgainstChambers(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("General Chambers");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int roll = player.attackEnemy(enemy.getDefence(), attackRoll);

        int damageTotal = roll +3;

        enemy.takeDamage(damageTotal);

        player.setInspiration(player.getInspiration()-1);

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/inspiredChambersGrapple.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Fight with General Chambers");

        userInterface.text = "You use 1 General Chambers HP: "+enemy.getHealthPoints()+"\nYou used 1 point of Inspiration to add +3 damage to a successful or unsuccessful attack roll.\n\nYOUR D20 ATTACK ROLL: "+attackRoll+" vs GENERAL CHAMBERS DEFENCE RATING: "+enemy.getDefence()+"\n\nYou grapple with the General and inflict " + damageTotal+ " points of damage";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "generalChambersAttacks";
        } else{
            game.choiceButton1 = "winOverGeneralChambers";
        }
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon1 = "getAlloyTube";
        game.weapon2 = "getBaseballBat";
        game.weapon4 ="getM16";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void baseballBatAgainstChambers(){
        Player player = getPlayer();
        Enemy enemy = getEnemyByName("General Chambers");
        inventoryButtons();
        weaponButtons();

        int attackRoll = new java.util.Random().nextInt(20);

        int damageTotal = player.attackEnemyWithWeapon(enemy.getDefence(), attackRoll, "Baseball Bat");

        enemy.takeDamage(damageTotal);

        ImageIcon shimmer = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/batAttackImage.png");
        userInterface.imageLabel.setIcon(shimmer);
        userInterface.locationTextArea.setText("Fight with General Chambers");

        userInterface.text = "General Chambers HP:"+enemy.getHealthPoints()+"\nYou used the Baseball Bat to add +9 damage to a successful attack roll.\n\nD20 ATTACK ROLL: "+attackRoll+" vs GENERAL CHAMBERS DEFENCE RATING: "+enemy.getDefence()+"\nYou inflict " + damageTotal+ " points of damage.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        if(enemy.getHealthPoints()>0){
            game.choiceButton1 = "generalChambersAttacks";
        } else{
            game.choiceButton1 = "winOverGeneralChambers";
        }
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon2 = "getBaseballBat";
        game.weapon4 ="getM16";

        getPlayerDefault();
        this.game.getEnemyRepository().save(enemy);
        this.game.getPlayerRepository().save(player);
    }

    public void winOverGeneralChambers(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/chambersBeatenImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("General Chambers' Office");

        userInterface.text = "After a terse exchange of gunfire, the immense body of General Chambers slumps back against the double doors he was protecting and slides down it, painting the wood red. His breathing is laboured yet he manages to emit a chuckle.\n\n'Well done,' he mutters. 'What was it all for anyhow?'";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "winOverGeneralChambers2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon2 = "getBaseballBat";
        game.weapon4 ="getM16";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void winOverGeneralChambers2(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/chambersBeatenImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("General Chambers' Office");

        userInterface.text = "'My only goal was to help mankind into the future,' he says, breathing hard. You are standing over him. 'The damn planet is dying. Reality is a chaotic mess. Human beings multiply, fight each other, love each other. All this stupid ceaseless activity and we can't get to the heart of it all. It's all just mirrors reflecting mirrors.'";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "winOverGeneralChambers3";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.weapon2 = "getBaseballBat";
        game.weapon4 ="getM16";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void winOverGeneralChambers3(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/chambersBeatenImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("General Chambers' Office");

        userInterface.text = "'I have seen beyond the veil,' he splutters. 'This reality is not what we think it is, but that knowledge will never do us any good if we don't have that creature's power. Do what you think is right? Breathing through the tube in there will give you all its powers of prophecy, but it will die.'";
        userInterface.prepareText();

        userInterface.choice1.setText("Enter double doors");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "goIntoLab";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void goIntoLab(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mothmanLabImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("The Mothman");

        userInterface.text = "You enter the room beyond the doors. It is surprisingly small and dark. Amidst the bed factory machinery lying in storage is a single light source, glowing purple.\n\nIt is a 11ft tall piece of alien tech, made up mostly of a tall glowing bell jar filled with purple swirling smoke. Within is a winged creature, dimly seen, with glowing red eyes.";
        userInterface.prepareText();

        userInterface.choice1.setText("Investigate");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "investigateMothmanPrison";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void investigateMothmanPrison(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/scaredManImg.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("The Mothman");

        userInterface.text = "Upon the base of this bell jar are various runes and carvings in what looks like dark sandstone. The creature presses its rough head against the glass. It is severely weakened. A whorl shape is missing from a panel section outside the glass next to the it's foot. A pipe juts out of the base at mouth height, from which you may imbibe the Mothman's powers.";
        userInterface.prepareText();

        userInterface.choice1.setText("Imbibe Smoke");
        userInterface.choice2.setText("Leave");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "imbibeSmoke";
        game.choiceButton2 = "leaveMothman";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton7 = "freeMothman";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void freeMothman(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mothmanImg.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("The Mothman");

        userInterface.text = "You press the ammonite to the panel. The bell jar lifts slowly, hovering in the air by unknown means, pouring this purple smoke into the room and obscuring your sight. You wonder whether this was a mistake. It's intention was good however. It had come to warn us about the power plant.\n\nIt's 10ft wings unfurl...";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton7 = "getAmmonite";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void freeMothman2(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/mothmanImg.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("The Mothman");

        userInterface.text = "It flies up to the ceiling and passes through it. You are left in the dark basement. The smoke smells like almonds.\n\nHad you taken the last of the Mothman's prophetic powers upon yourself, you know that humanity might've had a future, instead of being forced to rely on the mercy of interdimensional beings.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "endingOne";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton7 = "getAmmonite";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void imbibeSmoke(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/purpleSmokeImage.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("The Mothman");

        userInterface.text = "You press your lips to the tube and breath in. The smoke tastes like almonds.\n\nThe creature inside the bell jar writhes and collapses within the swirling purple smoke.\n\nYour head feels as if it will explode. Something is happening...";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "imbibeSmoke2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        game.inventoryButton7 = "getAmmonite";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void imbibeSmoke2(){
        Player player = getPlayer();
        player.setInsight(player.getInsight()+3000);
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("src/main/java/com/pointpleasant/PointPleasantGame/game/resources/outside.png");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("*&^^C^$C*(&");

        userInterface.text = "*^54HUK^%TRC$£908h%*&^5$9*&^%$£&*^(&*GGtY^%ytRCcuv]][&%V^%ioin87n887%C$*^54HUK^%TRC$£908h%*&^5$9*&^%$£&*^(&*GGtY^%ytRCcuv]][&%V^%ioin87n887%C$*^54HUK^%TRC$£908h%*&^5$9*&^%$£&*(&*GGtY^%ytRCcuv]][&%V^%ioin87n887%C$*^54HUK^%TRC$£908h%*&^5$9*\n(Insight increased +3000)";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("784677&^");
        userInterface.choice3.setText("*^0(*&76B");
        userInterface.choice4.setText("&^%V&^%5C$");
        userInterface.choice5.setText("&^V%$$£X");

        game.choiceButton1= "endingTwo";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void endingOne(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Leaving Town");

        userInterface.text = "The next morning, you drop Mary off at her house after she has fixed your car. Down below in the industrial estate, you can see soldiers putting equipment into the back of jeeps. They are leaving as well. It seems as if all the strangeness has ended. Phones and the internet are operational again.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "endingOne2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void endingOne2(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Leaving Town");

        userInterface.text = "'I'm not sure what it going to happen now,' she says. 'I'm thinking of writing a book about all of this with my friend, John Leek, though I don't think anyone will believe it.'\n\nYou shake her hand and drive to the bridge that will take you out of town.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "endingOne2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void endingOne3(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Leaving Town");

        userInterface.text = "Before you can reach the bridge, you are stopped by a policeman. Many other cars are queued on the road ahead of you.\n\n'You're going to have to find another route out of town, sir,' he says shakily. 'The Silver Bridge has just collapsed.'";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "endingOne2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void endingOne4(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Leaving Town");

        userInterface.text = "You step out of your car and head towards the Ohio River. People are screaming, held back by police.\n\nThe bridge is a twisted hunk of metal with the middle vanished. In the water, you see Christmas presents floating. The Mothman did not come to warn about the power plant, but about the bridge.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "endCredits";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void endingTwo(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Leaving Town");

        userInterface.text = "It is 8am, you are sitting in your car across two lanes of traffic on the road just before the Silver Bridge that leads out of town. On the other side of the bridge you have parked the I.Cold Refrigeration truck, blocking traffic from the other end.\n\nYou have handcuffed yourself to the wheel. ";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "endingTwo2";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void endingTwo2(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("");
        userInterface.imageLabel.setIcon(image);
        userInterface.locationTextArea.setText("Leaving Town");

        userInterface.text = "A policeman is thumping at your window. Within an hour they will drag you out of the car. The Mothman came to warn people of the collapse of the bridge, not the faked power plant disaster. You now understand the vision of the Christmas presents floating in the water.\n\nYour insight changes nothing.";
        userInterface.prepareText();

        userInterface.choice1.setText("> > >");
        userInterface.choice2.setText("");
        userInterface.choice3.setText("");
        userInterface.choice4.setText("");
        userInterface.choice5.setText("");

        game.choiceButton1= "endCredits";
        game.choiceButton2 = "";
        game.choiceButton3 = "";
        game.choiceButton4 = "";
        game.choiceButton5 = "";

        getPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }

    public void endCredits(){
        Player player = getPlayer();
        inventoryButtons();
        weaponButtons();

        ImageIcon image = new ImageIcon("");
        userInterface.imageLabel.setIcon(image);

        userInterface.titleNamePanel.setVisible(false);
        userInterface.startButtonPanel.setVisible(false);
        userInterface.titleImagePanel.setVisible(false);

        userInterface.introPanel.setVisible(false);
        userInterface.introButtonPanel.setVisible(true);


        userInterface.mainTextPanel.setVisible(false);
        userInterface.choiceButtonPanel.setVisible(false);
        userInterface.playerStatsPanel.setVisible(false);
        userInterface.locationPanel.setVisible(false);
        userInterface.mainTextPanel.setVisible(false);
        userInterface.choiceButtonPanel.setVisible(false);
        userInterface.imagePanel.setVisible(true);
        userInterface.inventoryPanel.setVisible(false);
        userInterface.playerStatsPanel.setVisible(false);
        userInterface.itemDescriptionPanel.setVisible(false);

        userInterface.introButton.setActionCommand("titleScreenAfterCredits");

        setPlayerDefault();
        this.game.getPlayerRepository().save(player);
    }
}
