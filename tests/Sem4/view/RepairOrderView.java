package Sem4.view;

import Sem4.model.dto.RepairOrderDTO;
import Sem4.model.observer.RepairOrderObserver;

/**
 * An observer that prints updated repair orders to the console.
 * This replaces the need for the technician/receptionist to manually ask for updates.
 */
public class RepairOrderView implements RepairOrderObserver {

    /**
     * Called when a repair order is updated. Prints the updated details to the console.
     * @param repairOrderDTO The updated repair order.
     */
    @Override
    public void repairOrderUpdated(RepairOrderDTO repairOrderDTO) {
        System.out.println("\n*** OBSERVER NOTIFICATION: REPAIR ORDER UPDATED ***");
        System.out.println("Customer Number: " + repairOrderDTO.getOrderNumber());
        System.out.println("New Status: " + repairOrderDTO.getStatus());
        System.out.println("Current Total Cost: " + repairOrderDTO.getTotalCost() + " SEK");
        System.out.println("***************************************************\n");
    }
}