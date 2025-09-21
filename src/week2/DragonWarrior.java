package week2;

import static week1.GameConstants.DRAGON_WARRIOR_ATTACK_MAX;
import static week1.GameConstants.DRAGON_WARRIOR_ATTACK_MIN;

public class DragonWarrior extends Warrior {

    public DragonWarrior(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(DRAGON_WARRIOR_ATTACK_MIN, DRAGON_WARRIOR_ATTACK_MAX);
    }
}
