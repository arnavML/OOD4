package Sem3.model.domain;

/**
 * Represents a bike in the system, with properties for brand, model, 
 * serial number, and owner number (which links the bike to its owner/customer in the system).
 */
public class Bike {
    private String brand;
    private String model;
    private String serialNumber;
    private int OrderNumber;

    /**
     * Constructs a new Bike with the specified brand, model, serial number, and owner number.
     * @param brand The brand of the bike.
     * @param model The model of the bike.
     * @param serialNumber The unique serial number of the bike.
     * @param orderNumber The phone number or ID of the owner.
     */
    public Bike(String brand, String model, String serialNumber, int orderNumber) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.OrderNumber = orderNumber;
    }

    /** @return The brand of the bike. */
    public String getBrand() { return brand; }
    /** @return The model of the bike. */
    public String getModel() { return model; }
    /** @return The serial number of the bike. */
    public String getSerialNumber() { return serialNumber; }
    /** @return The phone number or ID of the owner. */
    public int getOrderNumber() { return OrderNumber; }

    /**
     * Sets the brand of the bike.
     * @param brand The new brand of the bike.
     */
    public void setBrand(String brand) { this.brand = brand; }
    /**
    * Sets the model of the bike.
    * @param model The new model of the bike.
    */
    public void setModel(String model) { this.model = model; }   
    /**
     * Sets the serial number of the bike.
     * @param serialNumber The new serial number of the bike.
     */ 
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    /**
     * Sets the phone number or ID of the owner.
     * @param orderNumber The new phone number or ID of the owner.
     */
    public void setOrderNumber(int orderNumber) { this.OrderNumber = orderNumber; }

}
