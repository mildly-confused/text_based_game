package text_based_game;

public class Player {
    private int health;
    private Room currentRoom;
    private int hasKeys;

    public Player(Room r) {
        r = currentRoom;
    }

    public void addKeys(int keys) {
        hasKeys += keys;
    }

    public boolean hasKey() {
        if (hasKeys > 0) {
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
        e.health--;
    }

    public void changeRooms(Room r) {
        currentRoom = r;
    }

    public int getKeys() {
        return hasKeys;
    }

    public int getHealth() {
        return health;
    }

    public Room getRoom() {
        return currentRoom;
    }
}
