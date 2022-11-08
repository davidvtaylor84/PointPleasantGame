package com.pointpleasant.PointPleasantGame.models.enemies;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

@Entity
@Table(name = "enemies")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Enemy{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name="race")
    private String race;

    @Column(name = "healthPoints")
    private int healthPoints;


    @Column(name = "attackPower")
    private int attackPower;


    @Column(name = "defence")
    private int defence;

    public Enemy(String name, String race, int healthPoints, int attackPower, int defence) {
        this.name = name;
        this.race = race;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
        this.defence = defence;
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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }


    public int diceRoll(){
        Random rand = new Random();
        int upperbound = 20;
        int min = 1;
        return rand.nextInt(upperbound-min)+1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int attackPlayer(int playerDefence, int attackRoll){
        if(attackRoll >= playerDefence){
            return this.attackPower;
        }
        else{
            return 0;
        }
    }
}
