package week2;

import static week1.GameConstants.ICE_MAGE_ATTACK_MAX;
import static week1.GameConstants.ICE_MAGE_ATTACK_MIN;

public class IceMage extends Mage {

    public IceMage(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(ICE_MAGE_ATTACK_MIN, ICE_MAGE_ATTACK_MAX);
    }
}
