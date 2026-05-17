package Sem3.integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Responsible for logging developer exceptions to a file.
 */
public class LogHandler {
    private PrintWriter logFile;

    /**
     * Instantiates the logger and creates the log file if it doesn't exist.
     */
    public LogHandler() {
        try {
            logFile = new PrintWriter(new FileWriter("developer_error_log.txt", true), true);
        } catch (IOException exception) {
            System.out.println("Could not create developer log file.");
            exception.printStackTrace();
        }
    }

    /**
    * Logs an exception's message and stack trace to the log file.
    * @param exception The exception to log.
    */
    public void logException(Exception exception) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append("[").append(LocalDateTime.now()).append("] Exception thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder.toString());
        exception.printStackTrace(logFile);
    }
}