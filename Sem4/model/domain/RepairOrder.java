package Sem4.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Sem4.model.domain.Bike;
import Sem4.model.domain.Customer;
import Sem4.model.domain.RepairTask;
import Sem4.model.mapper.RepairOrderMapper;
import Sem4.model.observer.RepairOrderObserver;

/**
 * The RepairOrder class represents a repair order for a customer's bike.
 * It contains information about the customer, the bike, the description of the repair, 
 * the date of the order, the status of the order, a diagnostic report, and a list 
 * of repair tasks associated with the order.
 */
public class RepairOrder {
    private Customer customer;
    private Bike bike;
    private int orderNumber;
    private String description;
    private String status;
    private String date;
    private String diagnosticReport;
    private List<RepairTask> repairTasks = new ArrayList<>();
    private List<RepairOrderObserver> observers = new ArrayList<>();

    /**
    * Constructs a new RepairOrder with the specified customer, description, date, and status.
    * The bike and order number are derived from the customer.
    * @param customer The customer associated with the repair order.
    * @param description A description of the repair needed.
    * @param date The date the repair order was created.
    * @param status The initial status of the repair order.
    */
    public RepairOrder(Customer customer, String description, String date, String status) {
        this.customer = customer;
        this.bike = customer.getBike();
        this.orderNumber = customer.getOrderNumber();
        this.description = description;
        this.date = date;
        this.status = status;
    }

    /**
     * Adds an observer to the list of observers.
     * @param observer The observer to add.
     */
    public void addObserver(RepairOrderObserver observer) {
        observers.add(observer);
    }

    /**
     * notifies all registered observers of a change to the repair order by sending them an updated DTO.
     */
    private void notifyObservers() {
        for (RepairOrderObserver obs : observers) {
            obs.repairOrderUpdated(RepairOrderMapper.toDTO(this));
        }
    }

    /** @return The customer associated with the order. */
    public Customer getCustomer() { return customer; }

    /** @return The bike associated with the order. */
    public Bike getBike() { return bike; }
    
    /** @return The unique order number for the repair order. */
    public int getOrderNumber() { return orderNumber; }
    
    /** @return The description of the repair needed. */
    public String getDescription() { return description; }
    
    /** @return The current status of the repair order. */
    public String getStatus() { return status; }
    
    /** @return The date the repair order was created. */
    public String getDate() { return date; }
    
    /** @return The diagnostic report for the repair order. */
    public String getDiagnosticReport() { return diagnosticReport; }
    
    /** @return An unmodifiable list of repair tasks associated with the order. */
    public List<RepairTask> getRepairTasks() { return Collections.unmodifiableList(repairTasks); }




    /** @param customer The customer to set for the order. */
    public void setCustomer(Customer customer) { this.customer = customer; }
    
    /** @param bike The bike to set for the order. */
    public void setBike(Bike bike) { this.bike = bike; }
    
    /** @param orderNumber The order number to set for the order. */
    public void setOrderNumber(int orderNumber) { this.orderNumber = orderNumber; }
    
    /** @param description The description to set for the order. */
    public void setDescription(String description) { this.description = description; }
    
    /** @param status The status to set for the order. */
    public void setStatus(String status) { 
        this.status = status; 
        notifyObservers();
    }
    
    /** @param date The date to set for the order. */
    public void setDate(String date) { this.date = date; }
    
    /** @param diagnosticReport The diagnostic report to set for the order. */
    public void setDiagnosticReport(String diagnosticReport) { 
        this.diagnosticReport = diagnosticReport; 
        notifyObservers();
    }

    /**
     * Calculates and returns the total cost of the repair order by summing up 
     * the costs of all associated repair tasks.
     * @return The calculated total cost.
     */
    public double getTotalCost() {
        double totalCost = 0.0;
        for (RepairTask task : repairTasks) {
            totalCost += task.getCost();
        }
        return totalCost;
    }

    /**
    * Adds a new repair task to the order and notifies observers of the change.
    * @param taskDescription The description of the repair task.
    * @param cost The cost of the repair task.
    */
    public void addRepairTask(String taskDescription, Double cost) {
        repairTasks.add(new RepairTask(taskDescription, cost));
        notifyObservers();
    }

}