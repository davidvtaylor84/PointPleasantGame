package com.pointpleasant.PointPleasantGame.models.enemies;

public class GaseousBlob extends Enemy{

    private int stinkRating;

    public GaseousBlob(String name, String race, int healthPoints, int attackPower, int enemyInsight, int stinkRating) {
        super(name, race, healthPoints, attackPower, enemyInsight);
        this.stinkRating = stinkRating;
    }

    public int getStinkRating() {
        return stinkRating;
    }

    public void setStinkRating(int stinkRating) {
        this.stinkRating = stinkRating;
    }
}
