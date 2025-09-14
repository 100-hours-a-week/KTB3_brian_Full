package week1;

public class ThunderWarrior extends Warrior {

    private final static int THUNDER_WARRIOR_HEALTH = 150;
    private final static int THUNDER_WARRIOR_ATTACK_MIN = 50;
    private final static int THUNDER_WARRIOR_ATTACK_MAX = 70;

    public ThunderWarrior(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(THUNDER_WARRIOR_ATTACK_MIN, THUNDER_WARRIOR_ATTACK_MAX);
    }
}
