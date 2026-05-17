package Sem3.integration;

import Sem3.model.domain.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 * The CustomerRegistry class is responsible for managing a collection of customers in the system.
 * It provides methods for adding customers, finding customers by their unique customer number, 
 * and retrieving a list of all customers.
 */
public class CustomerRegistry {

    private List<Customer> customers = new ArrayList<>();

    /**
     * Initializes the customer registry with an empty list of customers.
     */
    public CustomerRegistry() {
        this.customers = new ArrayList<>();
    }

    /**
     * Adds a new customer to the registry by adding them to the list of customers.
     * @param customer The customer to add.
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Searches through the list of customers to find a customer with a matching customer number.
     * If found, it returns the customer; if not, it returns null.
     * @param number The customer number to search for.
     * @return The found customer or null if not found.
     */
    public Customer findCustomerByNumber(int number) {
        for (Customer customer : customers) {
            if (customer.getOrderNumber() == number) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Returns a copy of the list of all customers in the registry.
     * @return A list of all customers.
     */
    public java.util.List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

}
