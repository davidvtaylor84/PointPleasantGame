package com.pointpleasant.PointPleasantGame.models.enemies;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "enemies")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Enemy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @Column(name = "name")
    private String name;

    @Id
    @Column(name="race")
    private String race;
    @Id
    @Column(name = "healthpoints")
    private int healthPoints;

    @Id
    @Column(name = "attackpower")
    private int attackPower;

    @Id
    @Column(name = "enemyinsight")
    private int enemyInsight;

    public Enemy(String name, String race, int healthPoints, int attackPower, int enemyInsight) {
        this.name = name;
        this.race = race;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
        this.enemyInsight = enemyInsight;
    }

    public Enemy(){}

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
