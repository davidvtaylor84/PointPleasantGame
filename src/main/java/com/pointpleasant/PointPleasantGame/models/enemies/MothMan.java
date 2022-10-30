package com.pointpleasant.PointPleasantGame.models.enemies;

import com.pointpleasant.PointPleasantGame.models.Player;


import java.util.ArrayList;
import java.util.Random;

public class MothMan extends Enemy{

    ArrayList<MothmanProphecies> prophecies;

    Player player;


    public MothMan(String name, String race, int healthPoints, int attackPower, int enemyInsight) {
        super(name, race, healthPoints, attackPower, enemyInsight);
        this.prophecies = new ArrayList<>();
    }

    public ArrayList<MothmanProphecies> getProphecies() {
        return prophecies;
    }

    public void setProphecies(ArrayList<MothmanProphecies> prophecies) {
        this.prophecies = prophecies;
    }

    public void enemyAttack(Player player){
        Random rand = new Random();
        int upperbound = 10;
        int min = 1;
        int diceRoll = rand.nextInt(upperbound-min)+1;
        if(diceRoll >=7){
            System.out.println(this.prophecies.get(0));
            this.increaseHealth(20);
            player.takeDamage(50);
        }else{player.takeDamage(this.getAttackPower());}
        System.out.println(diceRoll);
    }



}
