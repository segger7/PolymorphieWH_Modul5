import java.util.concurrent.ThreadLocalRandom;

public class Dwarf extends Character{

    public static final String SPECIALABILITYNAME = "Zwergenkopfnuss";

    public Dwarf(String name) {
        super(name);
        setAttackDamageMin(15);
        setAttackDamageMax(25);
    }

    public boolean activateSpecialAbility() {
        if(super.activateSpecialAbility() && getHealthpoints() < 50) {
            return true;
        } else {
            deactivateSpecialAbility();
            return false;
        }
    }

    @Override
    public void attack(Character gegner) {
        int baseDamage = ThreadLocalRandom.current().nextInt(getAttackDamageMin(), getAttackDamageMax() + 1);
        if(isSpecialAbilityActive()) {
            int chance = ThreadLocalRandom.current().nextInt(10);
            if(chance < 5) {
                baseDamage = baseDamage*2;
            } else {
                baseDamage = baseDamage/2;
            }
        }
        gegner.takeDamage(baseDamage);
    }
}
