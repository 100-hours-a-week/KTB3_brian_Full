package week1;

import static week1.GameConfig.*;

public class DragonWarrior extends Warrior {

    public DragonWarrior(String name, int health, int xp) {
        super(name, health, xp);
    }

    @Override
    public int attack() {
        return rand.nextInt(DRAGON_WARRIOR_ATTACK_MIN, DRAGON_WARRIOR_ATTACK_MAX);
    }
}
