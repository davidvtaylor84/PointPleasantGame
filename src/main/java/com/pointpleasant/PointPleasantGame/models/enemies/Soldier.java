package com.pointpleasant.PointPleasantGame.models.enemies;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Soldier extends Enemy implements IEnemyAttack{

    @Column(name = "bullets")
    private int bullets;

    @Column(name = "armour")
    private int armour;



    public Soldier(String name, String race, int healthPoints, int attackPower, int enemyInsight, int bullets, int armour) {
        super(name, race, healthPoints, attackPower, enemyInsight);
        this.bullets = bullets;
        this.armour = armour;
    }

    public Soldier() {
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
