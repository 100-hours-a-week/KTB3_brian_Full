package week2;

import static week1.GameConstants.WARRIOR_ATTACK_MAX;
import static week1.GameConstants.WARRIOR_ATTACK_MIN;

public class Warrior extends Character {

    public Warrior(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(WARRIOR_ATTACK_MIN, WARRIOR_ATTACK_MAX);
    }
}
