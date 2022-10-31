package com.pointpleasant.PointPleasantGame.models.inventory.items;

public abstract class Item implements IActivateItem {

    private String name;

    private String description;

    private boolean equipped;

    public Item(String name, String description, boolean equipped) {
        this.name = name;
        this.description = description;
        this.equipped = equipped;
    }

    public void activateItem(){
        this.equipped = true;
    }
}
