package week1;

public class Mage extends Character {

    private final static int MAGE_HEALTH = 150;
    private final static int MAGE_ATTACK_MIN = 30;
    private final static int MAGE_ATTACK_MAX = 60;

    public Mage(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(MAGE_ATTACK_MIN, MAGE_ATTACK_MAX);
    }
}
