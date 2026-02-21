import shapes.*;

public class MoveRightCommandPower extends Command{
    private Person player;
    private int distance = 20;
    private int prevDistance;

    public MoveRightCommandPower(Person player){
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