package text_based_game;

public class GameDriver {
    public static void main(String[] args) {
        Game ourGame = new Game();

      //  ourGame.setUpGame(); removed bc I called this method at the start of the gameloop class
        ourGame.gameLoop();
    }
}
