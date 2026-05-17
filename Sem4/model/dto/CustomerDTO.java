package Sem4.model.dto;


/**
 * A Data Transfer Object (DTO) for representing customer information in the bike repair system.
 * It contains properties for the customer's name, order number, email, and associated bike details (as a BikeDTO).
 * This DTO is used to transfer customer data between different layers of the application without exposing the internal domain models.
 */
public class CustomerDTO {
        
    private String name;
    private int orderNumber;
    private String email;
    private BikeDTO bikeDTO;

    /**
     * Constructs a new CustomerDTO with the specified details.
     * @param name The name of the customer.
     * @param orderNumber The customer's order or phone number.
     * @param email The email address of the customer.
     * @param bikeDTO The DTO representing the customer's associated bike.
     */
    public CustomerDTO(String name, int orderNumber, String email, BikeDTO bikeDTO) { //Sets the customer's name, order number, email, and bike when a new customer is created
        this.name = name;
        this.orderNumber = orderNumber;
        this.email = email;
        this.bikeDTO = bikeDTO;
    }

    /** @return The name of the customer. */
    public String getName() { return name; }

    /** @return The order number (or phone number) of the customer. */
    public int getOrderNumber() { return orderNumber; }

    /** @return The email address of the customer. */
    public String getEmail() { return email; }

    /** @return The BikeDTO representing the customer's associated bike. */
    public BikeDTO getBikeDTO() { return bikeDTO; }
}
