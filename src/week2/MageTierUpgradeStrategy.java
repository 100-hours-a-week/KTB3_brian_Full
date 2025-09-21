package week2;

import java.util.Scanner;

public class MageTierUpgradeStrategy implements TierUpgradeStrategy {

    @Override
    public boolean supports(Character character) {
        return character.getClass() == Warrior.class && character.getXp() >= GameConstants.SECOND_TIER_UP_XP;
    }

    @Override
    public Character upgrade(Character character, Scanner sc) {
        System.out.println("=== 2차 전직 가능 ===");
        while (true) {
            System.out.print("마법사 계열: (1) FireMage (2) IceMage => ");
            String pick = sc.nextLine().trim();

            switch (pick) {
                case "1":
                    return new FireMage(character.getName(), GameConstants.FIRE_MAGE_HEALTH, character.getXp());
                case "2":
                    return new IceMage(character.getName(), GameConstants.ICE_MAGE_HEALTH, character.getXp());
                default:
                    System.out.println("잘못된 입력입니다. (1) 또는 (2)만 입력해주세요.");
            }
        }
    }
}
