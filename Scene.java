import shapes.*;

/**
 *
 * Creates the game scene with access to the house, player and enemy
 */
public class Scene {
    private Square house;
    private Circle sun;
    private Triangle roof;
    private Person player;
    private Enemy enemy;

    public Scene() {
        // house
        house = new Square();
        house.changeColor("blue");
        house.moveHorizontal(-130);
        house.moveVertical(80);
        house.makeVisible();

        // roof 
        roof = new Triangle();
        roof.makeVisible();

        // sun 
        sun = new Circle();
        sun.changeColor("yellow");
        sun.moveVertical(-80);
        sun.makeVisible();

        // player
        player = new Person();
        player.changeSize(40, 20);
        player.moveVertical(-100);
        player.moveHorizontal(100);
        player.makeVisible();

        // enemy
        Person badGuy = new Person();
        badGuy.changeColor("red");
        badGuy.moveHorizontal(60);
        badGuy.moveVertical(-80);
        badGuy.makeVisible();
        enemy = new Enemy(badGuy);
    }

    /**
     * getters
     */ 
    public Person getPlayer() {
        return player;
    }

    public Square getHouse() {
        return house;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
