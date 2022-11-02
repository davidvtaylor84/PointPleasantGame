package com.pointpleasant.PointPleasantGame;

import com.pointpleasant.PointPleasantGame.models.Player;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Disguise;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Item;
import com.pointpleasant.PointPleasantGame.repositories.ItemRepository;
import com.pointpleasant.PointPleasantGame.repositories.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PointPleasantGameApplicationTests {

	@Autowired
	PlayerRepository playerRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void canGetPlayerById(){
//		List<Player> foundPlayer = playerRepository.findPlayerById(1L);
//		assertEquals("John Leek", foundPlayer.get(0).getName());
	}

	@Test
	public void canGetHealthPointsByPlayerId(){
		List<Player> foundPlayer = playerRepository.findHealthPointsById(1L);
		assertEquals(30, foundPlayer.get(0).getHealthPoints());
	}

	@Test
	public void canFindPlayerById(){
		List<Player> foundPlayer = playerRepository.findPlayerById(1L);
		assertEquals("John Leek", foundPlayer.get(0).getName());
	}


}
