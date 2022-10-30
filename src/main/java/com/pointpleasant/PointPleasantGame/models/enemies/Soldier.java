package com.pointpleasant.PointPleasantGame.models.enemies;

public class Soldier extends Enemy{

    private int bullets;
    private int armour;

    public Soldier(String name, String race, int healthPoints, int attackPower, int enemyInsight, int bullets, int armour) {
        super(name, race, healthPoints, attackPower, enemyInsight);
        this.bullets = bullets;
        this.armour = armour;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }
}
