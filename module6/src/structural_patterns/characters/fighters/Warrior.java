package structural_patterns.characters.fighters;

import structural_patterns.characters.FighterDecorator;
import structural_patterns.characters.races.Race;

/**
 * Warrior fighter.
 *
 * Created by alt-hanny on 14.08.2016.
 */
public class Warrior extends FighterDecorator {
    /** Warrior's race. */
    private Race race;

    /**
     * Constructor with parameters.
     * @param fighter Fighter's class.
     * @param race Fighter's race.
     */
    public Warrior(Fighter fighter, Race race) {
        super(fighter, race);
        this.race = race;
    }

    /** Warrior's attacks. */
    public void fight() {
        System.out.println("Warrior in action.");
        fighter.autofight();
        weaponFight();
    }

    /** Warrior's attack with the weapon. */
    private void weaponFight() {
        System.out.println("Weapon in action");
        race.useRace(); //Test the used race.
    }
}
