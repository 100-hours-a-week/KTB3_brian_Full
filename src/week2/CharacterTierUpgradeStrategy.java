package week2;

import java.util.Scanner;

public class CharacterTierUpgradeStrategy implements TierUpgradeStrategy {

    @Override
    public boolean supports(Character character) {
        return character.getClass() == Character.class && character.getXp() >= GameConstants.FIRST_TIER_UP_XP;
    }

    @Override
    public Character upgrade(Character character, Scanner sc) {
        System.out.println("=== 1차 전직 가능 ===");
        while (true) {
            System.out.print("전직 선택: (1) : Warrior (2) : Mage => ");
            String pick = sc.nextLine().trim();

            switch (pick) {
                case "1":
                    return new Warrior(character.getName(), GameConstants.WARRIOR_HEALTH, character.getXp());
                case "2":
                    return new Mage(character.getName(), GameConstants.MAGE_HEALTH, character.getXp());
                default:
                    System.out.println("잘못된 입력입니다. (1) 또는 (2)만 입력해주세요.");
            }
        }
    }
}
