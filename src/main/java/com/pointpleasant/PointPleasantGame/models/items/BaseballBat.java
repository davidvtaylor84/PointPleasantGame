package com.pointpleasant.PointPleasantGame.models.items;

public class BaseballBat extends Weapon{

    private int fragility;

    public BaseballBat(String description, int damageValue, int fragility) {
        super(description, damageValue);
        this.fragility = fragility;
    }

    public int getFragility() {
        return fragility;
    }

    public void setFragility(int fragility) {
        this.fragility = fragility;
    }
}
