package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Alien Alloy Tube")
public class AlienAlloyTube extends Weapon implements IWeaponDamage{

    @Column(name = "batteryPower")
    private int batteryPower;

    public AlienAlloyTube(String name, String description, int damageValue, boolean equipped, Player player, int batteryPower) {
        super(name, description, damageValue, equipped, player);
        this.batteryPower = batteryPower;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int weaponDamage() {
        return getDamageValue();
    }

    public void activateItem(){
        setEquipped(true);
    }
}