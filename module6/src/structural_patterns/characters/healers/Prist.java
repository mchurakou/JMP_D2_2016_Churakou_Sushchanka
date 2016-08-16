package structural_patterns.characters.healers;

/**
 * Prist healer.
 *
 * Created by alt-hanny on 14.08.2016.
 */
public class Prist extends Healer {
    /** Prist's team heal. */
    @Override
    public void heal() {
        System.out.println("Heal the team member.");
    }
}
