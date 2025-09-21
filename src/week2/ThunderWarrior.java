package week2;

import static week1.GameConstants.THUNDER_WARRIOR_ATTACK_MAX;
import static week1.GameConstants.THUNDER_WARRIOR_ATTACK_MIN;

public class ThunderWarrior extends Warrior {



    public ThunderWarrior(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(THUNDER_WARRIOR_ATTACK_MIN, THUNDER_WARRIOR_ATTACK_MAX);
    }
}
