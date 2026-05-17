package Sem4.controller;

import Sem4.controller.SessionManager;
import Sem4.integration.*;
import Sem4.model.domain.*;
import Sem4.model.dto.*;
import Sem4.model.exceptions.CustomerNotFoundException;
import Sem4.model.mapper.*;
import Sem4.model.observer.RepairOrderObserver;
import Sem4.view.Printer;

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
     * @param number The phone number of the customer to search for.
     * @return The DTO containing the customer details.
     * @throws CustomerNotFoundException if the customer is not found in the registry.
     */
    public CustomerDTO search(int number) throws CustomerNotFoundException {
        return CustomerMapper.toDTO(customerRegistry.findCustomerByNumber(number));
    }

    /**
     * Creates a new repair order for the given customer with the provided description, date, and status.
     * @param number The phone number of the customer.
     * @param description The description of the repair needed.
     * @param date The date the repair order is created.
     * @param status The initial status of the repair order.
     */
    public void createRepairOrder(int number, String description, String date, String status) throws CustomerNotFoundException {
        RepairOrder newRepairOrder = new RepairOrder(customerRegistry.findCustomerByNumber(number), description, date, status);
        repairOrderRegistry.addRepairOrder(newRepairOrder);
        sessionManager.startSession(number, newRepairOrder);
    }
    
    /**
     * Adds an observer to the repair order.
     * @param number The phone number associated with the repair order.
     * @param observer The observer to add.
     */
    public void addRepairOrderObserver(int number, RepairOrderObserver observer) {
        RepairOrder currentRepairOrder = sessionManager.getSearchedOrders(number);
        currentRepairOrder.addObserver(observer);
    }

    /**
     * Retrieves the details of a repair order.
     * @param number The phone number associated with the repair order.
     * @return The DTO containing the repair order details.
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

