package com.pointpleasant.PointPleasantGame.models;

import com.pointpleasant.PointPleasantGame.models.items.IImplement;

import java.util.ArrayList;

public class Player {

    String name;
    Integer healthPoints;
    Integer insight;
    Integer defence;
    Integer intelligence;
    Integer inspiration;
    Integer gameProgress;
    ArrayList<IImplement> items;

    public Player(String name, Integer healthPoints, Integer insight, Integer defence, Integer intelligence, Integer inspiration, Integer gameProgress) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.insight = insight;
        this.defence = defence;
        this.intelligence = intelligence;
        this.inspiration = inspiration;
        this.gameProgress = gameProgress;
        this.items = new ArrayList<>();
    }

    public Player(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getInsight() {
        return insight;
    }

    public void setInsight(Integer insight) {
        this.insight = insight;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getInspiration() {
        return inspiration;
    }

    public void setInspiration(Integer inspiration) {
        this.inspiration = inspiration;
    }

    public Integer getGameProgress() {
        return gameProgress;
    }

    public void setGameProgress(Integer gameProgress) {
        this.gameProgress = gameProgress;
    }

    public ArrayList<IImplement> getItems() {
        return items;
    }

    public void setItems(ArrayList<IImplement> items) {
        this.items = items;
    }

    public void takeDamage(int damage){
        this.healthPoints -= damage;
        if(this.healthPoints < 1){
            System.out.println(this.name+ " no longer answers to their name.");
        }
    }
}
