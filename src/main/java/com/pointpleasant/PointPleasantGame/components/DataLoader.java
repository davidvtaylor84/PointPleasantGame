package com.pointpleasant.PointPleasantGame.components;

import com.pointpleasant.PointPleasantGame.game.Game;
import com.pointpleasant.PointPleasantGame.models.Player;
import com.pointpleasant.PointPleasantGame.models.enemies.GreyAlien;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Disguise;
import com.pointpleasant.PointPleasantGame.models.inventory.items.HealthBooster;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Key;
import com.pointpleasant.PointPleasantGame.models.inventory.items.Torch;
import com.pointpleasant.PointPleasantGame.models.inventory.weapons.AlienAlloyTube;
import com.pointpleasant.PointPleasantGame.models.inventory.weapons.BaseballBat;
import com.pointpleasant.PointPleasantGame.models.inventory.weapons.Gun;
import com.pointpleasant.PointPleasantGame.repositories.EnemyRepository;
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

    @Autowired
    EnemyRepository enemyRepository;

    public DataLoader(){}



    public void run(ApplicationArguments args) {


        Player player = new Player("John Leek", 30, 0, 20, 70, 5, 70, 1);
        playerRepository.save(player);

        Disguise disguise = new Disguise("Army Uniform", "An army uniform, slightly worn, found in a locker.", false, player, 10);
        itemRepository.save(disguise);

        HealthBooster energyBar = new HealthBooster("Energy Bar", "Mick's energy. Makes one feel godlike(or so goes the packaging blurb). Increases health by 10points", false, player, 10);
        itemRepository.save(energyBar);

        HealthBooster energyBar2 = new HealthBooster("Energy Bar", "Mick's energy. Makes one feel godlike(or so goes the packaging blurb). Increases health by 10points", false, player, 10);
        itemRepository.save(energyBar2);

        HealthBooster energyBar3 = new HealthBooster("Energy Bar", "Mick's energy. Makes one feel godlike(or so goes the packaging blurb). Increases health by 10points", false, player, 10);
        itemRepository.save(energyBar3);

        Key key1 = new Key("Rusted Key", "Found on the body of a dead guy. Heart sticker on the fob.", false, player, "Unused");
        itemRepository.save(key1);

        Key key2 = new Key("Keycard", "Given to you by Mary Hyre. Claims it opens a secret door on the outskirts of town", false, player, "Unused");
        itemRepository.save(key2);
        Key key3 = new Key("Ammonite", "Ammonite whorl. Suspect it is used as a key", false, player, "Unused");
        itemRepository.save(key3);
        Torch torch = new Torch("Windup Torch", "Windup torch. Popular amongst children", false, player, 20);
        itemRepository.save(torch);

        AlienAlloyTube alienAlloyTube = new AlienAlloyTube("Alloy Tube", "Non-descript polished alloy tube. Intention makes it fire an invisible paralysing beam", 20, false, player, 78);
        weaponRepository.save(alienAlloyTube);

        BaseballBat baseballBat = new BaseballBat("Baseball Bat", "A crude weapon for meatheads", 9, false, player, 150);
        weaponRepository.save(baseballBat);

        Gun pistol = new Gun("Colt revolver", "A greasy gun found in a locker", 15, false, player, "Colt revolver", 20);
        weaponRepository.save(pistol);

        Gun m16 = new Gun("M16", "US Army standard issue (for imperialists)", 25, false, player, "M16", 50);
        weaponRepository.save(m16);

        GreyAlien bob = new GreyAlien("Steve", "Fine Gray", 20, 12, 7, "Spain", 8);
        enemyRepository.save(bob);






    }
}
