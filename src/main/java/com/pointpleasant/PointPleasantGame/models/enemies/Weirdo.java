package com.pointpleasant.PointPleasantGame.models.enemies;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Weirdo extends Enemy implements IEnemyAttack{

    @Column(name = "psychicEnergy")
    private int psychicEnergy;
    @Column(name = "cowardiceCounter")
    private int cowardiceCounter;



    public Weirdo(String name, String race, int healthPoints, int attackPower, int defence, int psychicEnergy, int cowardiceCounter) {
        super(name, race, healthPoints, attackPower, defence);
        this.psychicEnergy = psychicEnergy;
        this.cowardiceCounter = cowardiceCounter;
    }

    public Weirdo() {
    }

    public int getPsychicEnergy() {
        return psychicEnergy;
    }

    public void setPsychicEnergy(int psychicEnergy) {
        this.psychicEnergy = psychicEnergy;
    }

    public int getCowardiceCounter() {
        return cowardiceCounter;
    }

    public void setCowardiceCounter(int cowardiceCounter) {
        this.cowardiceCounter = cowardiceCounter;
    }
}
