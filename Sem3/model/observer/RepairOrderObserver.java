package Sem3.model.observer;

import Sem3.model.dto.RepairOrderDTO;

/**
 * A listener interface for receiving notifications when a repair order changes.
 */
public interface RepairOrderObserver {

    /**
     * Called when a repair order is updated.
     * @param repairOrderDTO The updated repair order.
     */
    void repairOrderUpdated(RepairOrderDTO repairOrderDTO);
}