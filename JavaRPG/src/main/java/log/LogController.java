package log;

import java.io.IOException;
import java.rmi.UnexpectedException;
import java.time.LocalDate;
import java.util.logging.*;

public class LogController {
    private static final Logger logger = Logger.getLogger(LogController.class.getName());

    public LogController(){

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);
        logger.addHandler(consoleHandler);

        try {
            FileHandler fileHandlerUser = new FileHandler("src/main/resources/User-log" + LocalDate.now() +".log", false);
            FileHandler fileHandlerFiner = new FileHandler("src/main/resources/Detailed-log-" + LocalDate.now() + ".log", false);
            fileHandlerUser.setLevel(Level.INFO);
            fileHandlerFiner.setLevel(Level.ALL);
            logger.addHandler(fileHandlerUser);
            logger.addHandler(fileHandlerFiner);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void log(Level level, String message){
        if(level == Level.SEVERE){
            logger.severe(message);
        } else if (level == Level.WARNING) {
            logger.warning(message);
        } else if (level == Level.INFO) {
            logger.info(message);
        } else if (level == Level.CONFIG) {
            logger.config(message);
        } else if (level == Level.FINE){
            logger.fine(message);
        }else if (level == Level.FINER){
            logger.finer(message);
        }else if (level == Level.FINEST){
            logger.finest(message);
        }
    }
}
