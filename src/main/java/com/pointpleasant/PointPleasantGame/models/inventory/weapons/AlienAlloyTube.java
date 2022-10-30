package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

public class AlienAlloyTube extends Weapon {

    private int batteryPower;

    public AlienAlloyTube(String description, int damageValue, boolean equipped, int batteryPower) {
        super(description, damageValue, equipped);
        this.batteryPower = batteryPower;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }
}
