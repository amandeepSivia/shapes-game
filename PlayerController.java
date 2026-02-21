import java.util.HashMap;
import java.util.Stack;

public class PlayerController {
    private HashMap<Character, Command> commands;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public PlayerController(){
        commands = new HashMap();
        undoStack = new Stack();
        redoStack = new Stack();
    }

    public void setCommand(char c, Command com){
        commands.put(c,com);
    }

    public void keyWasPressed(char c) throws CloneNotSupportedException {
        //w,a,s,d, W,A,S,D, u, r, h, o, or q
        if(c == 'u'){
            undoButtonWasPressed();
        }
        else if(c == 'r'){    
            redoButtonWasPressed();
        }
        else if(commands.get(c) != null){
            //commands.get(c).execute();
            Command command = commands.get(c);
            command.executeWithLog();
            undoStack.push(command.clone());
        }
        else{
            System.out.println("not a valid key:( try again!!)");
        }
    }

    public void undoButtonWasPressed(){
        if(undoStack.isEmpty()){
            System.out.println("nothing to undo try again!!)");
        }
        else{
            Command undoCommand = undoStack.pop();
            //undoCommand.undo();
            undoCommand.undoWithLog();
            redoStack.push(undoCommand);
        }
    }

    public void redoButtonWasPressed(){
        if(redoStack.isEmpty()){
            System.out.println("nothing to redo try again!!)");
        }
        else{
            Command redoCommand = redoStack.pop();
            //redoCommand.execute();
            redoCommand.executeWithLog();
            undoStack.push(redoCommand);
        }
    }
}
