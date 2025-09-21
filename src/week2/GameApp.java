package week2;

public class GameApp {

    public static void main(String[] args) {
        try(FileLogger fileLogger = new FileLogger()) {
            GameService game = new GameService(fileLogger);
            game.gameStart();
        }
    }
}
