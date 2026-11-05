package text_based_game;

public class Room {
private String description;
private int keys;
private boolean isSearched;
private boolean hasTreasure;
private boolean isLocked;
private boolean hasEnemy;
private Room island;
private Room water;
private Room yellow;
private Room blue;
private Room green;
private Room cavern;
private Room start;

public Room(String description, boolean hasTreasure, boolean hasEnemy) {}

public void setNeighbors(Room n, Room s, Room e, Room w) {}

public void setEnemy(Enemy e) {}

public int search(Player p) {
    if (isSearched == false) {
        p.addKeys(1);
        System.out.println("You have found one key!");
        isSearched = true;
    }
    else {
        System.out.println("You have already searched this room");
    }
    return p.getKeys();

}

public void enterRoom(Player p, Room n) {
    if (n.isLocked && p.hasKey()) {
        p.subtractKeys(1);
        p.changeRooms(n);
    }
    else if (n.isLocked && !(p.hasKey())) {
        System.out.println("The room is locked and you do not have a key. You are out of luck.");

    }
    else if (!(n.isLocked)) {
        p.changeRooms(n);
    }
}

public String getDescription() {
    return description;
}
//public Room getNeighbor(String direction) {}

//public Enemy getEnemy() {
    //who knows
 //   return ;
//}

public boolean hasEnemy() {
    return true;
}
}
