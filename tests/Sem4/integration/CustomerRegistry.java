package Sem4.integration;

import java.util.ArrayList;
import java.util.List;

import Sem4.model.domain.Customer;
import Sem4.model.exceptions.CustomerNotFoundException;
import Sem4.model.exceptions.DatabaseFailureException;

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
     * Searches for a customer. Throws exceptions to simulate errors.
     * @param number The customer number to search for.
     * @return The found customer.
     * @throws CustomerNotFoundException if the customer is not in the list.
     * @throws DatabaseFailureException if a hardcoded fail-trigger number is used.
     */
    public Customer findCustomerByNumber(int number) throws CustomerNotFoundException {

        if (number == 999999999) {
            throw new DatabaseFailureException("CRITICAL: Database connection lost. Unable to query server.");
        }

        for (Customer customer : customers) {
            if (customer.getOrderNumber() == number) {
                return customer;
            }
        }
        
        throw new CustomerNotFoundException("Customer with phone number " + number + " does not exist in the registry.", number);
    }

    /**
     * Returns a copy of the list of all customers in the registry.
     * @return A list of all customers.
     */
    public java.util.List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }
}