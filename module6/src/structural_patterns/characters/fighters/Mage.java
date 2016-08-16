package structural_patterns.characters.fighters;

import structural_patterns.characters.FighterDecorator;
import structural_patterns.characters.races.Race;

/**
 * Mage fighter.
 *
 * Created by alt-hanny on 14.08.2016.
 */
public class Mage extends FighterDecorator {
    /** Mage's race. */
    protected Race race;

    /**
     * Constructor with parameters.
     * @param fighter Fighter's class.
     * @param race Fighter's race.
     */
    public Mage(Fighter fighter, Race race) {
        super(fighter, race);
        this.race = race;
    }

    /** Mage's attacks. */
    public void fight() {
        System.out.println("Mage fighter");
        fighter.autofight();
        fightMagic();
    }

    /** Attack with magic. */
    private void fightMagic() {
        System.out.println("Magic in action.");
        race.useRace(); //Test used race.
    }
}
