package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

import com.pointpleasant.PointPleasantGame.models.Player;

public class AlienAlloyTube extends Weapon {

    private int batteryPower;

    public AlienAlloyTube(String name, String description, int damageValue, boolean equipped, Player player, int batteryPower) {
        super(name, description, damageValue, equipped, player);
        this.batteryPower = batteryPower;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }
}
