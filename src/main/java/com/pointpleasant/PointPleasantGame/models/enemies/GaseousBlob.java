package com.pointpleasant.PointPleasantGame.models.enemies;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class GaseousBlob extends Enemy implements IEnemyAttack{

    @Column(name = "stinkrating")
    private int stinkRating;

    public GaseousBlob(String name, String race, int healthPoints, int attackPower, int defence, int stinkRating) {
        super(name, race, healthPoints, attackPower, defence);
        this.stinkRating = stinkRating;
    }

    public GaseousBlob(){};

    public int getStinkRating() {
        return stinkRating;
    }

    public void setStinkRating(int stinkRating) {
        this.stinkRating = stinkRating;
    }
}
