import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger uniqueInstance;
    private FileWriter fileWriter;

    private Logger(){ 
        try{ 
            fileWriter = new FileWriter("PartBLog.log", true);
        }catch(IOException e){
            System.out.println("IOException occured");
        }
    }

    public static Logger getInstance(){
         
        if (uniqueInstance == null) {
            uniqueInstance = new Logger();
        }
        return uniqueInstance;
    }

    public void log(String className){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatThing = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        try{ 
            fileWriter.write(dateTime.format(formatThing) + " " + className + "\n");
        }catch(IOException e){
            System.out.println("IOException occured");
        }
    }

    public void closeLog(){
        try{ 
            fileWriter.close();
        }catch(IOException e){
            System.out.println("IOException occured");
        }
    }
}
