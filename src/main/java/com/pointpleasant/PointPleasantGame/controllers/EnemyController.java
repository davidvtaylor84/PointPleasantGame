package com.pointpleasant.PointPleasantGame.controllers;

import com.pointpleasant.PointPleasantGame.models.enemies.Enemy;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Item;
import com.pointpleasant.PointPleasantGame.repositories.EnemyRepository;
import com.pointpleasant.PointPleasantGame.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EnemyController {

    @Autowired
    EnemyRepository enemyRepository;

    @GetMapping("/enemies")
    public ResponseEntity<List<Enemy>> getEnemies(){
        return new ResponseEntity<>(enemyRepository.findAll(), HttpStatus.OK);
    }

}
