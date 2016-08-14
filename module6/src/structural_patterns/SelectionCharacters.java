package structural_patterns;

import structural_patterns.characters.HealerAdapter;
import structural_patterns.characters.fighters.Fighter;
import structural_patterns.characters.fighters.Mage;
import structural_patterns.characters.fighters.Monk;
import structural_patterns.characters.fighters.Warrior;
import structural_patterns.characters.healers.Healer;
import structural_patterns.characters.healers.SimpleHealer;
import structural_patterns.characters.races.Human;
import structural_patterns.characters.races.Race;

/**
 * Created by alt-hanny on 14.08.2016.
 */
public class SelectionCharacters {
    private Race race;

    public void charSelection() {
        race = new Human();
        fighterSelection(race);
    }

    public void fighterSelection(Race race) {
        Fighter fighter = new Monk();
        Mage mage = new Mage(fighter, race);
        mage.fight();
        Warrior warrior = new Warrior(fighter, race);
        warrior.fight();
        Healer healer = new SimpleHealer();
        Fighter healerAdapter = new HealerAdapter(healer, race);
        healerAdapter.autofight();
    }
}
