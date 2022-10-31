package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

import com.pointpleasant.PointPleasantGame.models.Player;

public class BaseballBat extends Weapon {

    private int fragility;

    public BaseballBat(String name, String description, int damageValue, boolean equipped, Player player, int fragility) {
        super(name, description, damageValue, equipped, player);
        this.fragility = fragility;
    }

    public int getFragility() {
        return fragility;
    }

    public void setFragility(int fragility) {
        this.fragility = fragility;
    }
}
