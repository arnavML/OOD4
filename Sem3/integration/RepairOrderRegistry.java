package Sem3.integration;
import java.util.ArrayList;
import java.util.List;

import Sem3.model.domain.RepairOrder;

/**
 * The RepairOrderRegistry class is responsible for managing a collection of repair orders in the system.
 * It provides methods for adding repair orders, finding repair orders by the customer's phone number, and retrieving a list of all repair orders.
 */
public class RepairOrderRegistry {

    private List<RepairOrder> repairOrders = new ArrayList<>();
    
    /**
     * Initializes the repair order registry with an empty list of repair orders.
     */
    public RepairOrderRegistry(){
        this.repairOrders = new ArrayList<>();
    }
    
    /**
     * Returns a copy of the list of all repair orders in the registry.
     * @return A list of all repair orders.
     */
    public List<RepairOrder> getAllRepairOrders() {
        return new ArrayList<>(repairOrders);
    }
    
    /**
     * Adds a new repair order to the registry by adding it to the list of repair orders.
     * @param repairOrder The repair order to add.
     */
    public void addRepairOrder(RepairOrder repairOrder) {
        repairOrders.add(repairOrder); 
    }

    /**
     * Finds a repair order in the registry by the customer's number.
     * @param number The customer's number.
     * @return The found repair order or null if not found.
     */
    public RepairOrder findCustomerByNumber(int number) {
        for (RepairOrder repairOrder : repairOrders) {
            if (repairOrder.getOrderNumber() == number) {
                return repairOrder;
            }
        }
        return null;
    }
}
