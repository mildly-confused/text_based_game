package text_based_game;

public class Player {
    private int health = 5;
    private Room currentRoom;
    private int keys;

    public Player(Room r) {
        r = currentRoom;
    }

    public void addKeys(int k) {
        keys += k;
    }
    
    public void subtractKeys(int n) {
        keys -= n;
    }

    public boolean hasKey() {
        if (keys > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void takeDamage(int health) {
        health -= this.health;
    }

    public void attack(Enemy e) {
        e.takeDamage(1);
    }

    public void changeRooms(Room r) {
        currentRoom = r;
    }

    public int getKeys() {
        return keys;
    }

    public int getHealth() {
        return health;
    }

    public Room getRoom() {
        return currentRoom;
    }
    
}
