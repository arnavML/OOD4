package Sem4.integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import Sem4.model.dto.RepairOrderDTO;
import Sem4.model.observer.RepairOrderObserver;

/**
 * An observer that logs updated repair orders to a text file.
 */
public class RepairOrderLogger implements RepairOrderObserver {
    private PrintWriter logStream;

    /**
     * Instantiates the logger and creates the log file if it doesn't exist.
     */
    public RepairOrderLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("repair_order_updates.txt", true), true);
        } catch (IOException exception) {
            System.out.println("Could not create repair order logger file.");
            exception.printStackTrace();
        }
    }

    /**
     * Called when a repair order is updated. Logs the updated details to a text file.
     * @param repairOrderDTO The updated repair order.
     */
    @Override
    public void repairOrderUpdated(RepairOrderDTO repairOrderDTO) {
        logStream.println("[" + LocalDateTime.now() + "] Repair Order Updated for Customer: " + repairOrderDTO.getOrderNumber());
        logStream.println("   Status: " + repairOrderDTO.getStatus() + ", Cost: " + repairOrderDTO.getTotalCost() + " SEK");
    }
}