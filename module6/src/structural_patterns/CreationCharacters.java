package structural_patterns;

import structural_patterns.characters.HealerAdapter;
import structural_patterns.characters.fighters.Fighter;
import structural_patterns.characters.fighters.Mage;
import structural_patterns.characters.fighters.Monk;
import structural_patterns.characters.fighters.Warrior;
import structural_patterns.characters.healers.Healer;
import structural_patterns.characters.healers.Prist;
import structural_patterns.characters.races.Elf;
import structural_patterns.characters.races.Human;
import structural_patterns.characters.races.Race;

import java.util.Scanner;

/**
 * Created by alt-hanny on 14.08.2016.
 */
public class CreationCharacters {
    /** Variable for the race of char. */
    private Race race;
    /** Variable for the class of char. */
    private Fighter fighter;

    /** Char selection.*/
    public void charCreation() {
        boolean userChooseDone;
        try (Scanner sc = new Scanner(System.in)){
            System.out.println("Please, choose the race of the character: \n 1 - Human; \n 2 - Elf;");
            do{
                String selection = sc.nextLine();
                switch (selection) {
                    case "1":
                        race = new Human();
                        userChooseDone = Boolean.TRUE;
                        break;
                    case "2":
                        race = new Elf();
                        userChooseDone = Boolean.TRUE;
                        break;
                    default:
                        System.out.println("Please, try again.");
                        userChooseDone = Boolean.FALSE;
                }
            } while (!userChooseDone);
        classCreation(race);
        }
    }

    private void classCreation(Race race) {
        boolean userChooseDone;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please, choose the class of the character: \n 1 - Monk; \n 2 - Mage; \n 3 - Warrior; \n 4 - Prist");
            do {
                String selection = sc.nextLine();
                switch (selection) {
                    case "1":
                        fighter = new Monk();
                        userChooseDone = Boolean.TRUE;
                        break;
                    case "2":
                        Mage mage = new Mage(fighter, race);
                        mage.fight();
                        userChooseDone = Boolean.TRUE;
                        break;
                    case "3":
                        fighter = new Monk();
                        Warrior warrior = new Warrior(fighter, race);
                        warrior.fight();
                        userChooseDone = Boolean.TRUE;
                        break;
                    case "4":
                        Healer healer = new Prist();
                        Fighter healerAdapter = new HealerAdapter(healer, race);
                        healerAdapter.autofight();
                        userChooseDone = Boolean.TRUE;
                        break;
                    default:
                        System.out.println("Please, try again.");
                        userChooseDone = Boolean.FALSE;
                }
            } while (!userChooseDone);
        }
    }
}
