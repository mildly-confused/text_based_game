package text_based_game;

public class GameDriver {
    public static void main(String[] args) {
         Room start = new Room("You find yourself in a dark cavern. Ahead of you stand two glowing golden gates.", true, false);
        Game ourGame = new Game();
        Player p = new Player(start);
        Enemy e = new Enemy();

      //  ourGame.setUpGame(); removed bc I called this method at the start of the gameloop class
        ourGame.gameLoop();
        ourGame.theresAnEnemy(p,e);
    }
}
