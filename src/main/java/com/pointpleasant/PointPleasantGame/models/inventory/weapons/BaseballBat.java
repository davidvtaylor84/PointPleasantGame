package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.*;

@Entity
public class BaseballBat extends Weapon implements IWeaponDamage{

    @Column(name = "fragility")
    private int fragility;

    public BaseballBat(String name, String description, int damageValue, boolean equipped, int ammo, Player player, int fragility) {
        super(name, description, damageValue, equipped, ammo, player);
        this.fragility = fragility;
    }

    public BaseballBat (){}

    public int getFragility() {
        return fragility;
    }

    public void setFragility(int fragility) {
        this.fragility = fragility;
    }
    public int weaponDamage() {
        return getDamageValue();
    }

    public void activateItem(){
        setEquipped(true);
    }
}
