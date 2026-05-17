package Sem3.model.domain;

public class RepairTask { //Represents a repair task that is performed as part of a repair order. It has properties for the description of the task and the cost of the task, along with getters and setters for these properties.
    private String description;
    private double cost;

    public RepairTask(String description, double cost) { //Constructor for the RepairTask class. It takes in a description of the task and its cost, and initializes the corresponding fields of the RepairTask object.
        this.description = description;
        this.cost = cost;
    }

    //Getters
    public String getDescription() { return description; }
    public double getCost() { return cost; }

    //Setters
    public void setDescription(String description) { this.description = description; }
    public void setCost(double cost) { this.cost = cost; }

}
