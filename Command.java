
public abstract class Command implements Cloneable {
    public abstract void execute();
    public abstract void undo();
    private Logger logger;
    private boolean undoOn;

    public Command(){
        logger=Logger.getInstance();
    }

    public Command clone() throws CloneNotSupportedException {
        
        Command clone = (Command) super.clone();
        return clone;
    }

    public void logCommand(){
        if(undoOn){
            logger.log(getClass().getName() + " [undo]");
        }
        else{
            logger.log(getClass().getName());
        }
    }

    public void executeWithLog(){
        undoOn=false;
        logCommand();
        execute();
    }
    public void undoWithLog(){
        undoOn=true;
        logCommand();
        undo();
    }

    public void closeLogger(){
        logger.closeLog();
    }
}
