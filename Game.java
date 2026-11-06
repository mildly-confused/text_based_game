package text_based_game;

import java.util.Scanner;

public class Game {
   //Enemy e = new Enemy(); 
    //Room firstRoom = new Room("gates", true, false);
    //Player p = new Player(start);
    //Game ourGame = new Game();

    public void setUpGame() {
         
        //initialize all rooms
        Room start = new Room("Game starting location. Dark cavern with glowing golden gates.", true, false);
        Room cavern = new Room("Large cavern with three diverging paths. Each goes to a glowing cave, one yellow, one green, one blue.", false, false);
        Room yellow = new Room("Treasure room. Piles of treasure everywhere. You look around in awe. Make the right choice.", true, false);
        Room green = new Room("Jungle room. The air is humid. Make the right choice.", true, false);
        Room blue = new Room("Water room. There is a lake flowing through, into a mysterious cavern further onwards. You shiver. It's cold. And the water seems to be rising. Make the right choice.", true, false);
        Room water = new Room("A river branches off from the lake, flowing into a mysterious cavern. The hairs on your arm stand up and you feel the fight approaching.", false, false);
        Room island = new Room("You look up. An enormous basilisk looms over you. It is at least ten times your size. Good luck.", false, true);

        //Player p = new Player(start);
        //Enemy e = new Enemy(); 

        
        
        //set all neighbors of all rooms
        start.setNeighbors(cavern, null, null, null);
        cavern.setNeighbors(blue, start, yellow, green);
        yellow.setNeighbors(null, null, null, cavern);
        green.setNeighbors(null, null, cavern, null);
        blue.setNeighbors(water, cavern, null, null);
        water.setNeighbors(island, blue, null, null);
        island.setNeighbors(null, water, null, null);
    }

    public void gameLoop()
{
    boolean gameOver = false;
    while (!gameOver)
    {
        Room start = new Room("Game starting location. Dark cavern with glowing golden gates.", true, false);
        Player p = new Player(start);
        Scanner input = new Scanner(System.in);
        p.getRoom();
        start.hasEnemy();
        System.out.println("Type the word start to begin. Type the word exit to end the program.");
        if (input.nextLine().equals("start")){
            System.out.println("Welcome to the caves.");
            System.out.println("You are running out of air. You must escape. Collect the neccesary materials to fight the basilisk.");
            p.changeRooms(start);
            start.getDescription();
        }
        if (input.nextLine().equals("exit")) {
            System.exit(0);
        }
        else {
            System.out.println("Invalid input. Please try again.");
        }
        input.close();
    }
}

    public void theresAnEnemy(Player p, Enemy e) { //write separate method and steps if enemy has more than three lives for final
        Room start = new Room("Game starting location. Dark cavern with glowing golden gates.", true, false);
        Scanner input = new Scanner(System.in);
        System.out.println("A basilisk approaches! Choose to run away or fight back. Enter R to run away or F to fight back");
        if (input.nextLine().equals("R")) {
            p.changeRooms(start);
        }
        else if (input.nextLine().equals("F")) {
            p.attack(e);
            e.attack(p);
            System.out.println("You've been hit and lost one life! Do you want to attack again? Type Y for yes and N for no");
            if (input.nextLine().equals("Y")) {
                p.attack(e);
            }
            else {
                System.out.println("The basilisk attacks several more times- you've lost all your lives.");
                System.exit(0);
            }
            e.attack(p);
            System.out.println("The basilisk appears weak, though you have lost two lives. Do you want to attack again? Type Y for yes and N for no");
             if (input.nextLine().equals("Y")) {
                p.attack(e);
            }
            else {
                System.out.println("The basilisk attacks you two more times and you lose two more lives. Then, it runs away.")
                e.attack(p);
                e.attack(p);
            }
        }

    }
}
