package structural_patterns;

/**
 * Facade for the arena.
 *
 * Created by alt-hanny on 14.08.2016.
 */
public class ArenaFacade {
    /** Variable for the lights control entity. */
    private ArenaLights arenaLights;
    /** Variable for the entity of the selection char. */
    private CreationCharacters creationCharacters;

    /**
     * Facade constructor.
     *
     * @param arenaLights Lights of the arena.
     * @param selectionCharacters Selection chars.
     */
    public ArenaFacade(ArenaLights arenaLights, CreationCharacters selectionCharacters) {
        this.arenaLights = arenaLights;
        this.creationCharacters = selectionCharacters;
    }

    /** Starts of the actions. */
    public void startScene(){
        arenaLights.turnOnLights();
        creationCharacters.charCreation();
    }

    /** End of the actions. */
    public void endScene() {
        arenaLights.turnOffLights();
    }
}
