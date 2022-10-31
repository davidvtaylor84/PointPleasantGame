package com.pointpleasant.PointPleasantGame.models.inventory.items;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Disguise extends Item{

    @Column(name="armourRating")
    private int armourRating;


    public Disguise(String name, String description, boolean equipped, Player player, int armourRating) {
        super(name, description, equipped, player);
        this.armourRating = armourRating;
    }

    public int getArmourRating() {
        return armourRating;
    }

    public void setArmourRating(int armourRating) {
        this.armourRating = armourRating;
    }
}
