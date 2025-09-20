package week1;

import java.util.Random;
import java.util.Scanner;

import static week1.GameConstants.*;

public class GameService {

    private final Random random = new Random();
    private final Scanner sc = new Scanner(System.in);
    private final BattleService battleService = new BattleService(random, sc);

    public void gameStart() {
        System.out.println("게임을 시작합니다.");

        Character player = createCharacter();
        while (!player.isDead()) {
            System.out.println(player);
            player = tryTierUp(player);
            Character enemy = createEnemy();
            battleService.fight(player, enemy);

            if (player.getXp() >= GAME_ENDING_XP) {
                System.out.println("축하드립니다. 게임에서 승리했습니다");
                return;
            }
        }

        gameOver();
    }

    private Character createCharacter() {
        System.out.println("캐릭터를 생성합니다. 캐릭터 이름을 입력하세요");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            name = "player";
        }

        return new Character(name);
    }

    private Character tryTierUp(Character character) {
        boolean isTierBasic = character.getClass() == Character.class;
        boolean isTier1 = (character.getClass() == Warrior.class) || (character.getClass() == Mage.class);

        if (isTier1 && character.getXp() >= GameConstants.SECOND_TIER_UP_XP) {
            System.out.println("=== 2차 전직 가능 ===");

            while (true) {
                if (character instanceof Warrior) {
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
                } else {
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
        }

        if (isTierBasic && character.getXp() >= GameConstants.FIRST_TIER_UP_XP) {
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

        return character;
    }

    private Character createEnemy() {
        String name = "적";
        int health = random.nextInt(1,ENEMY_HEALTH_MAX);
        int xp = random.nextInt(1, ENEMY_XP_MAX);

        return new Character(name, health, xp);
    }

    private void gameOver() {
        System.out.println("체력이 0이 되어 패배했습니다.");

    }
}
