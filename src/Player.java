public class Player {

    int lives;
    Field field;

    Player() {
        this.lives = 20;
        this.field = new Field();
        field.newShip(4);
        field.newShip(3);
        field.newShip(3);
        field.newShip(2);
        field.newShip(2);
        field.newShip(2);
        field.newShip(1);
        field.newShip(1);
        field.newShip(1);
        field.newShip(1);

    }

    public boolean attack(Player player) {
        return false;
    }

    public int subLive() {
        this.lives--;
        return lives;
    }

    public boolean isAlive() {
        return (lives > 0);
    }
}
