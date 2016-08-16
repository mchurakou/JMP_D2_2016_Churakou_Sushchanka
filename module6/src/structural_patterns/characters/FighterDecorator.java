package structural_patterns.characters;

import structural_patterns.characters.fighters.Fighter;
import structural_patterns.characters.races.Race;

/**
 * Decorates of the fighters.
 *
 * Created by alt-hanny on 14.08.2016.
 */
public class FighterDecorator extends Fighter {
    /** Variable for the fighter's class.*/
    protected Fighter fighter;
    /** Variable for the fighter's race.*/
    protected Race race;
    /**
     * Constructor with parameters.
     * @param fighter Fighter's class.
     * @param race Fighter's race.
     */
    public FighterDecorator(Fighter fighter, Race race) {
        this.fighter = fighter;
        this.race = race;
    }
    /** Decorates of the fights skills. */
    @Override
    public void autofight() {
        fighter.autofight();
        race.useRace(); //Test race.
    }
}
