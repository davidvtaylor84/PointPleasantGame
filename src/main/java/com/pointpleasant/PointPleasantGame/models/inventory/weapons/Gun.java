package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

public class Gun extends Weapon {

    private String typeOfGun;
    private int bullets;

    public Gun(String description, int damageValue, boolean equipped, String typeOfGun, int bullets) {
        super(description, damageValue, equipped);
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
