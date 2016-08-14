package structural_patterns.characters;

import structural_patterns.characters.fighters.Fighter;
import structural_patterns.characters.races.Race;

/**
 * Created by alt-hanny on 14.08.2016.
 */
public class FighterDecorator extends Fighter {
    protected Fighter fighter;
    protected Race race;

    public FighterDecorator(Fighter fighter, Race race) {
        this.fighter = fighter;
    }

    @Override
    public void autofight() {
        fighter.autofight();
        race.useRace();
    }
}
