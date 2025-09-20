package week1;

import static week1.GameConstants.*;

public class ThunderWarrior extends Warrior {



    public ThunderWarrior(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(THUNDER_WARRIOR_ATTACK_MIN, THUNDER_WARRIOR_ATTACK_MAX);
    }
}
