package com.pointpleasant.PointPleasantGame;

import com.pointpleasant.PointPleasantGame.game.Game;
import com.pointpleasant.PointPleasantGame.repositories.PlayerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PointPleasantGameApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PointPleasantGameApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
		PlayerRepository playerRepository = context.getBean(PlayerRepository.class);
		new Game(playerRepository);
	}

}
