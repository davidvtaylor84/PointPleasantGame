package com.pointpleasant.PointPleasantGame.components;

import com.pointpleasant.PointPleasantGame.models.Player;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Disguise;
import com.pointpleasant.PointPleasantGame.models.inventory.items.HealthBooster;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Key;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Torch;
import com.pointpleasant.PointPleasantGame.models.inventory.weapons.AlienAlloyTube;
import com.pointpleasant.PointPleasantGame.repositories.ItemRepository;
import com.pointpleasant.PointPleasantGame.repositories.PlayerRepository;
import com.pointpleasant.PointPleasantGame.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    WeaponRepository weaponRepository;

    @Autowired
    PlayerRepository playerRepository;

    public DataLoader(){}



    public void run(ApplicationArguments args) {

        Player player = new Player("John Leek", 30, 0, 20, 70, 70, 70, 1);
        playerRepository.save(player);

        Disguise disguise = new Disguise("Army Uniform", "An army uniform, slightly worn, found in a locker.", false, player, 10);

        HealthBooster energyBar = new HealthBooster("Energy Bar", "Mick's energy. Makes one feel godlike(or so goes the packaging blurb). Increases health by 10points", false, player, 10);

        HealthBooster energyBar2 = new HealthBooster("Energy Bar", "Mick's energy. Makes one feel godlike(or so goes the packaging blurb). Increases health by 10points", false, player, 10);

        HealthBooster energyBar3 = new HealthBooster("Energy Bar", "Mick's energy. Makes one feel godlike(or so goes the packaging blurb). Increases health by 10points", false, player, 10);

        Key key1 = new Key("Rusted Key", "Found on the body of a dead guy. Heart sticker on the fob.", false, player, "Unused");

        Key key2 = new Key("Keycard", "Given to you by Mary Hyre. Claims it opens a secret door on the outskirts of town", false, player, "Unused");

        Key key3 = new Key("Ammonite", "Ammonite whorl. Suspect it is used as a key", false, player, "Unused");

        Torch torch = new Torch("Windup Torch", "Windup torch. Popular amongst children", false, player, 20);

        AlienAlloyTube alienAlloyTube = new AlienAlloyTube("")





    }
}
