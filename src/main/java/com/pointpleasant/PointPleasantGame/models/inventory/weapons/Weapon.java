package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

import com.pointpleasant.PointPleasantGame.models.inventory.IImplement;
import com.pointpleasant.PointPleasantGame.models.inventory.weapons.IWeaponDamage;

public abstract class Weapon implements IWeaponDamage, IImplement {

    private String description;
    private int damageValue;

    private boolean equipped;

    public Weapon(String description, int damageValue, boolean equipped) {
        this.description = description;
        this.damageValue = damageValue;
        this.equipped = equipped;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
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
