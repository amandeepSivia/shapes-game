import shapes.*;

public class MoveUpCommand extends Command{
    private Person player;
    private int distance = -10;
    private int prevDistance;

    public MoveUpCommand(Person player){
        this.player=player;
    }

    public void execute(){
        prevDistance = distance;
        player.moveVertical(distance);
    }

    public void undo(){
        player.moveVertical(-prevDistance);
    }

}