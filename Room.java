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

public void search() {}

public void enterRoom(Player p) {}

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
