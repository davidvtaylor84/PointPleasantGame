package com.pointpleasant.PointPleasantGame.models.inventory.items;

import com.pointpleasant.PointPleasantGame.models.Player;

import javax.persistence.*;

@MappedSuperclass
@Table(name= "items")
public abstract class Item implements IActivateItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "equipped")
    private boolean equipped;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    Player player;

    public Item(String name, String description, boolean equipped, Player player) {
        this.name = name;
        this.description = description;
        this.equipped = equipped;
        this.player = player;
    }

    public void activateItem(){
        this.equipped = true;
    }
}
