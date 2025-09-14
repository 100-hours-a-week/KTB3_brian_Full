package week1;

public class DragonWarrior extends Warrior {

    private final static int DRAGON_WARRIOR_HEALTH = 150;
    private final static int DRAGON_WARRIOR_ATTACK_MIN = 50;
    private final static int DRAGON_WARRIOR_ATTACK_MAX = 70;

    public DragonWarrior(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(DRAGON_WARRIOR_ATTACK_MIN, DRAGON_WARRIOR_ATTACK_MAX);
    }
}
