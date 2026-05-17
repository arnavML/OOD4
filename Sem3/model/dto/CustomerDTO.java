package Sem3.model.dto;

public class CustomerDTO {
        
    private String name;
    private int orderNumber;
    private String email;
    private BikeDTO bikeDTO;

    public CustomerDTO(String name, int orderNumber, String email, BikeDTO bikeDTO) { //Sets the customer's name, order number, email, and bike when a new customer is created
        this.name = name;
        this.orderNumber = orderNumber;
        this.email = email;
        this.bikeDTO = bikeDTO;
    }

    //Getters
    public String getName() { return name; }
    public int getOrderNumber() { return orderNumber; }
    public String getEmail() { return email; }
    public BikeDTO getBikeDTO() { return bikeDTO; }
}
