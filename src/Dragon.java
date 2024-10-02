import java.util.concurrent.ThreadLocalRandom;

public class Dragon extends Character{

    public static final String SPECIALABILITYNAME = "Fliegen";

    public Dragon(String name) {
        super(name);
        setAttackDamageMin(20);
        setAttackDamageMax(25);
    }

    @Override
    public void takeDamage(int healthpoints) {
        if(isSpecialAbilityActive()) {
            healthpoints = healthpoints - ThreadLocalRandom.current().nextInt(5,11);
        }
        super.takeDamage(healthpoints);
    }

    public boolean activateSpecialAbility() {
        if(super.activateSpecialAbility()) {
            setHealthpoints(getHealthpoints()+10);
            return true;
        } else {
            return false;
        }
    }

    public boolean deactivateSpecialAbility() {
        if(super.deactivateSpecialAbility()) {
            setHealthpoints(getHealthpoints()-10);
            return true;
        } else {
            return false;
        }
    }
}
