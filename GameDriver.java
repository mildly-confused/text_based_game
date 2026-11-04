package text_based_game;

public class GameDriver {
    public static void main(String[] args) {
        Game ourGame = new Game();

        ourGame.setUpGame();
        ourGame.gameLoop();
    }
}
