package structural_patterns;

/**
 * Created by alt-hanny on 14.08.2016.
 */
public class ArenaFacad {
    ArenaLights arenaLights;
    SelectionCharacters selectionCharacters;

    public ArenaFacad(ArenaLights arenaLights, SelectionCharacters selectionCharacters) {
        this.arenaLights = arenaLights;
        this.selectionCharacters = selectionCharacters;
    }

    public void startFight(){
        arenaLights.turnOnLights();
        selectionCharacters.charSelection();

    }

    public void endFight() {
        arenaLights.turnOffLights();
    }
}
