package log;

import java.util.logging.*;

public class LogController {
    private static final Logger logger = Logger.getLogger(LogController.class.getName());


    public LogController(){
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
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
