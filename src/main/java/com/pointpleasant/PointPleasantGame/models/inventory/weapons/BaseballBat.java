package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.*;

@Entity
@Table(name = "baseball bat")
public class BaseballBat extends Weapon implements IWeaponDamage{

    @Column(name = "fragility")
    private int fragility;

    public BaseballBat(String name, String description, int damageValue, boolean equipped, Player player, int fragility) {
        super(name, description, damageValue, equipped, player);
        this.fragility = fragility;
    }

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
