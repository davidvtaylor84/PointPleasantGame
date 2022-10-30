package com.pointpleasant.PointPleasantGame.models.inventory.items;

public class HealthBooster extends Item{

    private int restorativePoints;

    public HealthBooster(String name, String description, boolean equipped, int restorativePoints) {
        super(name, description, equipped);
        this.restorativePoints = restorativePoints;
    }

    public int getRestorativePoints() {
        return restorativePoints;
    }

    public void setRestorativePoints(int restorativePoints) {
        this.restorativePoints = restorativePoints;
    }
}
