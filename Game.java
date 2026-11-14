package text_based_game;

import java.util.Scanner;

public class Game {
   
    Room start = new Room("You find yourself in a dark cavern. Ahead of you stand two glowing golden gates.", true, false);

  //CHANGED GAME TO ONE METHOD, REFACTORED CODE TO BE MORE CONCISE AND ACTUALLY WORK

    public void gameLoop()
{
    //initialize all rooms
       // Room start = new Room("You find yourself in a dark cavern. Ahead of you stand two glowing golden gates.", true, false);
        Room cavern = new Room("Large cavern with three diverging paths. Each goes to a glowing cave, one yellow, one green, one blue.", false, false);
        Room yellow = new Room("Treasure room. Piles of treasure everywhere. You look around in awe. Make the right choice.", true, false);
        Room green = new Room("Jungle room. The air is humid. Make the right choice.", true, false);
        Room blue = new Room("Water room. There is a lake flowing through, into a mysterious cavern further onwards. You shiver. It's cold. And the water seems to be rising. Make the right choice.", true, false);
        Room water = new Room("A river branches off from the lake, flowing into a mysterious cavern. The hairs on your arm stand up and you feel the fight approaching.", false, false);
        Room island = new Room("You look up. An enormous basilisk looms over you. It is at least ten times your size. Good luck.", false, true);

       
        
        
        //set all neighbors of all rooms
        start.setNeighbors(cavern, null, null, null);
        cavern.setNeighbors(blue, start, yellow, green);
        yellow.setNeighbors(null, null, null, cavern);
        green.setNeighbors(null, null, cavern, null);
        blue.setNeighbors(water, cavern, null, null);
        water.setNeighbors(island, blue, null, null);
        island.setNeighbors(null, water, null, null);

//initialize enemy by using constructors
        Enemy basilisk = new Enemy();

//thats it for this half of setting up
    
    Scanner input = new Scanner(System.in);
    boolean gameOver = false;
    boolean canEscape = true;
    Player p = new Player(start);

        System.out.println("Type the word start to begin. Type the word exit to end the program.");
        String check = input.next();
        if (check.equals("start")){
            System.out.println("Welcome to the caves.");
            System.out.println("You are running out of air. You must escape. Collect the neccesary materials to fight the basilisk.");
            p.changeRooms(start);
            System.out.println(start.getDescription());
            gameOver = false; //not actually true, but will kick us out of the game loop
        }
        else if (check.equals("exit")) {
            gameOver = true;
            System.exit(0);
        }
        else {
            System.out.println("Invalid input. Please try again.");
        }

    while (!gameOver)
    {
       //check if enemy, fight sequence
        if(p.currentRoom.equals(island)&& basilisk.getHealth()!=0) {
                theresAnEnemy(p, basilisk);
        } // sufficient? should print winning message here?

//treasure checker
        if((p.getRoom()).getHasTreasure()&& !(p.getRoom().getIsSearched())) {
            System.out.println("This room is hiding something. Take a look around? Y for yes, N for no.");
            String choice1 = input.next();
            if (choice1.equals("Y")) {
                System.out.println("It seems like there's something valuable here. Good choice.");
              //  start.search(p);
                //check for treasure other than keys depending on rooms- do we want the start to have treasure in it? where are we going to incorporate weapons?
                if (p.currentRoom == start) {
                    start.search(p);
                    System.out.println("There is nothing else in this room. You should move on.");
                }
                else if (p.currentRoom == cavern) {
                    cavern.search(p);
                    System.out.println("There is nothing else in this room. You should move on.");
                }
                else if (p.currentRoom == yellow) {
                    yellow.search(p);
                   // String choice2 = input.next();
                    System.out.println("There is something else in this room. Keep looking? Y for yes, N for no.");
                    String choice2 = input.next();

                    if (choice2.equals("Y")) {
                        System.out.println("You'll need what's in here. Good choice.");
                        System.out.println("You find two objects- a chest full of sparkling, alluring treasure and a set of armor. You may only take one. T for treasure, A for armor. Choose wisely.");
                        String choice3 = input.next();
                        if (choice3.equals("T")) {
                            System.out.println("Treasure isn't worth anything if you can't get out of the cave. Just saying.");
                        }
                        else if (choice3.equals("A")) {
                            System.out.println("Wise choice.");
                        }
                        //does this work to deal with invalid inputs?????
                        else {
                            System.out.println("Invalid input. Try again.");
                            p.changeRooms(yellow);
                        }
                    }
                    else if (choice2.equals("N")) {
                        System.out.println("Interesting choice. We'll see if you can get out, I guess.");
                    }
                    else {
                        System.out.println("Invalid input. Try again.");
                        p.changeRooms(yellow);
                    }
                }
                else if (p.currentRoom == green) {
                    green.search(p);
              //      String choice4 = input.next(); //flip order?
                    System.out.println("There is something else in this room. Keep looking? Y for yes, N for no.");
                     String choice4 = input.next(); //flip order?

                    if (choice4.equals("Y")) {
                        System.out.println("You'll need what's in here. Good choice.");
                        //idk if these are the right objects or if we should make the user entry simpler
                        System.out.println("You find two objects- a yummy looking mango and an important looking map. You may only take one. YM for yummy mango, IM for important map. Choose wisely.");
                        String choice5 = input.next();
                        if (choice5.equals("YM")) {
                            System.out.println("Hmm... I hope that mango was really, really good.");
                        }
                        else if (choice5.equals("IM")) {
                            System.out.println("Wise choice.");
                        }
                        else {
                            System.out.println("Invalid input. Try again.");
                            p.changeRooms(green);
                        }
                    }
                    else if (choice4.equals("N")) {
                        System.out.println("Interesting choice. We'll see if you can get out, I guess.");
                    }
                    else {
                        System.out.println("Invalid input. Try again.");
                        p.changeRooms(green);
                    }
                }
                //the only other option is for it to be the blue room if they've made it this far right????
                else if (p.currentRoom == blue) {
                    blue.search(p);
                    System.out.println("There is something else in this room. Keep looking? Y for yes, N for no.");
                    String choice6 = input.next(); 
                    if (choice6.equals("Y")) {
                      //  String choice7 = input.next();
                        System.out.println("You'll need what's in here. Good choice.");
                    //      String choice7 = input.next();

                        //idk if these are the right objects either
                       
                        System.out.println("You find two objects- what looks like all the materials you need to build a safe raft and a really pretty seashell. R for raft, S for seashell. Choose wisely.");
                         String choice7 = input.next();

                        if (choice7.equals("S")) {
                            System.out.println("That had better be the prettiest seashell that you've seen in your whole entire life.");
                        }
                        else if (choice7.equals("R")) {
                            System.out.println("Wise choice.");
                        }
                        else {
                            System.out.println("Invalid input. Try again.");
                            p.changeRooms(blue);
                        }
                    }
                   else if (choice6.equals("N")) {
                        System.out.println("Interesting choice. We'll see if you can get out, I guess.");
                    }
                    else {
                        System.out.println("Invalid input. Try again.");
                        p.changeRooms(blue);
                    }
                }
            }
            else if (choice1.equals("N")) {
                System.out.println("You will not be able to escape without searching. But oh well.");
                canEscape = false;
            }
            else {
                System.out.println("Invalid Input.");
            }
        }
//System.out.println("why isn't this working ahhh");

       //prompt for naviation input
        System.out.println("Which direction would you like to move? Type N for north, E for east, S for south, W for west");
        //check if possible to move in those ways
        String wD = input.next();
        Room g = p.getRoom();
        if (wD.equals("N")){
            if (g.getNeighbor("north") != null)
            {
            g.enterRoom(p, "north");
            System.out.println("you entered the room");
            System.out.println(p.getRoom().getDescription());
            }
         //  if (g.getNeighbor("north") == null) 
            else {
            System.out.println("no room exists in that direction");
        } }
        else if (wD.equals("E")){
           if (g.getNeighbor("east") != null) {
         g.enterRoom(p, "east");
        System.out.println("You entered the room");
        System.out.println(p.getRoom().getDescription());
           }
        else {
            System.out.println("no room exists in that direction");
        }
    }
        else if (wD.equals("S")){
           if (g.getNeighbor("south") != null) {
         p.getRoom().enterRoom(p, "south");
          // if (g.getNeighbor("south") == null) 
          System.out.println("You entered the room");
        System.out.println(p.getRoom().getDescription());
        }
          else {
            System.out.println("no room exists in that direction");
          }
        }
        else if (wD.equals("W")){
             if (g.getNeighbor("west") != null) {         p.getRoom().enterRoom(p, "west");
             // if (g.getNeighbor("west") == null) 
          System.out.println("You entered the room");
        System.out.println(p.getRoom().getDescription());      
        }
             else {
            System.out.println("no room exists in that direction");
        } }
        else {
            System.out.println("invalid input");
        }
        //if so, move and unlock and all the key things

        //print room info

        //prompt user to search and return item they found

        //if its the endgame, check if final enemy is defeated and if so then print a winning message

       
       
    }
}
    



    public static void theresAnEnemy(Player p, Enemy e) { //write separate method and steps if enemy has more than three lives for final
     //  Room start = new Room("Game starting location. Dark cavern with glowing golden gates.", true, false);
        Scanner input = new Scanner(System.in);
       // Room start = new Room("You find yourself in a dark cavern. Ahead of you stand two glowing golden gates.", true, false);
        System.out.println("A basilisk approaches! Choose to run away or fight back. Enter R to run away or F to fight back");
        String f = input.nextLine();
        if (f.equals("R")) {
            p.changeRooms(start);
        }
        else if (f.equals("F")) {
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
                System.out.println("The basilisk attacks you two more times and you lose two more lives. Then, it runs away.");
                e.attack(p);
                e.attack(p);
            }
        }

    } }


