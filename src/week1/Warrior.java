package week1;

public class Warrior extends Character {

    private final static int WARRIOR_HEALTH = 200;
    private final static int WARRIOR_ATTACK_MIN = 20;
    private final static int WARRIOR_ATTACK_MAX = 40;

    public Warrior(Character c) {
        super(c.getName(), WARRIOR_HEALTH);
    }

    @Override
    public int attack() {
        return rand.nextInt(WARRIOR_ATTACK_MIN, WARRIOR_ATTACK_MAX);
    }
}
