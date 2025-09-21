package week2;

import java.util.Scanner;

public class WarriorTierUpgradeStrategy implements TierUpgradeStrategy {

    @Override
    public boolean supports(Character character) {
        return character.getClass() == Warrior.class && character.getXp() >= GameConstants.SECOND_TIER_UP_XP;
    }

    @Override
    public Character upgrade(Character character, Scanner sc) {
        System.out.println("=== 2차 전직 가능 ===");
        while (true) {
            System.out.print("전사 계열: (1) ThunderWarrior (2) DragonWarrior => ");
            String pick = sc.nextLine().trim();

            switch (pick) {
                case "1":
                    return new ThunderWarrior(character.getName(), GameConstants.THUNDER_WARRIOR_HEALTH, character.getXp());
                case "2":
                    return new DragonWarrior(character.getName(), GameConstants.DRAGON_WARRIOR_HEALTH, character.getXp());
                default:
                    System.out.println("잘못된 입력입니다. (1) 또는 (2)만 입력해주세요.");
            }
        }
    }
}
