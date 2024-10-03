import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Character dragon = new Dragon("Drago");
        Character zwerg = new Dwarf("Zwerg");
        BattleArena battleArena = new BattleArena(dragon, zwerg);
        battleArena.fight();
    }
}