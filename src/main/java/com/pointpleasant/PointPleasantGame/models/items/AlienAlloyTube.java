package com.pointpleasant.PointPleasantGame.models.items;

public class AlienAlloyTube extends Weapon{

    private int batteryPower;

    public AlienAlloyTube(String description, int damageValue, int batteryPower) {
        super(description, damageValue);
        this.batteryPower = batteryPower;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }
}
