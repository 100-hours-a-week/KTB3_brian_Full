package week1;

import java.util.Random;
import java.util.Scanner;

import static week1.GameConstants.*;

public class GameService {

    private final Random random = new Random();
    private final Scanner sc = new Scanner(System.in);
    private final BattleService battleService = new BattleService(random, sc);
    private final TierUpService tierUpService = new TierUpService(sc);

    public void gameStart() {
        System.out.println("게임을 시작합니다.");

        Character player = createCharacter();
        while (!player.isDead()) {
            System.out.println(player);
            player = tierUpService.tryTierUp(player);
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
