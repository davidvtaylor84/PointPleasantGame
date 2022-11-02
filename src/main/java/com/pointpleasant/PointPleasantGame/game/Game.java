package com.pointpleasant.PointPleasantGame.game;

import com.pointpleasant.PointPleasantGame.models.inventory.items.Key;
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

    String choiceButton1, choiceButton2, choiceButton3, choiceButton4, choiceButton5;

    public static void main(String[] args){
//        new Game();
    }

    public Game(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
        userInterface.createInterface(decisionHandler);
//        story.playerDefault();
        visibilityManager.showTitleScreen();
    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public void Game(){}

    public class DecisionHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String yourDecision = e.getActionCommand();

            switch (yourDecision){
                case "start": visibilityManager.showIntroScreen();story.playerDefault();break;
                case "continue": visibilityManager.showGameScreen();break;
                case "startAfterIntro": visibilityManager.showGameScreen(); story.breakdown();break;
                case "c1": story.selectChoice(choiceButton1);break;
                case "c2": story.selectChoice(choiceButton2);break;
                case "c3": story.selectChoice(choiceButton3);break;
                case "c4": story.selectChoice(choiceButton4);break;
                case "c5": story.selectChoice(choiceButton5);break;
            }

        }
    }

}
