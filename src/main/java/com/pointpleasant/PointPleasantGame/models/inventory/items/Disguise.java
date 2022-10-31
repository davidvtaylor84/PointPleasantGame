package com.pointpleasant.PointPleasantGame.models.inventory.items;

public class Disguise extends Item{


    private int armourRating;


    public Disguise(String name, String description, boolean equipped, int armourRating) {
        super(name, description, equipped);
        this.armourRating = armourRating;
    }

    public int getArmourRating() {
        return armourRating;
    }

    public void setArmourRating(int armourRating) {
        this.armourRating = armourRating;
    }
}
