import shapes.*;

public class MoveLeftCommand extends Command{
    private Person player;
    private int distance = -10;
    private int prevDistance;

    public MoveLeftCommand(Person player){
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