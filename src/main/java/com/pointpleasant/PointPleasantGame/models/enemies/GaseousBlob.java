package com.pointpleasant.PointPleasantGame.models.enemies;

import javax.persistence.Column;
import javax.persistence.Entity;

//@Entity
public class GaseousBlob extends Enemy{

//    @Column(name = "stinkrating")
    private int stinkRating;

    public GaseousBlob(String name, String race, int healthPoints, int attackPower, int enemyInsight, int stinkRating) {
        super(name, race, healthPoints, attackPower, enemyInsight);
        this.stinkRating = stinkRating;
    }

    public GaseousBlob(){};

    public int getStinkRating() {
        return stinkRating;
    }

    public void setStinkRating(int stinkRating) {
        this.stinkRating = stinkRating;
    }
}
