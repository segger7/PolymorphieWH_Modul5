import java.util.concurrent.ThreadLocalRandom;

public abstract class Character {

    private String name;
    private int healthpoints;
    private boolean specialAbilityActive;
    private int attackDamageMin;
    private int attackDamageMax;

    public Character(String name) {
        this.name = name;
        setHealthpoints(100);
        setSpecialAbilityActive(false);
        setAttackDamageMin(10);
        setAttackDamageMax(20);
    }

    public String getName() {
        return name;
    }

    public int getHealthpoints() {
        return healthpoints;
    }

    public int getAttackDamageMin() {
        return attackDamageMin;
    }

    public int getAttackDamageMax() {
        return attackDamageMax;
    }

    public boolean isSpecialAbilityActive() {
        return specialAbilityActive;
    }

    public void setHealthpoints(int healthpoints) {
        this.healthpoints = healthpoints;
    }

    private void setSpecialAbilityActive(boolean specialAbilityActive) {
        this.specialAbilityActive = specialAbilityActive;
    }

    public void setAttackDamageMin(int attackDamageMin) {
        this.attackDamageMin = attackDamageMin;
    }

    public void setAttackDamageMax(int attackDamageMax) {
        this.attackDamageMax = attackDamageMax;
    }

    public void takeDamage(int punkte) {
        healthpoints = healthpoints - punkte;
    }

    public void attack(Character gegner) {
        int baseDamage = ThreadLocalRandom.current().nextInt(attackDamageMin, attackDamageMax + 1);
        gegner.takeDamage(baseDamage);
    }

    public boolean activateSpecialAbility() {
        if(!isSpecialAbilityActive()) {
            setSpecialAbilityActive(true);
            return true;
        } else {
            return false;
        }
    }

    public boolean deactivateSpecialAbility() {
        if(isSpecialAbilityActive()) {
            setSpecialAbilityActive(false);
            return true;
        } else {
            return false;
        }
    }
}
