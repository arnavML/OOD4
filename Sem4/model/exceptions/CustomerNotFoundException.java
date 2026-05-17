package Sem4.model.exceptions;

/**
 * Thrown when a search is made for a customer phone number that does not exist.
 * This is a checked exception as the user (receptionist) can recover by checking the number and trying again.
 */
public class CustomerNotFoundException extends Exception {
    private int searchedNumber;

    /**
     * Instatiates itself with a message and the number that was searched for.
     * @param message
     * @param searchedNumber
     */
    public CustomerNotFoundException(String message, int searchedNumber) {
        super(message);
        this.searchedNumber = searchedNumber;
    }

    /**
     * Getter for the number that was searched for, which caused the exception to be thrown.
     * @return The number that was searched for.
     */
    public int getSearchedNumber() {
        return searchedNumber;
    }
}