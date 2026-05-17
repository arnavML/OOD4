package Sem4.model.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Sem4.model.dto.BikeDTO;
import Sem4.model.dto.CustomerDTO;
import Sem4.model.dto.RepairOrderDTO;
import Sem4.model.dto.RepairTaskDTO;

/**
 * A Data Transfer Object (DTO) for representing the details of a repair order in the bike repair system.
 * It contains properties for the customer information (as a CustomerDTO), bike information (as a BikeDTO),
 * order number, description of the repair, total cost, status, date, diagnostic report, and a list of 
 * repair tasks associated with the order. This DTO is used to transfer repair order data between different
 * layers of the application without exposing the internal domain models.
 */
public class RepairOrderDTO {
    private CustomerDTO customerDTO;
    private BikeDTO bikeDTO;
    private int orderNumber;
    private String description;
    private double totalCost; //new so we have total
    private String status;
    private String date;
    private String diagnosticReport;
    private List<RepairTaskDTO> repairTasks = new ArrayList<>();
    
    /**
     * Constructs a new RepairOrderDTO using the provided Builder.
     * @param builder The Builder containing the details for constructing the RepairOrderDTO.
     */
    public RepairOrderDTO(Builder builder) {
        this.customerDTO = builder.customerDTO;
        this.bikeDTO = builder.customerDTO.getBikeDTO();
        this.orderNumber = builder.customerDTO.getOrderNumber();
        this.repairTasks = builder.repairTasks;
        this.description = builder.description;
        this.totalCost = builder.totalCost;
        this.status = builder.status;
        this.date = builder.date;
        this.diagnosticReport = builder.diagnosticReport;
    }


    /** @return The CustomerDTO representing the customer associated with the repair order.*/
    public CustomerDTO getCustomerDTO() { return customerDTO; }
    /** @return The BikeDTO representing the bike associated with the repair order.*/
    public BikeDTO getBikeDTO() { return bikeDTO; }
    /** @return The order number of the repair order.*/
    public int getOrderNumber() { return orderNumber; }
    /** @return The description of the repair.*/
    public String getDescription() { return description; }
    /** @return The total cost of the repair.*/
    public double getTotalCost() { return totalCost; }
    /** @return The status of the repair order.*/
    public String getStatus() { return status; }
    /** @return The date of the repair order.*/
    public String getDate() { return date; }
    /** @return The diagnostic report for the repair order.*/
    public String getDiagnosticReport() { return diagnosticReport; }

    /** @return An unmodifiable list of RepairTaskDTOs representing the repair tasks associated with the order. */
    public List<RepairTaskDTO> getRepairTasks() {
        return Collections.unmodifiableList(repairTasks);
    }

    /**
     * A builder for constructing RepairOrderDTO objects.
     */
    public static class Builder {
        private CustomerDTO customerDTO;
        private List<RepairTaskDTO> repairTasks;
        private String description;
        private double totalCost;
        private String status;
        private String date;
        private String diagnosticReport;

        /**
         * Constructs a new Builder with the required customer information and repair tasks.
         * @param customerDTO The CustomerDTO representing the customer associated with the repair order.
         * @param repairTasks The list of RepairTaskDTOs representing the repair tasks for the order.
         */
        public Builder(CustomerDTO customerDTO, List<RepairTaskDTO> repairTasks) {
            this.customerDTO = customerDTO;
            this.repairTasks = repairTasks;
        }

        /**
         * Sets the description for the repair order.
         * @param description The description to set.
         * @return The Builder instance for method chaining.
        */
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Sets the total cost for the repair order.
         * @param totalCost The total cost to set.
         * @return The Builder instance for method chaining.
         */
        public Builder setTotalCost(double totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        /**
         * Sets the status for the repair order.
         * @param status The status to set.
         * @return The Builder instance for method chaining.
         */
        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        /**
         * Sets the date for the repair order.
         * @param date The date to set.
         * @return The Builder instance for method chaining.
         */
        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        /**
         * Sets the diagnostic report for the repair order.
         * @param diagnosticReport The diagnostic report to set.
         * @return The Builder instance for method chaining.
         */
        public Builder setDiagnosticReport(String diagnosticReport) {
            this.diagnosticReport = diagnosticReport;
            return this;
        }

        /**
         * Builds the RepairOrderDTO object with the specified values.
         * @return The constructed RepairOrderDTO object.
         */
        public RepairOrderDTO build() {
            return new RepairOrderDTO(this);
        }
    }

}
