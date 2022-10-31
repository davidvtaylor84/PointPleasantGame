package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

import com.pointpleasant.PointPleasantGame.models.Player;

public class Gun extends Weapon {

    private String typeOfGun;
    private int bullets;

    public Gun(String name, String description, int damageValue, boolean equipped, Player player, String typeOfGun, int bullets) {
        super(name, description, damageValue, equipped, player);
        this.typeOfGun = typeOfGun;
        this.bullets = bullets;
    }

    public String getTypeOfGun() {
        return typeOfGun;
    }

    public void setTypeOfGun(String typeOfGun) {
        this.typeOfGun = typeOfGun;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }
}
