import shapes.Person;
import shapes.Square;

public class SlowMoveToHouseYCommand extends Command{
    private Person player;
    private Square house;
    private int ogPersonY;

    public SlowMoveToHouseYCommand(Person player, Square house){
        this.player = player;
        this.house = house;
    }

    public void execute(){
        ogPersonY = player.getYPosition();
        int y = house.getYPosition() - player.getYPosition();
        player.slowMoveVertical(y);
    }

    public void undo(){
        int y = player.getYPosition() - ogPersonY;
        player.slowMoveVertical(-y);
    }
    
}
