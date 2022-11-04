package com.pointpleasant.PointPleasantGame.models.enemies;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ManInBlack extends Enemy implements IEnemyAttack{

    @Column(name ="oddnessQuality")
    private String OddnessQuality;

    public ManInBlack(String name, String race, int healthPoints, int attackPower, int defence, String oddnessQuality) {
        super(name, race, healthPoints, attackPower, defence);
        OddnessQuality = oddnessQuality;
    }

    public ManInBlack(){}

    public String getOddnessQuality() {
        return OddnessQuality;
    }

    public void setOddnessQuality(String oddnessQuality) {
        OddnessQuality = oddnessQuality;
    }
}
