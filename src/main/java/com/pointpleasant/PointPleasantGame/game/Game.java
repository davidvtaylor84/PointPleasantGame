package com.pointpleasant.PointPleasantGame.game;

import com.pointpleasant.PointPleasantGame.models.inventory.items.Key;
import com.pointpleasant.PointPleasantGame.repositories.EnemyRepository;
import com.pointpleasant.PointPleasantGame.repositories.PlayerRepository;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    DecisionHandler decisionHandler = new DecisionHandler();
    UserInterface userInterface = new UserInterface();
    VisibilityManager visibilityManager = new VisibilityManager(userInterface);

    Story story = new Story(this, userInterface, visibilityManager);

    private PlayerRepository playerRepository;
    private EnemyRepository enemyRepository;

    String choiceButton1, choiceButton2, choiceButton3, choiceButton4, choiceButton5;
    String inventoryButton1, inventoryButton2, inventoryButton3, inventoryButton4, inventoryButton5, inventoryButton6, inventoryButton7, inventoryButton8, weapon1, weapon2, weapon3, weapon4;

    public static void main(String[] args){
//        new Game();
    }

    public Game(PlayerRepository playerRepository, EnemyRepository enemyRepository){
        this.playerRepository = playerRepository;
        this.enemyRepository = enemyRepository;
        userInterface.createInterface(decisionHandler);
//        story.playerDefault();
        visibilityManager.showTitleScreen();
    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public EnemyRepository getEnemyRepository(){return enemyRepository;}

    public void Game(){}

    public class DecisionHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String yourDecision = e.getActionCommand();

            switch (yourDecision){
                case "start": visibilityManager.showIntroScreen();story.setPlayerDefault(); story.inventoryButtons();break;
                case "continue": visibilityManager.showGameScreen(); story.askAfterMary();break;
                case "startAfterIntro": visibilityManager.showGameScreen(); story.getPlayerDefault(); story.breakdown();break;
                case "c1": story.selectChoice(choiceButton1);break;
                case "c2": story.selectChoice(choiceButton2);break;
                case "c3": story.selectChoice(choiceButton3);break;
                case "c4": story.selectChoice(choiceButton4);break;
                case "c5": story.selectChoice(choiceButton5);break;

                case "inventory1": story.selectChoice(inventoryButton1); break;
                case "inventory2": story.selectChoice(inventoryButton2); break;
                case "inventory3": story.selectChoice(inventoryButton3); break;
                case "inventory4": story.selectChoice(inventoryButton4); break;
                case "inventory5": story.selectChoice(inventoryButton5); break;
                case "inventory6": story.selectChoice(inventoryButton6); break;
                case "inventory7": story.selectChoice(inventoryButton7); break;
                case "inventory8": story.selectChoice(inventoryButton8); break;

                case "weapon1": story.selectChoice(weapon1); break;
                case "weapon2": story.selectChoice(weapon2); break;
                case "weapon3": story.selectChoice(weapon3); break;
                case "weapon4": story.selectChoice(weapon4); break;


            }

        }
    }

}
