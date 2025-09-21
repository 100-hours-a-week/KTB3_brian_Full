package week2;

import static week1.GameConstants.MAGE_ATTACK_MAX;
import static week1.GameConstants.MAGE_ATTACK_MIN;

public class Mage extends Character {

    public Mage(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(MAGE_ATTACK_MIN, MAGE_ATTACK_MAX);
    }
}
