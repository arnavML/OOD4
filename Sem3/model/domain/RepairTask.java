package Sem3.model.domain;

/**
 * Represents a repair task that is performed as part of a repair order. 
 * It has properties for the description of the task and the cost of the task, 
 * along with getters and setters for these properties.
 */
public class RepairTask { //Represents a repair task that is performed as part of a repair order. It has properties for the description of the task and the cost of the task, along with getters and setters for these properties.
    private String description;
    private double cost;

    /**
     * Constructs a new RepairTask with the specified description and cost.
     * @param description The description of the repair task.
     * @param cost The cost of the repair task.
     */
    public RepairTask(String description, double cost) { //Constructor for the RepairTask class. It takes in a description of the task and its cost, and initializes the corresponding fields of the RepairTask object.
        this.description = description;
        this.cost = cost;
    }

    /** @return The description of the repair task. */
    public String getDescription() { return description; }

    /** @return The cost of the repair task. */
    public double getCost() { return cost; }

    /** @param description The description to set. */
    public void setDescription(String description) { this.description = description; }

    /** @param cost The cost to set. */
    public void setCost(double cost) { this.cost = cost; }

}
