package week1;

import java.util.Scanner;

public interface TierUpgradeStrategy {

    boolean supports(Character character);
    Character upgrade(Character character, Scanner sc);
}
