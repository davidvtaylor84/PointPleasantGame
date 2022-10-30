package com.pointpleasant.PointPleasantGame.models.items;

public abstract class Weapon implements IWeaponDamage, IImplement{

    private String description;
    private int damageValue;

    public Weapon(String description, int damageValue) {
        this.description = description;
        this.damageValue = damageValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int weaponDamage() {
        return damageValue;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

    public void equipItem(){

    }
}
