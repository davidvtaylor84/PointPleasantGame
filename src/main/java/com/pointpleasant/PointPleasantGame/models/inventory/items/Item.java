package com.pointpleasant.PointPleasantGame.models.inventory.items;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "equipped")
    private boolean equipped;

    @Column(name ="restoration")
    private int restoration;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    public Item(String name, String description, boolean equipped, int restoration, Player player) {
        this.name = name;
        this.description = description;
        this.equipped = equipped;
        this.restoration = restoration;
        this.player = player;
    }

    public Item(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void activateItem(){
        setEquipped(true);
    }

    public int getRestoration() {
        return restoration;
    }

    public void setRestoration(int restoration) {
        this.restoration = restoration;
    }
}
