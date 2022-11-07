package com.pointpleasant.PointPleasantGame.models.inventory.items;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Disguise extends Item implements IActivateItem{

    @Column(name="armourRating")
    private int armourRating;


    public Disguise(String name, String description, boolean equipped, int restoration, Player player, int armourRating) {
        super(name, description, equipped, restoration, player);
        this.armourRating = armourRating;
    }

    public Disguise(){}

    public int getArmourRating() {
        return armourRating;
    }

    public void setArmourRating(int armourRating) {
        this.armourRating = armourRating;
    }

    public void activateItem(){
        setEquipped(true);
    }
}
