package com.pointpleasant.PointPleasantGame.models.inventory.items;

import com.pointpleasant.PointPleasantGame.models.inventory.IImplement;

public class Torch extends Item {


    private int batteryPower;

    public Torch(String name, String description, boolean equipped, int batteryPower) {
        super(name, description, equipped);
        this.batteryPower = batteryPower;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }
}
