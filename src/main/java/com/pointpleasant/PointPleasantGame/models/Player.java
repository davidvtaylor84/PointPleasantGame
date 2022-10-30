package com.pointpleasant.PointPleasantGame.models;

import com.pointpleasant.PointPleasantGame.models.inventory.IImplement;
import com.pointpleasant.PointPleasantGame.models.inventory.weapons.IWeaponDamage;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    String name;

    @Column(name = "healthPoints")
    Integer healthPoints;
    @Column(name="insight")
    Integer insight;

    @Column(name= "defence")
    Integer defence;

    @Column(name = "intelligence")
    Integer intelligence;

    @Column(name = "inspiration")
    Integer inspiration;

    @Column(name = "gameProgress")
    Integer gameProgress;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    ArrayList<IImplement> items;

    @OneToMany(mappedBy = "weapon", fetch = FetchType.LAZY)
    ArrayList<IWeaponDamage> weapons;

    public Player(String name, Integer healthPoints, Integer insight, Integer defence, Integer intelligence, Integer inspiration, Integer gameProgress) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.insight = insight;
        this.defence = defence;
        this.intelligence = intelligence;
        this.inspiration = inspiration;
        this.gameProgress = gameProgress;
        this.items = new ArrayList<>();
        this.weapons = new ArrayList<>();
    }

    public Player(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getInsight() {
        return insight;
    }

    public void setInsight(Integer insight) {
        this.insight = insight;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getInspiration() {
        return inspiration;
    }

    public void setInspiration(Integer inspiration) {
        this.inspiration = inspiration;
    }

    public Integer getGameProgress() {
        return gameProgress;
    }

    public void setGameProgress(Integer gameProgress) {
        this.gameProgress = gameProgress;
    }

    public ArrayList<IImplement> getItems() {
        return items;
    }

    public void setItems(ArrayList<IImplement> items) {
        this.items = items;
    }

    public ArrayList<IWeaponDamage> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<IWeaponDamage> weapons) {
        this.weapons = weapons;
    }

    public void takeDamage(int damage){
        this.healthPoints -= damage;
        if(this.healthPoints < 1){
            System.out.println(this.name+ " no longer answers to their name.");
        }
    }
}
