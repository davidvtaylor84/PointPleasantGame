package com.pointpleasant.PointPleasantGame.models.inventory.items;

public class Key extends Item {


    private String used;

    public Key(String name, String description, boolean equipped, String used) {
        super(name, description, equipped);
        this.used = used;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }
}
