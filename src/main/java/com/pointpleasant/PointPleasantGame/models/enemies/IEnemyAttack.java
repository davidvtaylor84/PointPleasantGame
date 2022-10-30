package com.pointpleasant.PointPleasantGame.models.enemies;

import com.pointpleasant.PointPleasantGame.models.Player;

public interface IEnemyAttack {

    void enemyAttack(Player player);

    void takeDamage(int Damage);

    int diceRoll();

}
