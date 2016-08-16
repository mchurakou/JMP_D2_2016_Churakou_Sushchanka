package structural_patterns;

/**
 * Simple application. The use of structural patterns: Adapter, Bridge, Decorator, Facade.
 *
 * Created by alt-hanny on 14.08.2016.
 */
public class Runner {
    public static void main(String arg[]) {
        ArenaFacade arenaFacade = new ArenaFacade(new ArenaLights(), new CreationCharacters());
        arenaFacade.startScene();
        arenaFacade.endScene();
    }
}
