package com.pointpleasant.PointPleasantGame.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Item;
import com.pointpleasant.PointPleasantGame.models.inventory.weapons.Weapon;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "healthPoints")
    private Integer healthPoints;
    @Column(name="insight")
    private Integer insight;

    @Column(name= "defence")
    private Integer defence;

    @Column(name = "intelligence")
    private Integer intelligence;

    @Column(name = "inspiration")
    private Integer inspiration;

    @Column(name ="cash")
    private Integer cash;

    @Column(name = "gameProgress")
    private Integer gameProgress;

    @JsonIgnoreProperties("player")
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Item> items;

    @JsonIgnoreProperties("player")
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Weapon> weapons;

    public Player(String name, Integer healthPoints, Integer insight, Integer defence, Integer intelligence, Integer inspiration, Integer cash, Integer gameProgress)  {
        this.name = name;
        this.healthPoints = healthPoints;
        this.insight = insight;
        this.defence = defence;
        this.intelligence = intelligence;
        this.inspiration = inspiration;
        this.cash = cash;
        this.gameProgress = gameProgress;
        this.items = new ArrayList<>();
        this.weapons =new ArrayList<>();
    }

    public void addWeapon(Weapon weapon){
        this.weapons.add(weapon);
    }
    public void addItem(Item item){
        item.setPlayer(this);
        this.items.add(item);
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
        this.insight += insight;
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Integer getCash() {
        return cash;
    }

    public void setCash(Integer cash) {
        this.cash = cash;
    }

    public Integer takeDamage(int damage){
         this.healthPoints -= damage;
        return healthPoints;
    }

//    public void setWeaponToEquipped(int index){
//        this.weapons.get(index).setEquipped(true);
//    }

//    public void setItemToEquipped(int index){
//        this.items.get(index).setEquipped(true);
//    }
//
    public void setItemToEquipped(String itemName){
        for(Item item : items){
            if (item.getName().equals(itemName)){
                item.setEquipped(true);
            }
        }
    }

    public void setWeaponToEquipped(String weaponName){
        for(Weapon weapon : weapons){
            if (weapon.getName().equals(weaponName)){
                weapon.setEquipped(true);
            }
        }
    }

    public Item getItemByName(String itemName){
        for(Item item : items){
            if (item.getName().equals(itemName)){
                return item;
            }
        }
        return null;
    }

    public Weapon getWeaponByName(String weaponName){
        for(Weapon weapon : weapons){
            if (weapon.getName().equals(weaponName)){
                return weapon;
            }
        }
        return null;
    }





}
