package com.pointpleasant.PointPleasantGame.models.inventory.items;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class HealthBooster extends Item implements IActivateItem{

    @Column(name="restorativePoints")
    private int restorativePoints;

    public HealthBooster(String name, String description, boolean equipped, int restoration, Player player, int restorativePoints) {
        super(name, description, equipped, restoration, player);
        this.restorativePoints = restorativePoints;
    }

    public HealthBooster(){}

    public int getRestorativePoints() {
        return restorativePoints;
    }

    public void setRestorativePoints(int restorativePoints) {
        this.restorativePoints = restorativePoints;
    }

    public void activateItem(){
        setEquipped(true);
    }

}
