package com.pointpleasant.PointPleasantGame.models.inventory.items;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Torch extends Item {


    @Column(name = "batteryPower")
    private int batteryPower;

    public Torch(String name, String description, boolean equipped, Player player, int batteryPower) {
        super(name, description, equipped, player);
        this.batteryPower = batteryPower;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }
}
