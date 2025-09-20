package week1;

import static week1.GameConstants.*;

public class FireMage extends Mage {

    public FireMage(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(FIRE_MAGE_ATTACK_MIN, FIRE_MAGE_ATTACK_MAX);
    }
}
