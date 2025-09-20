package week1;

import static week1.GameConstants.*;

public class Mage extends Character {

    public Mage(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(MAGE_ATTACK_MIN, MAGE_ATTACK_MAX);
    }
}
