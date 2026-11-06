package text_based_game;

public class Test {
    public static void main (String[] args){
        Room forMethod = new Room("only for testing", false, false);
        Player charlotte = new Player(forMethod);
        Game ourTestGame = new Game();
        ourTestGame.gameLoop();
        
    }
}
