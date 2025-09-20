package week1;

import java.util.Random;
import static week1.GameConstants.*;

public class Character {

    public final Random rand = new Random();
    protected String name;
    protected int health;
    protected int xp;

    public Character(String name) {
        this.name = name;
        this.health = BASIC_HEALTH;
        this.xp = 0;
    }

    public Character(String name, int health, int xp) {
        this.name = name;
        this.health = health;
        this.xp = xp;
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

    @Override
    public String toString() {
        return String.format("캐릭터 상태, HP : %d, XP : %d, 직업 : %s", getHealth(), getXp(), getClass().getSimpleName());
    }
}
