package structural_patterns.characters.fighters;

import structural_patterns.characters.FighterDecorator;
import structural_patterns.characters.races.Race;

/**
 * Created by alt-hanny on 14.08.2016.
 */
public class Warrior extends FighterDecorator {
    private Race race;
    public Warrior(Fighter fighter, Race race) {
        super(fighter, race);
        this.race = race;
    }

    public void fight() {
        System.out.println("Warrior in action.");
        fighter.autofight();
        weaponfight();

    }

    private void weaponfight() {
        System.out.println("Weapon in action");
        race.useRace();
    }
}
