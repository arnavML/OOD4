package Sem3.model.domain;

/**
 * Represents a customer in the system, with properties for name, customer number, 
 * email, and bike (which links the customer to their bike in the system).
 */
public class Customer {
    
    private String name;
    private int orderNumber;
    private String email;
    private Bike bike;

    /**
     * Constructs a new Customer with the specified details and associated bike.
     * @param name The name of the customer.
     * @param orderNumber The customer's order or phone number.
     * @param email The customer's email address.
     * @param bike The bike belonging to the customer.
     */
    public Customer(String name, int orderNumber, String email, Bike bike) {
        this.name = name;
        this.orderNumber = orderNumber;
        this.email = email;
        this.bike = bike;
    }

    /** @return The name of the customer. */
    public String getName() { return name; }

    /** @return The customer's order or phone number. */
    public int getOrderNumber() { return orderNumber; }

    /** @return The customer's email address. */
    public String getEmail() { return email; }

    /** @return The bike belonging to the customer. */
    public Bike getBike() { return bike; }


    /** @param name The name to set. */
    public void setName(String name) { this.name = name; }

    /** @param orderNumber The order or phone number to set. */
    public void setOrderNumber(int orderNumber) { this.orderNumber = orderNumber; }

    /** @param email The email address to set. */
    public void setEmail(String email) { this.email = email; }
    
    /** @param bike The bike to set. */
    public void setBike(Bike bike) { this.bike = bike; }

}
