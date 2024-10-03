import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BattleArena {

    private Character player1;
    private Character player2;

    private Character winner;

    private final Scanner scanner;

    public BattleArena(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
        scanner = new Scanner(System.in);
    }

    public void fight() {
        boolean toggle = true;
        Character activeFighter;
        Character passiveFighter;
        if(ThreadLocalRandom.current().nextBoolean()) {
            activeFighter = this.player1;
            passiveFighter = this.player2;
        } else {
            activeFighter = this.player2;
            passiveFighter = this.player1;
        }
        while(toggle) {
            System.out.println("| ================================================================================");
            System.out.println("| SPIELER 1: " + player1);
            System.out.println("| --------------------------------------------------------------------------------");
            System.out.println("| SPIELER 2: " + player2);
            System.out.println("| --------------------------------------------------------------------------------");
            System.out.println("| ");
            System.out.println("| Gerade Spielt: " + activeFighter.getName());
            System.out.println("| (1) Angreifen (2) Spezialfähigkeit aktivieren (3) Spezialfähigkeit deaktivieren");
            System.out.println("| --------------------------------------------------------------------------------");
            switch(scanner.nextLine()) {
                case "1": {
                    simulateFight(activeFighter, passiveFighter);
                    break;
                }

                case "2": {
                    activeFighter.activateSpecialAbility();
                    break;
                }

                case "3": {
                    activeFighter.deactivateSpecialAbility();
                    break;
                }

                default: {
                    System.out.println("Richtigen Wert eingeben!");
                    break;
                }
            }

            Character newActiveFighter = passiveFighter;
            Character newPassiveFighter = activeFighter;
            activeFighter = newActiveFighter;
            passiveFighter = newPassiveFighter;

            if(player1.getHealthpoints() <= 0) {
                toggle = false;
                crownWinner(player2);
            } else if(player2.getHealthpoints() <= 0) {
                toggle = false;
                crownWinner(player1);
            }
        }
    }

    private void simulateFight(Character attacker, Character enemy){
        attacker.attack(enemy);
    }

    private void crownWinner(Character winner) {
        setWinner(winner);
        System.out.println("| -~~--------------------------------------------------------------------------~~-");
        System.out.println("| Der Gewinner ist: " + this.winner.getName());
        System.out.println("| -~~--------------------------------------------------------------------------~~-");
    }

    public Character getPlayer1() {
        return player1;
    }

    private void setPlayer1(Character player1) {
        this.player1 = player1;
    }

    public Character getPlayer2() {
        return player2;
    }

    private void setPlayer2(Character player2) {
        this.player2 = player2;
    }

    public Character getWinner() {
        return winner;
    }

    private void setWinner(Character winner) {
        this.winner = winner;
    }
}
