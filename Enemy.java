import java.util.Timer;
import java.util.TimerTask;
import shapes.*;

/** 
 * 
 * The Enemy class represents an automated character (red Person)
 * that moves up and down on the canvas using a timer.
 */ 
public class Enemy {
    private final Person person;
    private Timer timer;
    private int dir = 1;

    private Configuration configuration;
    private int STEP = 5;
    private int RANGE = 120;
    private int DELAY = 200;

    public Enemy(Person person) {
        this.person = person;
        configuration = Configuration.getInstance();
        STEP = configuration.getEnemySpeed();
        RANGE = configuration.getEnemyMovementRange();
        person.changeSize(configuration.getEnemyHeight(), configuration.getEnemyWidth());
        String difficulty = configuration.getDifficulty();
        
        if(difficulty.equals("easy")){
            DELAY = 500;
        }
        else if(difficulty.equals("hard")){
            DELAY = 100;
        }
        else{
            DELAY = 250;
        }
    }

    /**
     * Starts the enemy's automatic movement if it isn't already running.
     * Schedules a timer task that repeatedly moves the Person up and down.
     */
    public void start() {
        if (timer != null) return;
        timer = new Timer(true);
        timer.scheduleAtFixedRate(new MoveTask(), 0, DELAY);
    }

    /**
     * Stops the enemy's automatic movement.
     * Cancels the timer so the Person stays in its current position.
     */
    public void stop() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    /**
     * Inner class: handles movement
     * Moves the enemy up and down while the timer is active.
     */
    private class MoveTask extends TimerTask {
        private int distance = 0;

        /**
         * Runs once per timer tick to move the enemy.
         * Reverses direction after reaching the set range.
         */		
        public void run() {
            person.moveVertical(dir * STEP);
            distance += STEP;
            if (distance >= RANGE) {
                dir = -dir;
                distance = 0;
            }
        }
    }
}