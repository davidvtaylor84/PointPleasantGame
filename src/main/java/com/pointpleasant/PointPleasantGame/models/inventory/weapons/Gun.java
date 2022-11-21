package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.*;

@Entity
public class Gun extends Weapon implements IWeaponDamage{

    @Column(name = "typeOfGun")
    private String typeOfGun;

    @Column(name = "bullets")
    private int bullets;

    public Gun(String name, String description, int damageValue, boolean equipped, int ammo, Player player, String typeOfGun, int bullets) {
        super(name, description, damageValue, equipped, ammo, player);
        this.typeOfGun = typeOfGun;
        this.bullets = bullets;
    }

    public Gun(){}

    public String getTypeOfGun() {
        return typeOfGun;
    }

    public void setTypeOfGun(String typeOfGun) {
        this.typeOfGun = typeOfGun;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public int weaponDamage() {
        return getDamageValue();
    }

    public void activateItem(){
        setEquipped(true);
    }
}
