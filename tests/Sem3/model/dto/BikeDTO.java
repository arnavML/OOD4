package Sem3.model.dto;

/**
 * A Data Transfer Object (DTO) for representing the details of a bike in a repair order.
 * It has properties for the brand, model, serial number, and order number of the bike, 
 * along with getters for these properties.
 */
public class BikeDTO {
    private String brand;
    private String model;
    private String serialNumber;
    private int orderNumber;

    /**
     * Constructs a new BikeDTO with the specified details.
     * @param brand The brand of the bike.
     * @param model The model of the bike.
     * @param serialNumber The serial number of the bike.
     * @param orderNumber The order number associated with the bike.
     */
    public BikeDTO(String brand, String model, String serialNumber, int orderNumber) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.orderNumber = orderNumber;
    }

    /** @return The brand of the bike. */
    public String getBrand() { return brand; }

    /** @return The model of the bike. */
    public String getModel() { return model; }

    /** @return The serial number of the bike. */
    public String getSerialNumber() { return serialNumber; }

    /** @return The order number of the bike. */
    public int getOrderNumber() { return orderNumber; }
}
