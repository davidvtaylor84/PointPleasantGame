package com.pointpleasant.PointPleasantGame.models.enemies;

import com.pointpleasant.PointPleasantGame.models.Player;

import java.util.Random;

public abstract class Enemy implements IEnemyAttack{

    private String name;
    private String race;
    private int healthPoints;

    private int attackPower;
    private int enemyInsight;
    Player player;

    public Enemy(String name, String race, int healthPoints, int attackPower, int enemyInsight) {
        this.name = name;
        this.race = race;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
        this.enemyInsight = enemyInsight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void takeDamage(int damagePoints){
        healthPoints -= damagePoints;
    }

    public void increaseHealth(int increase){
        healthPoints+= increase;
    }

    public void enemyAttack(Player player){
        player.takeDamage(this.attackPower);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getEnemyInsight() {
        return enemyInsight;
    }

    public void setEnemyInsight(int enemyInsight) {
        this.enemyInsight = enemyInsight;
    }

    public int diceRoll(){
        Random rand = new Random();
        int upperbound = 20;
        int min = 1;
        return rand.nextInt(upperbound-min)+1;
    }
}
