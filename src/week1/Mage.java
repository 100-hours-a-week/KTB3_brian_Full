package week1;

public class Mage extends Character {

    private final static int MAGE_HEALTH = 150;
    private final static int MAGE_ATTACK_MIN = 30;
    private final static int MAGE_ATTACK_MAX = 60;

    public Mage(Character c) {
        super(c.getName(), MAGE_HEALTH);
    }

    @Override
    public int attack() {
        return rand.nextInt(MAGE_ATTACK_MIN, MAGE_ATTACK_MAX);
    }
}
