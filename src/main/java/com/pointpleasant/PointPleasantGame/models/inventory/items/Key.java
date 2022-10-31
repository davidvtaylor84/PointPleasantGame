package com.pointpleasant.PointPleasantGame.models.inventory.items;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Key extends Item {


    @Column(name="used")
    private String used;

    public Key(String name, String description, boolean equipped, Player player, String used) {
        super(name, description, equipped, player);
        this.used = used;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }
}
