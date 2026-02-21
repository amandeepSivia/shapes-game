import shapes.*;

public class MoveRightCommand extends Command{
    private Person player;
    private int distance = 10;
    private int prevDistance;

    public MoveRightCommand(Person player){
        this.player=player;
    }

    public void execute(){
        prevDistance = distance;
        player.moveHorizontal(distance);
    }

    public void undo(){
        player.moveHorizontal(-prevDistance);
    }

}