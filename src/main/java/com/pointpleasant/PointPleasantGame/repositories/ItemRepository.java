package com.pointpleasant.PointPleasantGame.repositories;

import com.pointpleasant.PointPleasantGame.models.inventory.items.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
