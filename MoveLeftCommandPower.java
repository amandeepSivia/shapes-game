import shapes.*;

public class MoveLeftCommandPower extends Command{
    private Person player;
    private int distance = -20;
    private int prevDistance;

    public MoveLeftCommandPower(Person player){
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