package Sem3.controller;

import Sem3.view.Printer;
import Sem3.integration.*;
import Sem3.model.domain.*;
import Sem3.model.dto.*;
import Sem3.model.mapper.*;


/**
 * The Controller class is responsible for handling the logic of the application, 
 * including searching for customers, creating repair orders, and managing the details of the repair orders.
 * It interacts with the CustomerRegistry to find customers, the RepairOrderRegistry to manage repair orders, 
 * and the Printer to print repair order details.
 * It also stores the current repair order via the SessionManager to facilitate getting their details 
 * without having to search for them again.
 */
public class Controller {

    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private Printer printer;
    private SessionManager sessionManager;

    /**
     * Initializes the controller with the given customer registry, repair order registry, and printer.
     * @param customerRegistry The registry used to find and manage customers.
     * @param repairOrderRegistry The registry used to manage repair orders.
     * @param printer The printer used to print repair order details.
     */
    public Controller(CustomerRegistry customerRegistry, RepairOrderRegistry repairOrderRegistry, Printer printer) {
        this.customerRegistry = customerRegistry;
        this.repairOrderRegistry = repairOrderRegistry;
        this.printer = printer;
        this.sessionManager = new SessionManager(repairOrderRegistry);
    }

    /**
     * Searches for a customer by their phone number. 
     * This is used in the View when the receptionist/technician searches for a customer.
     * Finds the customer in the registry and returns the DTO if found, otherwise returns null.
     * @param number The phone number of the customer to search for.
     * @return A CustomerDTO representing the found customer, or null if not found.
     */
    public CustomerDTO search(int number) {
        CustomerDTO customerDTO = CustomerMapper.toDTO(customerRegistry.findCustomerByNumber(number));
        return customerDTO;
    }

    /**
     * Creates a new repair order for the given customer with the provided description, date, and status.
     * @param number The phone number of the customer.
     * @param description The description of the repair needed.
     * @param date The date the repair order is created.
     * @param status The initial status of the repair order.
     */
    public void createRepairOrder(int number, String description, String date, String status) {
        RepairOrder newRepairOrder = new RepairOrder(customerRegistry.findCustomerByNumber(number), description, date, status);
        repairOrderRegistry.addRepairOrder(newRepairOrder);
        sessionManager.startSession(number, newRepairOrder);
    }

    /**
     * Gets the details of the repair order.
     * This is used in the View to display the details of the repair order after it has been created.
     * @param number The phone number associated with the repair order.
     * @return A RepairOrderDTO containing the details of the repair order.
     */
    public RepairOrderDTO getRepairOrderDetails(int number) {
        RepairOrder currentRepairOrder = sessionManager.getSearchedOrders(number);
        return RepairOrderMapper.toDTO(currentRepairOrder);
    }

    /**
     * Adds a diagnostic report to the repair order.
     * This is used in the View to add a diagnostic report to the repair order after it has been created.
     * @param number The phone number associated with the repair order.
     * @param diagnosticReport The diagnostic report to add.
     */
    public void addDiagnosticReportToOrder(int number, String diagnosticReport) {
        RepairOrder currentRepairOrder = sessionManager.getSearchedOrders(number);
        currentRepairOrder.setDiagnosticReport(diagnosticReport);
    }
    
    /**
     * Adds a repair task to the repair order.
     * This is used in the View to add a specific repair task and its cost.
     * @param number The phone number associated with the repair order.
     * @param taskDescription The description of the task being performed.
     * @param cost The cost of the repair task.
     */    
    public void addRepairTaskToOrder(int number, String taskDescription, double cost) {
        RepairOrder currentRepairOrder = sessionManager.getSearchedOrders(number);
        currentRepairOrder.addRepairTask(taskDescription, cost);
    }

    /**
     * Updates the status of the repair order.
     * This is used in the View to update the status of the repair order after it has been created.
     * @param number The phone number associated with the repair order.
     * @param newStatus The new status for the repair order.
     */
    public void updateRepairOrderStatus(int number, String newStatus) {
        RepairOrder currentRepairOrder = sessionManager.getSearchedOrders(number);
        currentRepairOrder.setStatus(newStatus);
    }

    /**
     * Checks out the customer by printing the details of the repair order and the total cost of the repair.
     * This is used in the View to check out the customer after the repair has been completed.
     * @param number The phone number associated with the repair order.
     */
    public void checkoutCustomer(int number) {
        RepairOrder currentRepairOrder = sessionManager.getSearchedOrders(number);
        printer.printRepairOrderDetails(RepairOrderMapper.toDTO(currentRepairOrder));
        sessionManager.endSession(number);
    }
}

