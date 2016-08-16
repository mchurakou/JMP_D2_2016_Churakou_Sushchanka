package structural_patterns.characters;

import structural_patterns.characters.fighters.Fighter;
import structural_patterns.characters.healers.Healer;
import structural_patterns.characters.races.Race;

/**
 * Adapts healers to fighters.
 *
 * Created by alt-hanny on 14.08.2016.
 */
public class HealerAdapter extends Fighter {
    /** Variable for the healers. */
    private Healer healer;
    /** Variable for the healer's race*/
    private Race race;

    /**
     * Constructor with parameters.
     * @param healer Healer's class.
     * @param race Healer's race.
     */
    public HealerAdapter(Healer healer, Race race) {
        this.healer = healer;
        this.race = race;
    }

    /** Adapts heal skill to fight skill. */
    @Override
    public void autofight() {
        healer.heal();
    }
}
