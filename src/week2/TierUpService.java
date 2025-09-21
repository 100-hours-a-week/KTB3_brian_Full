package week2;

import java.util.List;
import java.util.Scanner;

public class TierUpService {

    private final List<TierUpgradeStrategy> strategies;
    private final Scanner sc;
    private final FileLogger logger;

    public TierUpService(Scanner sc, FileLogger logger) {
        this.strategies = List.of(
                new CharacterTierUpgradeStrategy(),
                new WarriorTierUpgradeStrategy(),
                new MageTierUpgradeStrategy());
        this.sc = sc;
        this.logger = logger;
    }

    public Character tryTierUp(Character character) {
        for (TierUpgradeStrategy strategy : strategies) {
            if (strategy.supports(character)) {
                Character base = character;
                character = strategy.upgrade(character, sc);
                if (base != character) {
                    logger.log("tier up | from=" + base.getClass().getSimpleName()
                            + " to=" + character.getClass().getSimpleName()
                            + " | name=" + character.getName()
                            + " | xp=" + character.getXp());
                }
            }
        }

        return character;
    }
}
