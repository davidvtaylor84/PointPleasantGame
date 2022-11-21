package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.*;

@Entity
@Table(name = "weapons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;

    @Column(name="damageValue")
    private int damageValue;

    @Column(name = "equipped")
    private boolean equipped;

    @Column(name = "ammo")
    private int ammo;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    public Weapon(String name, String description, int damageValue, boolean equipped, int ammo, Player player) {
        this.name = name;
        this.description = description;
        this.damageValue = damageValue;
        this.equipped = equipped;
        this.ammo = ammo;
        this.player = player;
    }

    public Weapon(){}

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

    public void activateItem(){
        setEquipped(true);
    }


}
