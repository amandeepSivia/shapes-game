import shapes.*;

public class MoveUpCommandPower extends Command{
    private Person player;
    private int distance = -20;
    private int prevDistance;

    public MoveUpCommandPower(Person player){
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
