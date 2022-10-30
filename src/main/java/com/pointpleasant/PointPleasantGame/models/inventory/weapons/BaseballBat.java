package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

public class BaseballBat extends Weapon {

    private int fragility;

    public BaseballBat(String description, int damageValue, boolean equipped, int fragility) {
        super(description, damageValue, equipped);
        this.fragility = fragility;
    }

    public int getFragility() {
        return fragility;
    }

    public void setFragility(int fragility) {
        this.fragility = fragility;
    }
}
