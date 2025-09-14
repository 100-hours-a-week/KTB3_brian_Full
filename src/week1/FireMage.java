package week1;

public class FireMage extends Mage {

    private final static int FIRE_MAGE_HEALTH = 100;
    private final static int FIRE_MAGE_ATTACK_MIN = 50;
    private final static int FIRE_MAGE_ATTACK_MAX = 150;

    public FireMage(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(FIRE_MAGE_ATTACK_MIN, FIRE_MAGE_ATTACK_MAX);
    }
}
