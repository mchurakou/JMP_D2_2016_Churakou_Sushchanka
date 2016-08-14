package structural_patterns.characters;

import structural_patterns.characters.fighters.Fighter;
import structural_patterns.characters.healers.Healer;
import structural_patterns.characters.races.Race;

/**
 * Created by alt-hanny on 14.08.2016.
 */
public class HealerAdapter extends Fighter {
    private Healer healer;
    private Race race;

    public HealerAdapter(Healer healer, Race race) {
        this.healer = healer;
        this.race = race;
    }

    @Override
    public void autofight() {
        healer.heal();
    }
}
