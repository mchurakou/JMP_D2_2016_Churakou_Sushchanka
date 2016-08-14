package structural_patterns;

import structural_patterns.characters.healers.Healer;
import structural_patterns.characters.HealerAdapter;
import structural_patterns.characters.fighters.Monk;
import structural_patterns.characters.fighters.Fighter;
import structural_patterns.characters.fighters.Mage;
import structural_patterns.characters.fighters.Warrior;
import structural_patterns.characters.healers.SimpleHealer;
import structural_patterns.characters.races.Human;
import structural_patterns.characters.races.Race;

/**
 * Created by alt-hanny on 14.08.2016.
 */
public class Runner {
    public static void main(String arg[]) {
        ArenaFacad arenaFacad = new ArenaFacad(new ArenaLights(), new SelectionCharacters());
        arenaFacad.startFight();
        arenaFacad.endFight();
    }
}
