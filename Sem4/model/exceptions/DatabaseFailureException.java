package Sem4.model.exceptions;

/**
 * Thrown when the system cannot connect to the database.
 * This is an unchecked exception (RuntimeException) because it represents a catastrophic system failure 
 * that the application logic cannot recover from natively.
 */
public class DatabaseFailureException extends RuntimeException {

    /**
    * Instantiates itself with a message describing the database failure.
    * @param message A message describing the database failure.
    */
    public DatabaseFailureException(String message) {
        super(message);
    }
}