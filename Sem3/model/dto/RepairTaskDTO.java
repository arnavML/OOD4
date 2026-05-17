package Sem3.model.dto;

/**
 * A Data Transfer Object (DTO) for representing a repair task in a repair order.
 * It has properties for the description and cost of the repair task, along with getters for these properties.
 */
public class RepairTaskDTO {
    private String description;
    private double cost;

    /**
     * Constructs a new RepairTaskDTO with the specified description and cost.
     * @param description The description of the repair task.
     * @param cost The cost of the repair task.
     */
    public RepairTaskDTO(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    /** @return The description of the repair task. */
    public String getDescription() { return description; }

    /** @return The cost of the repair task. */
    public double getCost() { return cost; }
}
