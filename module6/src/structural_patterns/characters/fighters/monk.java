package structural_patterns.characters.fighters;

import structural_patterns.characters.races.Race;

/**
 * Created by alt-hanny on 14.08.2016.
 */
public class Monk extends Fighter {
    protected Race race;

    public Monk() {
        race = null;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public void autofight() {
        System.out.println("Hand fight in action.");
    }
}
