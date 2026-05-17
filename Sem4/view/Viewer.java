package Sem4.view;

import Sem4.controller.Controller;
import Sem4.integration.LogHandler;
import Sem4.integration.RepairOrderLogger;
import Sem4.model.dto.*;
import Sem4.model.exceptions.CustomerNotFoundException;
import Sem4.model.exceptions.DatabaseFailureException;
import Sem4.view.RepairOrderView;

/**
 * The Viewer class is responsible for simulating the user interface of the application. It interacts with the Controller to perform operations such as searching for customers, creating repair orders, and updating repair orders. It also handles exceptions that may occur during these operations and provides user-friendly messages while logging the exceptions for developers.
 */
public class Viewer { 
    private Controller controller;
    private LogHandler logHandler;

    /**
     * Constructs a new Viewer with the specified controller.
     * @param controller The controller to interact with.
     */
    public Viewer(Controller controller) { 
        this.controller = controller;
        this.logHandler = new LogHandler();
        System.out.println("System: Starting the View...");
    }

    private int validNumberToSearch = 739988776; // Zlatan
    private int invalidNumberToSearch = 123123123; // Fails with CustomerNotFound
    private int databaseCrashNumber = 999999999; // Fails with Database failure

    /**
     * Starts the viewer by running through several scenarios to demonstrate the functionality of the application, including a basic flow with valid input, a scenario where the customer is not found, and a scenario simulating a database crash. Each scenario will show how the system handles these situations and provides feedback to the user.
     */
    public void start() { 
        System.out.println("\n--- RUNNING SCENARIO 1: Basic Flow (Success) ---");
        basicFlow(validNumberToSearch);

        System.out.println("\n--- RUNNING SCENARIO 2: Customer Not Found ---");
        basicFlow(invalidNumberToSearch);

        System.out.println("\n--- RUNNING SCENARIO 3: Database Crash ---");
        basicFlow(databaseCrashNumber);
    }

    /**
     * Simulates a basic flow for handling customer searches and repair order operations.
     * @param numberToSearch The customer number to search for.
     */
    private void basicFlow(int numberToSearch) { 
        try {
            CustomerDTO customer = controller.search(numberToSearch);
            System.out.println("System: Returned customer details from search method:");
            printCustomerDetails(customer);

            controller.createRepairOrder(numberToSearch, "Routine maintenance", "2024-06-01", "Pending");
            
            controller.addRepairOrderObserver(numberToSearch, new RepairOrderView());
            controller.addRepairOrderObserver(numberToSearch, new RepairOrderLogger());

            controller.addDiagnosticReportToOrder(numberToSearch, "The bike needs a new wheel and brake pads.");
            controller.addRepairTaskToOrder(numberToSearch, "New Wheel", 100.0);
            controller.updateRepairOrderStatus(numberToSearch, "In Progress");

            controller.checkoutCustomer(numberToSearch);

        } catch (CustomerNotFoundException e) {
            System.out.println("USER MESSAGE: The phone number you entered (" + e.getSearchedNumber() + ") is not registered. Please verify and try again.");
            logHandler.logException(e); 
        } catch (DatabaseFailureException e) {
            System.out.println("USER MESSAGE: We are currently experiencing technical difficulties. Please try again later.");
            logHandler.logException(e);
        }
    }

    /**
     * Prints the details of a customer to the console.
     * @param customer The CustomerDTO containing the details of the customer to be printed.
     */
    private void printCustomerDetails(CustomerDTO customer) { 
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Customer Details:");
        System.out.println("Name: " + customer.getName());
        System.out.println("Customer Number: " + customer.getOrderNumber());
        System.out.println("Email: " + customer.getEmail());
    }
}