package text_based_game;

public class Enemy {
    private int health;
    private String description;

    public Enemy() {
        this.health = 3;
        this.description = "badEnemy";
    }

    public boolean isAlive() {
        if (health > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void attack(Player p) {
        p.takeDamage(1);
    }

    public String getDescription() {
        return description;
    }

}
