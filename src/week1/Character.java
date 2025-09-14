package week1;

import java.util.Random;

public class Character {

    private static final int BASIC_HEALTH = 100;
    private static final int BASIC_ATTACK_MIN = 5;
    private static final int BASIC_ATTACK_MAX = 10;

    protected String name;
    protected int health;
    protected int xp;
    private final Random rand = new Random();

    public Character(String name) {
        this.name = name;
        this.health = BASIC_HEALTH;
        this.xp = 0;
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }

    public int getXp() {
        return xp;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void gainXp(int xp) {
        this.xp += xp;
    }

    public int attack() {
        return rand.nextInt(BASIC_ATTACK_MIN, BASIC_ATTACK_MAX);
    }
}
