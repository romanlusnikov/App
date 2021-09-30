package sample;

import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class LoggingMain {
    private static Logger logger;

    static {
        try (FileInputStream configFile = new FileInputStream("src\\logging\\logging.config")) {
            LogManager.getLogManager().readConfiguration(configFile);
            logger = Logger.getLogger(LoggingMain.class.getName());
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }

}
