package com.pointpleasant.PointPleasantGame.models.enemies;

public class ManInBlack extends Enemy{

    private String OddnessQuality;

    public ManInBlack(String name, String race, int healthPoints, int attackPower, int enemyInsight, String oddnessQuality) {
        super(name, race, healthPoints, attackPower, enemyInsight);
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
