package structural_patterns.characters.fighters;

import structural_patterns.characters.FighterDecorator;
import structural_patterns.characters.races.Race;

/**
 * Created by alt-hanny on 14.08.2016.
 */
public class Mage extends FighterDecorator {
    protected Race race;
    public Mage(Fighter fighter, Race race) {
        super(fighter, race);
        this.race = race;
    }

    public void fight() {
        System.out.println("Mage fighter");
        fighter.autofight();
        fightMagic();
    }

    private void fightMagic() {
        System.out.println("Magic in action.");
        race.useRace();
    }
}
