package text_based_game;

import java.util.Scanner;

public class Game {
    Enemy e = new Enemy(); 
    //Room firstRoom = new Room("gates", true, false);
    Player p = new Player(start);

    public void setUpGame() {
        System.out.println("Welcome to the caves.");
        System.out.println("You are running out of air. You must escape. Collect the neccesary materials to fight the basilisk.");
         
        //initialize all rooms
        Room start = new Room("Game starting location. Dark cavern with glowing golden gates.", true, false);
        Room cavern = new Room("Large cavern with three diverging paths. Each goes to a glowing cave, one yellow, one green, one blue.", false, false);
        Room yellow = new Room("Treasure room. Piles of treasure everywhere. You look around in awe. Make the right choice.", true, false);
      //  Room green = new Room("")
        
        
        
        
        
        //set all neighbors of all rooms
    }

    public void gameLoop() {
        
    }

    public void theresAnEnemy() { //write separate method and steps if enemy has more than three lives for final
        Scanner input = new Scanner(System.in);
        System.out.println("A basilisk approaches! Choose to run away or fight back. Enter R to run away or F to fight back");
        if (input.nextLine().equals("R")) {
            p.changeRooms(firstRoom);
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
