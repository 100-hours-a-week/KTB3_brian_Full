package week1;

public class IceMage extends Mage {

    private final static int ICE_MAGE_HEALTH = 150;
    private final static int ICE_MAGE_ATTACK_MIN = 25;
    private final static int ICE_MAGE_ATTACK_MAX = 100;

    public IceMage(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(ICE_MAGE_ATTACK_MIN, ICE_MAGE_ATTACK_MAX);
    }
}
