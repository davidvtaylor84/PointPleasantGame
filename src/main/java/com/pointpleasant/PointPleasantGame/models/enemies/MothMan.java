package com.pointpleasant.PointPleasantGame.models.enemies;

import com.pointpleasant.PointPleasantGame.models.Player;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
@Entity
public class MothMan extends Enemy  implements IEnemyAttack{

    @Column(name = "prophecy1")
    String prophecy1;
    @Column(name = "prophecy2")
    String prophecy2;

    @Column(name = "prophecy3")
    String prophecy3;

    public MothMan(String name, String race, int healthPoints, int attackPower, int enemyInsight, String prophecy1, String prophecy2, String prophecy3) {
        super(name, race, healthPoints, attackPower, enemyInsight);
        this.prophecy1 = prophecy1;
        this.prophecy2 = prophecy2;
        this.prophecy3 = prophecy3;
    }

    public MothMan(){}

    public void mothmanAttack(Player player){
        Random rand = new Random();
        int upperbound = 10;
        int min = 1;
        int diceRoll = rand.nextInt(upperbound-min)+1;
        if(diceRoll >=7){
            System.out.println(prophecy3);
            this.increaseHealth(20);
            player.takeDamage(50);
        }else{player.takeDamage(this.getAttackPower());}
        System.out.println(diceRoll);
    }



}
