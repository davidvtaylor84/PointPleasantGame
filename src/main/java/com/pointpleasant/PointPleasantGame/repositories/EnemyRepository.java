package com.pointpleasant.PointPleasantGame.repositories;

import com.pointpleasant.PointPleasantGame.models.enemies.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnemyRepository extends JpaRepository<Enemy, Long> {

    Optional<Enemy> findByName(String name);
}
