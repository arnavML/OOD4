package Sem3.view;
import Sem3.model.dto.*;

public class Printer { //The Printer class is responsible for printing the details of the repair order. It has a method printRepairOrderDetails that takes in the details of the repair order and prints them in a formatted way to the console
    public void printRepairOrderDetails(RepairOrderDTO repairOrder) { // Prints the details of the repair order in a formatted way to the console
        System.out.println("---------------------------------------------------------------------------------" + "\n" + "Repair Order Printout:");
        System.out.println("Customer Number: " + repairOrder.getOrderNumber());
        System.out.println("Description: " + repairOrder.getDescription());
        System.out.println("Date: " + repairOrder.getDate());
        System.out.println("Status: " + repairOrder.getStatus());
        System.out.println("Diagnostic Report: " + repairOrder.getDiagnosticReport());
        System.out.println();
        System.out.println("Repair Tasks: " + "\n");
        for (RepairTaskDTO task : repairOrder.getRepairTasks()) {
            System.out.println(" - " + task.getDescription() + " (Cost: " + task.getCost() + ")");
        }
        System.out.println("\n" + "Total: " + repairOrder.getTotalCost() + " SEK");
        System.out.println();
    }
}
