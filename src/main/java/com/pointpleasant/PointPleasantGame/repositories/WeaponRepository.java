package com.pointpleasant.PointPleasantGame.repositories;

import com.pointpleasant.PointPleasantGame.models.inventory.weapons.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
