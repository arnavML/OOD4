package Sem3.model.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    
    // Constructor for the RepairOrderDTO class
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


    // Getters for the fields of the RepairOrderDTO class
    public CustomerDTO getCustomerDTO() { return customerDTO; }
    public BikeDTO getBikeDTO() { return bikeDTO; }
    public int getOrderNumber() { return orderNumber; }
    public String getDescription() { return description; }
    public double getTotalCost() { return totalCost; }
    public String getStatus() { return status; }
    public String getDate() { return date; }
    public String getDiagnosticReport() { return diagnosticReport; }

    // Getter for the list of repair tasks. Unmodifiable
    public List<RepairTaskDTO> getRepairTasks() {
        return Collections.unmodifiableList(repairTasks);
    }

    // Builder class for constructing RepairOrderDTO objects using the builder pattern. It allows for setting the fields of the RepairOrderDTO in a flexible and readable way, and then building the final RepairOrderDTO object with the specified values.
    public static class Builder {
        private CustomerDTO customerDTO;
        private List<RepairTaskDTO> repairTasks;
        private String description;
        private double totalCost;
        private String status;
        private String date;
        private String diagnosticReport;


        public Builder(CustomerDTO customerDTO, List<RepairTaskDTO> repairTasks) {
            this.customerDTO = customerDTO;
            this.repairTasks = repairTasks;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setTotalCost(double totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setDiagnosticReport(String diagnosticReport) {
            this.diagnosticReport = diagnosticReport;
            return this;
        }

        public RepairOrderDTO build() {
            return new RepairOrderDTO(this);
        }
    }

}
