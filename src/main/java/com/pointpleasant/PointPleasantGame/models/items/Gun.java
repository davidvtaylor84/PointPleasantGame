package com.pointpleasant.PointPleasantGame.models.items;

public class Gun {

    private String typeOfGun;
    private int bullets;

    public Gun(String typeOfGun, int bullets) {
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
