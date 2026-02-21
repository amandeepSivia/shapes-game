import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Configuration {
    private static Configuration uniqueInstance;
    private String difficulty;
    private int enemySpeed;
    private int enemyHeight;
    private int enemyWidth;
    private int enemyMovementRange;

    private Configuration(){
        
        try{
            Scanner fileReader = new Scanner(new File("ConfigurationFile.txt"));
            while(fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                int equalSign = line.indexOf('=');//because 'difficulty=1'
                String inforName = line.substring(0,equalSign);
                String info = line.substring(equalSign+1, line.length());
                if(inforName.equals("difficulty")){
                    difficulty = info;
                }
                else if(inforName.equals("enemySpeed")){
                    enemySpeed = Integer.parseInt(info);
                }
                else if(inforName.equals("enemyHeight")){
                    enemyHeight = Integer.parseInt(info);
                }
                else if(inforName.equals("enemyWidth")){
                    enemyWidth = Integer.parseInt(info);
                }
                else if(inforName.equals("enemyMovementRange")){
                    enemyMovementRange = Integer.parseInt(info);
                }
            }

        } catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
    }

    public static Configuration getInstance(){
        if (uniqueInstance == null) {
            uniqueInstance = new Configuration();
        }
        return uniqueInstance;
    }

    public String getDifficulty(){
        return difficulty;
    }

    public int getEnemySpeed(){
        return enemySpeed; 
    }

    public int getEnemyWidth(){
        return enemyWidth; 
    }

    public int getEnemyHeight(){
        return enemyHeight; 
    }

    public int getEnemyMovementRange(){
        return enemyMovementRange; 
    }

}
