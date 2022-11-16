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
import com.pointpleasant.PointPleasantGame.models.inventory.weapons.Weapon;
import com.pointpleasant.PointPleasantGame.repositories.EnemyRepository;
import com.pointpleasant.PointPleasantGame.repositories.ItemRepository;
import com.pointpleasant.PointPleasantGame.repositories.PlayerRepository;
import com.pointpleasant.PointPleasantGame.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Profile("!test")
//@Component
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


        Player player = new Player("John Leek", 30, 0, 14, 7, 5, 70, 0);
        playerRepository.save(player);

        Disguise disguise = new Disguise("Army Uniform", "STANDARD ISSUE UNIFORM \n\nDescription: An army uniform, slightly worn, found in a locker.\n\nCould be used to disguise oneself, but your non-regulation haircut and startled bearing won't fool them for long.\n\nCannot be used here.", false, 0,player, 10);
        itemRepository.save(disguise);

        HealthBooster energyBar = new HealthBooster("Energy Bar+", "BAZLINTON'S ENERGY BAR PLUS.\n\nDescription: Makes one feel godlike(or so goes the packaging blurb).\n\nOne-liner on the wrapper reads: 'I’ve got a friend who has got a butler whose left arm is missing; serves him right'.\n\nHealth increased by 25 points", false, 25,player, 25);
        itemRepository.save(energyBar);

        HealthBooster energyBar2 = new HealthBooster("Mediocre Energy Bar", "INDRID'S ENERGY BAR.\n\nDescription: Keeps death at bay(or so goes the packaging blurb).\n\nOne-liner on the wrapper reads: 'I saw this bloke chatting up a cheetah and I thought 'He’s trying to pull a fast one.'\n\nHealth increased by 15 points", false, 15, player, 15);
        itemRepository.save(energyBar2);

        HealthBooster energyBar3 = new HealthBooster("Average Energy Bar", "CREEPER'S ENERGY BAR.\n\nDescription: Makes your blood fire hot(or so goes the packaging blurb).\n\nOne-liner on the wrapper reads: 'I had a dream last night that I was cutting carrots with the Grim Reaper… dicing with death!\n\nHealth increased by 20 points", false, 20, player, 20);
        itemRepository.save(energyBar3);

        Key key1 = new Key("Rusted Key", "RUSTED KEY\n\nDescription: Small metal key given to you by Vadig. What it opens, god only knows, and I'm guessing god doesn't want to know.\n\nOnly distinguishing feature is a heart-shape on the bow.\n\nCannot be used here", false, 0, player, "Unused");
        itemRepository.save(key1);

        Key key2 = new Key("Keycard", "KEYCARD\n\nDescription: Found in Mary Hyre's safe.\n\nYou hope that this is the item she was protecting and it wasn't some of the jewels, or even the cash. Maybe the aliens need money?!\n\nCannot be used here", false, 0, player, "Unused");
        itemRepository.save(key2);
        Key key3 = new Key("Ammonite", "AMMONITE WHORL\n\nDescription: Weird fossil found in a box behind the Dynamite Diner. It feels heavier than it should.\n\nFossils lie heavy with dream, or so some ostensibly useful idiot once quipped. Use is unknown(for now).\n\nCannot be used here", false, 0,player, "Unused");
        itemRepository.save(key3);
        Torch torch = new Torch("Windup Torch", "WINDUP TORCH\n\nDescription: A mere toy that reminds of a gift you received as a child.\n\nYou chide yourself for being so sentimental, but it's stuff like this that makes us human.\n\nIt's use is obvious", false, 0,player, 20);
        itemRepository.save(torch);

        AlienAlloyTube alienAlloyTube = new AlienAlloyTube("Alloy Tube", "ALLOY TUBE\n\nDescription: Non-descript polished metal tube found on a dead alien. It's use is currently unknown but it'll probably come in useful.\n\nMakes a slight sucking sound.\n\nCannot be used here", 20, false,  player, 78);
        weaponRepository.save(alienAlloyTube);

        BaseballBat baseballBat = new BaseballBat("Baseball Bat", "BASEBALL BAT\n\nDescription: A children's toy. Some advice: 'If you don't think too much, don't think too much'. If that makes sense, maybe this weapon is for you.\n\nAdds +9 damage to successful attack.\n\nCannot be used here", 9, false, player, 150);
        weaponRepository.save(baseballBat);

        Gun pistol = new Gun("Colt revolver", "COLT REVOLVER\n\nDescription: Standard revolver pistol found amidst a pile of bodies.\n\nDon't worry about the number of bullets you have left. Your pockets are stuffed with them.\n\nCannot be used here.", 12, false, player, "Colt revolver", 20);
        weaponRepository.save(pistol);

        Gun m16 = new Gun("M16", "US Army standard issue (for imperialists)", 25, false, player, "M16", 50);
        weaponRepository.save(m16);

        Weirdo vadig = new Weirdo("Vadig", "A short man with thyroid eyes. Talks in a high-pitched sing-song voice", 20, 7, 8, 4, 0);
        enemyRepository.save(vadig);

        Weirdo smith = new Weirdo("Indrid", "Apparently human man with dark complexion. Grins constantly", 16, 8,9, 3, 0 );
        enemyRepository.save(smith);

        Weirdo phyllis = new Weirdo("Smith", "A very tall, blonde woman. Extraordinarily long fingers. Stares blankly", 15, 7, 9, 3, 0);
        enemyRepository.save(phyllis);

        GaseousBlob hank = new GaseousBlob("Hank", "Pink gaseous blob. Noxious smelling", 30, 13, 8, 4);
        enemyRepository.save(hank);

        GreyAlien x42 = new GreyAlien("x42", "Grey alien with dented forehead as if having recently been in an accident", 40, 12, 13, "Lanulos", 4);
        enemyRepository.save(x42);

        GreyAlien x47 = new GreyAlien("x47", "Grey alien with broken arm as if having recently been in an accident", 9, 12, 13, "Lanulos", 4);
        enemyRepository.save(x47);

        ManInBlack agentK = new ManInBlack("agentK", "Humanoid. Very red lips. Slow deliberate way of talking", 30, 15, 12, "Has no teeth");
        enemyRepository.save(agentK);

        ManInBlack agentJ = new ManInBlack("agentJ", "Humanoid. Very red lips. Slow deliberate way of talking", 25, 8, 13, "Has no teeth");
        enemyRepository.save(agentJ);

        ManInBlack agentF = new ManInBlack("agentF", "Humanoid. Very red lips. Slow deliberate way of talking", 18, 15, 18, "Has no teeth");
        enemyRepository.save(agentF);

        Soldier steve = new Soldier("Steve MacKinnon", "Human", 12, 13, 3, 14, 10);
        enemyRepository.save(steve);

        Soldier john = new Soldier("John Hell", "Human", 40, 13, 3, 14, 10);
        enemyRepository.save(john);

        Soldier general = new Soldier("General Chambers", "Human", 20, 13, 3, 8, 10);
        enemyRepository.save(general);

        MothMan mothman = new MothMan("Phone", "Mothman", 40, 15, 12, "There are Christmas presents in the water beneath the bridge", "Don't lie down on your search for the factory", "We do not look like how you are seeing us.");
        enemyRepository.save(mothman);


        Gun pistol1 = new Gun("Colt revolver", "COLT REVOLVER\n\nDescription: Standard revolver pistol found amidst a pile of bodies. Don't worry about the number of bullets you have left. Your pockets are stuffed with them.\n\nCannot be used here.", 12, false, player, "Colt revolver", 20);
        BaseballBat baseballBat1 = new BaseballBat("Baseball Bat", "BASEBALL BAT\n\nDescription: A children's toy. Some advice: 'If you don't think too much, don't think too much'. If that makes sense, maybe this weapon is for you.\n\nAdds +9 damage to successful attack.\n\nCannot be used here", 9, false, player, 150);

        ArrayList<Weapon> weapons = new ArrayList<>();
        weapons.add(pistol1);
        weapons.add(baseballBat1);














//        GreyAlien bob = new GreyAlien("Steve", "Fine Gray", 20, 12, 7, "Spain", 8);
//        enemyRepository.save(bob);






    }
}
