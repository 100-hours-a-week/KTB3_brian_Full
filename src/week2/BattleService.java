package week2;

import java.util.Random;
import java.util.Scanner;

public class BattleService {

    private final Random rand;
    private final Scanner sc;
    private final FileLogger logger;

    public BattleService(Random rand, Scanner sc, FileLogger fileLogger) {
        this.rand = rand;
        this.sc = sc;
        this.logger = fileLogger;
    }

    public void fight(Character player, Character enemy) {
        System.out.println("=========================");
        System.out.println("적이 나타났다!");
        int round = 0;
        while (!player.isDead() && !enemy.isDead()) {
            System.out.println("\nround: " + ++round);
            System.out.println("플레이어: " + player);
            System.out.println("적 : " + enemy);

            Choice playerChoice = askChoice();
            Choice enemyChoice = randomChoice();
            System.out.println("당신: " + playerChoice + " vs 적: " + enemyChoice + "\n");

            boolean playerWin = isPlayerWin(playerChoice, enemyChoice);

            String result = playerWin ? "WIN" : "LOSE";
            logger.logRound(String.format("[round %d] me=%s vs enemy=%s -> %s",
                    round, playerChoice, enemyChoice, result));

            if (playerWin) {
                int dmg = player.attack();
                enemy.takeDamage(dmg);
                System.out.println("승리했습니다." + dmg + "데미지를 입힙니다.");
            } else {
                int dmg = enemy.attack();
                player.takeDamage(dmg);
                System.out.println("패배했습니다." + dmg + "데미지를 받았습니다.");
            }
        }

        if (enemy.isDead()) {
            int enemyXp = enemy.getXp();
            player.gainXp(enemyXp);
            System.out.printf("적을 처치했습니다! 획득 경험치: +%d  ( 누적 XP = %d )%n", enemyXp, player.getXp());
            logger.log("battle win | gainedXp=" + enemyXp + " | totalXp=" + player.getXp());
        }
    }

    private Choice askChoice() {
        while (true) {
            System.out.print("가위(1)/바위(2)/보(3) 선택 => ");
            String s = sc.nextLine().trim();
            if (s.equals("1")) return Choice.SCISSOR;
            if (s.equals("2")) return Choice.ROCK;
            if (s.equals("3")) return Choice.PAPER;
            System.out.println("(1),(2),(3) 중 입력해주세요.");
        }
    }

    private Choice randomChoice() {
        Choice[] choices = Choice.values();
        int choice = rand.nextInt(0, 3);
        return choices[choice];
    }

    private boolean isPlayerWin(Choice playerChoice, Choice enemyChoice) {
        if (    playerChoice == Choice.SCISSOR && enemyChoice == Choice.ROCK ||
                playerChoice == Choice.ROCK && enemyChoice == Choice.PAPER ||
                playerChoice == Choice.PAPER && enemyChoice == Choice.SCISSOR ) {
            return false;
        }
        return true;
    }
}
