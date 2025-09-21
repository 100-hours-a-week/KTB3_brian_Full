package week2;

import static week1.GameConstants.FIRE_MAGE_ATTACK_MAX;
import static week1.GameConstants.FIRE_MAGE_ATTACK_MIN;

public class FireMage extends Mage {

    public FireMage(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(FIRE_MAGE_ATTACK_MIN, FIRE_MAGE_ATTACK_MAX);
    }
}
