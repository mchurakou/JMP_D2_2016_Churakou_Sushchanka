package structural_patterns.characters.fighters;

import structural_patterns.characters.races.Race;

/**
 * Monk fighter.
 *
 * Created by alt-hanny on 14.08.2016.
 */
public class Monk extends Fighter {
    /** Monk's race. */
    protected Race race;

    /**
     * Constructor.
     */
    public Monk() {
        race = null;
    }

    /** Monk's autofight. */
    @Override
    public void autofight() {
        System.out.println("Hand fight in action.");
    }
}
