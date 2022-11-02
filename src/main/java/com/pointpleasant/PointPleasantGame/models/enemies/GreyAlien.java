package com.pointpleasant.PointPleasantGame.models.enemies;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class GreyAlien extends Enemy implements IEnemyAttack {

    @Column(name = "homedimension")
    private String homeDimension;

    @Column(name = "sponginess")
    private int sponginess;



    public GreyAlien(String name, String race, int healthPoints, int attackPower,int enemyInsight, String homeDimension, int sponginess) {
        super(name, race, healthPoints, attackPower, enemyInsight);
        this.homeDimension = homeDimension;
        this.sponginess = sponginess;
    }

    public GreyAlien(){}

    public String getHomeDimension() {
        return homeDimension;
    }

    public int getSponginess() {
        return sponginess;
    }

    public void increaseSponginess(int sponginess){
        this.increaseHealth(30);
    }

}
