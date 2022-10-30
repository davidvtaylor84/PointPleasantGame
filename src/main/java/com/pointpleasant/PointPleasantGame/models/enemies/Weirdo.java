package com.pointpleasant.PointPleasantGame.models.enemies;

public class Weirdo extends Enemy{

    private int psychicEnergy;
    private int cowardiceCounter;

    public Weirdo(String name, String race, int healthPoints, int attackPower, int enemyInsight, int psychicEnergy, int cowardiceCounter) {
        super(name, race, healthPoints, attackPower, enemyInsight);
        this.psychicEnergy = psychicEnergy;
        this.cowardiceCounter = cowardiceCounter;
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
