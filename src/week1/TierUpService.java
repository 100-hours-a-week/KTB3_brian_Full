package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TierUpService {

    private final List<TierUpgradeStrategy> strategies;
    private final Scanner sc;

    public TierUpService(Scanner sc) {
        this.strategies = List.of(
                new CharacterTierUpgradeStrategy(),
                new WarriorTierUpgradeStrategy(),
                new MageTierUpgradeStrategy());
        this.sc = sc;
    }

    public Character tryTierUp(Character character) {
        for (TierUpgradeStrategy strategy : strategies) {
            if (strategy.supports(character)) {
                return strategy.upgrade(character, sc);
            }
        }

        return character;
    }
}
