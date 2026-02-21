
public class ToggleEnemyCommand extends Command{
    private Enemy enemy;
    private boolean enemyOn;

    public ToggleEnemyCommand(Enemy enemy){
        this.enemy = enemy;
        enemyOn = false;
    }

    public void execute(){
        if(!enemyOn){
            enemy.start();
            enemyOn=true;
        }
        else{
            enemy.stop();
            enemyOn=false;
        }
    }
    public void undo(){
        execute();
    }

}
