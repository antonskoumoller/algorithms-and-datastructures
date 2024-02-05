
public class Knight {
    private int health;
    private int strength;
    private int knightId;

    public Knight(int health, int strength, int knightId) {
        this.health = health;
        this.strength = strength;
        this.knightId = knightId;
    }

    public void takeDamage(int damage) {
        health = health - damage;
    }

    public boolean isDead() {
        if (health < 0) return true;
        else return false;
    }

    public void attack(Knight k) {
        k.takeDamage(strength);
    }

    public int getKnightId() {
        return knightId;
    }
}
