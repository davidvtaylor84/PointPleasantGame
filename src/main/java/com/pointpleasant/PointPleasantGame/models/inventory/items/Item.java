package com.pointpleasant.PointPleasantGame.models.inventory.items;

import com.pointpleasant.PointPleasantGame.models.inventory.IImplement;

public abstract class Item implements IImplement {

    private String name;

    private String description;

    private boolean equipped;

    public Item(String name, String description, boolean equipped) {
        this.name = name;
        this.description = description;
        this.equipped = equipped;
    }

    public void equipItem(){

    }
}
