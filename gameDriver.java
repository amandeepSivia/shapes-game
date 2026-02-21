import java.util.Scanner;
import shapes.*;

public class gameDriver{
    public static void main(String[] args) throws CloneNotSupportedException{
        
        Scene game = new Scene();
        Person player = game.getPlayer();

        PlayerController playerController = new PlayerController();
        MoveUpCommand moveUpCommand = new MoveUpCommand(player);
        MoveDownCommand moveDownCommand = new MoveDownCommand(player);
        MoveLeftCommand moveLeftCommand = new MoveLeftCommand(player);
        MoveRightCommand moveRightCommand = new MoveRightCommand(player);
        playerController.setCommand('w',moveUpCommand );
        playerController.setCommand('a',moveLeftCommand );
        playerController.setCommand('s',moveDownCommand );
        playerController.setCommand('d',moveRightCommand );

        SlowMoveToHouseYCommand slowMoveToHouseYCommand = new SlowMoveToHouseYCommand(player, game.getHouse());
        SlowMoveToHouseXCommand slowMoveToHouseXCommand = new SlowMoveToHouseXCommand(player, game.getHouse());
        Command[] macroCommands = {slowMoveToHouseYCommand, slowMoveToHouseXCommand};
        MacroCommand macroCommand = new MacroCommand(macroCommands);
        playerController.setCommand('h',macroCommand );

        MoveUpCommandPower moveUpCommandPower = new MoveUpCommandPower(player);
        MoveDownCommandPower moveDownCommandPower = new MoveDownCommandPower(player);
        MoveLeftCommandPower moveLeftCommandPower = new MoveLeftCommandPower(player);
        MoveRightCommandPower moveRightCommandPower = new MoveRightCommandPower(player);
        playerController.setCommand('W',moveUpCommandPower );
        playerController.setCommand('A',moveLeftCommandPower );
        playerController.setCommand('S',moveDownCommandPower );
        playerController.setCommand('D',moveRightCommandPower );

        ToggleEnemyCommand toggleEnemyCommand = new ToggleEnemyCommand(game.getEnemy());
        playerController.setCommand('o', toggleEnemyCommand );

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter a keys w,a,s,d, W,A,S,D, u, r, h, o, or q to quit:");
        String input = kb.next();
        char key = input.charAt(0);
        while(key != 'q'){
            playerController.keyWasPressed(key);
            input = kb.next();
            key = input.charAt(0);
        }

        System.out.println("end of game:)");
        //because singleton only has one instance and global access point can be used here
        toggleEnemyCommand.closeLogger();
    }
}
