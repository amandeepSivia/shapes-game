import shapes.Person;
import shapes.Square;

public class SlowMoveToHouseXCommand extends Command {
    private Person player;
    private Square house;
    private int ogPersonX;

    public SlowMoveToHouseXCommand(Person player, Square house){
        this.player = player;
        this.house = house;
    }

    public void execute(){
        ogPersonX = player.getXPosition();
        int x = house.getXPosition() - player.getXPosition();
        player.slowMoveHorizontal(x);
    }

    public void undo(){
        int x = player.getXPosition() - ogPersonX;
        player.slowMoveHorizontal(-x);
    }
    
}
