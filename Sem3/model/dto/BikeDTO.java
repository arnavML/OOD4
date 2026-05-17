package Sem3.model.dto;

public class BikeDTO {
    private String brand;
    private String model;
    private String serialNumber;
    private int orderNumber;

    public BikeDTO(String brand, String model, String serialNumber, int orderNumber) {
        this.brand = brand;
        this.model = model;
        this.serialNumber = serialNumber;
        this.orderNumber = orderNumber;
    }

    //Getters
    public String getBrand() { return brand; }
    public String getModel() { return model; } 
    public String getSerialNumber() { return serialNumber; }
    public int getOrderNumber() { return orderNumber; }
}
