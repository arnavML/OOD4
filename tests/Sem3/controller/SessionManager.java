package Sem3.controller;

import Sem3.integration.RepairOrderRegistry;
import Sem3.model.domain.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages active sessions for ongoing repair orders based on the customer's phone number.
 */
public class SessionManager {

    private Map<Integer, RepairOrder> searchedRepairs;
    private RepairOrderRegistry repairOrderRegistry;

    /**
     * Initializes the session manager with an empty map for tracking active repairs.
     * @param repairOrderRegistry The registry to look up repair orders if they are not in the current session.
     */
    public SessionManager(RepairOrderRegistry repairOrderRegistry) {
        this.searchedRepairs = new HashMap<>();
        this.repairOrderRegistry = repairOrderRegistry;
    }

    /**
     * Adds a newly created or retrieved repair order to the active session tracker.
     * @param customerNumber The phone number acting as the unique identifier.
     * @param repairOrder The repair order currently being worked on.
     */
    public void startSession(int customerNumber, RepairOrder repairOrder) {
        searchedRepairs.put(customerNumber, repairOrder);
    }

    /**
     * Retrieves the active repair order for a given customer without searching the main registry.
     * If not found in the active session, it queries the main registry.
     * @param customerNumber The phone number identifying the session.
     * @return The active RepairOrder, or null if no session exists for that number.
     */
    public RepairOrder getSearchedOrders(int customerNumber) {
        if (searchedRepairs.containsKey(customerNumber)) {
            return searchedRepairs.get(customerNumber);
        }
        else {
            RepairOrder repairOrder = repairOrderRegistry.findCustomerByNumber(customerNumber);
            searchedRepairs.put(customerNumber, repairOrder);
            return repairOrder;
        }
    }

    /**
     * Removes the repair order from the active session tracker once the workflow is completed.
     * @param customerNumber The phone number identifying the session to be closed.
     */
    public void endSession(int customerNumber) {
        searchedRepairs.remove(customerNumber);
    }

}
