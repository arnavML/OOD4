package Sem3.view;

import Sem3.controller.Controller;
import Sem3.model.dto.*;

public class Viewer { //The View class is responsible for interacting with the user and displaying information. It has a reference to the Controller, which it uses to perform actions and retrieve data to display.

    private Controller controller;

    public Viewer(Controller controller) { // Initializes the view with the given controller. It also sets up some mock data for testing purposes.
        this.controller = controller;
        System.out.println("System: Starting the View...");
    }
    private int numberToSearch = 739988776; // Example number to search
    private String repairDescription = "Routine maintenance"; // Example repair description
    private String date = "2024-06-01"; // Example date


    public void start() { // Starts the view by calling the basic flow of the application, which includes receiving a bike from a customer, performing diagnostics and repair, and checking out the customer.
        basicFlow();
    }
    private void basicFlow() { //Runs the sections of the basic flow
        System.out.println("System: Running basic flow...");
        CustomerDTO customer = controller.search(numberToSearch);
        System.out.println("System: Returned customer details from search method:");

        System.out.println("Customer search Details:");
        printCustomerDetails(customer);
        printBikeDetails(customer.getBikeDTO());

        System.out.println("System: Details are correct, proceeding to create repair order...");

        controller.createRepairOrder(numberToSearch, repairDescription, date, "pending");
        RepairOrderDTO repairOrderDetails = controller.getRepairOrderDetails(numberToSearch);
        System.out.println("System: Returned repair order details from getRepairOrderDetails method:");
        
        System.out.println("Technician View - Repair Order Details:");
        printRepairOrderDetails(repairOrderDetails);
        printCustomerDetails(customer);
        printBikeDetails(customer.getBikeDTO());

        controller.addDiagnosticReportToOrder(numberToSearch, "The bike needs a new wheel, brake pads, and battery.");
        controller.addRepairTaskToOrder(numberToSearch, "new Wheel", 100.0);
        controller.addRepairTaskToOrder(numberToSearch, "new Brake Pads", 150.0);
        controller.addRepairTaskToOrder(numberToSearch, "new Battery", 40.0);

        repairOrderDetails = controller.getRepairOrderDetails(numberToSearch);
        System.out.println("System: Receptionist View - Updated Repair Order Details:");
        printRepairOrderDetails(repairOrderDetails);
        printRepairTasks(repairOrderDetails);
        controller.updateRepairOrderStatus(numberToSearch, "Accepted");
        
        controller.checkoutCustomer(numberToSearch);
    }

    private void printCustomerDetails(CustomerDTO customer) { //Prints the details of the customer, including their name, customer number, email, and bike details. This is used in the View to display the customer's information after searching for them.
        System.out.println("---------------------------------------------------------------------------------" + "\n" + "Customer Details:");
        System.out.println("Name: " + customer.getName());
        System.out.println("Customer Number: " + customer.getOrderNumber()); //perhaps redundant since it's the same as the phone number, but it could be useful if we want to change the way we identify customers in the future
        System.out.println("Email: " + customer.getEmail());
    }
    private void printBikeDetails(BikeDTO bike) { //Prints the details of the customer's bike, including the make, model, serial number, and owner's phone number. This is used in the View to display the bike's information after searching for the customer.
        System.out.println("---------------------------------------------------------------------------------" + "\n" + "Bike Details:");
        System.out.println("Bike Make: " + bike.getBrand());
        System.out.println("Bike Model: " + bike.getModel());
        System.out.println("Bike Serial Number: " + bike.getSerialNumber());
    }

    private void printRepairOrderDetails(RepairOrderDTO repairOrderDetails) { //Prints the details of the repair order, including the customer's name, bike make and model, repair description, date, and status. This is used in the View to display the repair order's information after it has been created.
        System.out.println("---------------------------------------------------------------------------------" + "\n" + "Repair Order Details:");
        System.out.println("Customer Number: " + repairOrderDetails.getOrderNumber());
        System.out.println("Repair Description: " + repairOrderDetails.getDescription());
        System.out.println("Repair Date: " + repairOrderDetails.getDate());
        System.out.println("Repair Status: " + repairOrderDetails.getStatus());
        System.out.println("Diagnostic Report: " + repairOrderDetails.getDiagnosticReport());
    }

    private void printRepairTasks(RepairOrderDTO repairOrderDetails) { //Prints the list of repair tasks associated with the repair order, including the description and cost of each task. This is used in the View to display the repair tasks after they have been added to the repair order.
        System.out.println("---------------------------------------------------------------------------------" + "\n" + "Repair Tasks:");
        for (RepairTaskDTO task : repairOrderDetails.getRepairTasks()) {
            System.out.println("Task Description: " + task.getDescription());
            System.out.println("Task Cost: " + task.getCost() + "\n");
        }
        System.out.println("Total: " + repairOrderDetails.getTotalCost() + " SEK");
    }
}
