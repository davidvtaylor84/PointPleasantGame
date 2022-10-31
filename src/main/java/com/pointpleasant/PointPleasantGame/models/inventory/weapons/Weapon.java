package com.pointpleasant.PointPleasantGame.models.inventory.weapons;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.*;

@MappedSuperclass
@Table(name="weapons")
public abstract class Weapon implements IWeaponDamage {

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

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    Player player;

    public Weapon(String name, String description, int damageValue, boolean equipped, Player player) {
        this.name = name;
        this.description = description;
        this.damageValue = damageValue;
        this.equipped = equipped;
        this.player = player;
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

    public int weaponDamage() {
        return damageValue;
    }

    public void activateItem(){
        this.equipped = true;
    }

    public void setDamageValue(int damageValue) {
        this.damageValue = damageValue;
    }

    public void equipItem(){

    }
}
