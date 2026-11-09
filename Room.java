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
private Room n;
private Room s;
private Room e;
private Room w;


public Room(String description, boolean hasTreasure, boolean hasEnemy) {
    this.description = description;
    this.hasTreasure = hasTreasure;
    this.hasEnemy = hasEnemy;
}

public void setNeighbors(Room n, Room s, Room e, Room w) {
this.n = n;
this.s = s;
this.e = e;
this.w = w;
}

public void setEnemy(Enemy e) {
    if (this.Room == island) {
        Enemy basilisk = new Enemy();
    } 
}

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

public void enterRoom(Player p, String d, Room n) {
   if ((p.currentRoom.getNeighbor(d))!= null){
    if (n.isLocked && p.hasKey()) {
        p.subtractKeys(1);
        p.changeRooms(n);
        isLocked = false;
        System.out.println("You may enter. This room is " + n.getDescription());
    }
    else if (n.isLocked && !(p.hasKey())) {
        System.out.println("The room is locked and you do not have a key. You are out of luck. Try searching this room.");
        isLocked = true;
    }
    else if (!(n.isLocked)) {
        p.changeRooms(n);
    }
}

else
    System.out.println("There is no room in that direction");
   
}



public String getDescription() {
    return description;
}


public Room getNeighbor(String direction) {
    if (direction.equals("north"))
        return n;
    else if (direction.equals("south"))
        return s;
    else if (direction.equals("east"))
        return e;
    else 
        return w;

}

public Enemy getEnemy(Player p) {
  if (p.currentRoom == island) {
    return basilisk;
  }
  else 
    return null;
}

public boolean hasEnemy() {
if (hasEnemy == true) {
    return true;
}
else
    return false;
}

public boolean getHasTreasure() {
    return hasTreasure;
}

public boolean getIsSearched() {
    return isSearched;
}

}
