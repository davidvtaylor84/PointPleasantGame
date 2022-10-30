package com.pointpleasant.PointPleasantGame.models.inventory.items;

import com.pointpleasant.PointPleasantGame.models.inventory.IImplement;

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
