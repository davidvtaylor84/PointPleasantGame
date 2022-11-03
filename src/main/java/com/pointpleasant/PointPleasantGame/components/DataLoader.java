package com.pointpleasant.PointPleasantGame.components;

import com.pointpleasant.PointPleasantGame.game.Game;
import com.pointpleasant.PointPleasantGame.models.Player;
import com.pointpleasant.PointPleasantGame.models.enemies.*;
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

        HealthBooster energyBar = new HealthBooster("Energy Bar+", "Mick's energy. Makes one feel godlike(or so goes the packaging blurb). Increases health by 10points", false, player, 15);
        itemRepository.save(energyBar);

        HealthBooster energyBar2 = new HealthBooster("Mediocre Energy Bar", "Mick's energy. Makes one feel godlike(or so goes the packaging blurb). Increases health by 10points", false, player, 5);
        itemRepository.save(energyBar2);

        HealthBooster energyBar3 = new HealthBooster("Average Energy Bar", "Mick's energy. Makes one feel godlike(or so goes the packaging blurb). Increases health by 10points", false, player, 10);
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

        Weirdo vadig = new Weirdo("Vadig", "A short man with thyroid eyes. Talks in a high-pitched sing-song voice", 14, 7, 8, 4, 0);
        enemyRepository.save(vadig);

        Weirdo smith = new Weirdo("Indrid", "Apparently human man with dark complexion. Grins constantly", 16, 8,9, 3, 0 );
        enemyRepository.save(smith);

        Weirdo phyllis = new Weirdo("Smith", "A very tall, blonde woman. Extraordinarily long fingers. Stares blankly", 15, 7, 9, 3, 0);
        enemyRepository.save(phyllis);

        GaseousBlob hank = new GaseousBlob("Hank", "Pink gaseous blob. Noxious smelling", 30, 13, 2, 4);
        enemyRepository.save(hank);

        GreyAlien x42 = new GreyAlien("x42", "Grey alien with dented forehead as if having recently been in an accident", 9, 12, 13, "Lanulos", 4);
        enemyRepository.save(x42);

        GreyAlien x47 = new GreyAlien("x47", "Grey alien with broken arm as if having recently been in an accident", 9, 12, 13, "Lanulos", 4);
        enemyRepository.save(x47);

        ManInBlack agentK = new ManInBlack("agentK", "Humanoid. Very red lips. Slow deliberate way of talking", 18, 15, 18, "Has no teeth");
        enemyRepository.save(agentK);

        ManInBlack agentJ = new ManInBlack("agentJ", "Humanoid. Very red lips. Slow deliberate way of talking", 18, 15, 18, "Has no teeth");
        enemyRepository.save(agentJ);

        ManInBlack agentF = new ManInBlack("agentF", "Humanoid. Very red lips. Slow deliberate way of talking", 18, 15, 18, "Has no teeth");
        enemyRepository.save(agentF);

        Soldier steve = new Soldier("Steve MacKinnon", "Human", 12, 13, 3, 14, 10);
        enemyRepository.save(steve);

        Soldier john = new Soldier("John Hell", "Human", 12, 13, 3, 14, 10);
        enemyRepository.save(john);

        Soldier general = new Soldier("General Chambers", "Human", 20, 13, 3, 8, 10);
        enemyRepository.save(general);

        MothMan mothman = new MothMan("Phone", "Mothman", 40, 15, 12, "There are Christmas presents in the water beneath the bridge", "Don't lie down on your search for the factory", "We do not look like how you are seeing us.");
        enemyRepository.save(mothman);











//        GreyAlien bob = new GreyAlien("Steve", "Fine Gray", 20, 12, 7, "Spain", 8);
//        enemyRepository.save(bob);






    }
}
