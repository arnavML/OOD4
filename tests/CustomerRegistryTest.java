package tests;

import Sem3.model.domain.*;
import Sem3.integration.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerRegistryTest { // This class contains unit tests for the CustomerRegistry class, which manages a collection of customers in the system. The tests cover adding customers to the registry, finding customers by their unique customer number, and ensuring that the registry correctly handles cases where a customer is not found.

    private CustomerRegistry registry;
    private Customer testCustomer;
    private Bike testBike;

    // This runs before EVERY test, ensuring a completely clean slate.
    @Before
    public void setUp() { // Initializes a new CustomerRegistry and creates a test customer with an associated bike before each test is run. This ensures that each test starts with a known state and does not interfere with other tests.
        registry = new CustomerRegistry();
        testBike = new Bike("Crescent", "Classic", "CR1001", 708123456);
        testCustomer = new Customer("Astrid Lindgren", 708123456, "astrid.l@example.se", testBike);
    }

    @Test
    public void testAddCustomer() { // Tests that adding a customer to the registry correctly increases the number of customers in the registry. It uses the setUp method to create a test customer and then adds that customer to the registry, finally asserting that the registry contains exactly one customer after the addition.
        // Arrange is handled by setUp()
        
        // Act
        registry.addCustomer(testCustomer);
        
        // Assert: Prove the list now contains exactly 1 customer
        assertEquals("Registry should contain 1 customer after adding.", 1, registry.getAllCustomers().size());
    }

    @Test
    public void testFindCustomerByNumber_Success() { // Tests that finding a customer by their unique customer number works correctly when the customer exists in the registry. It uses the setUp method to create a test customer and adds them to the registry, then searches for them by their number and asserts that the correct customer is returned.
        // Arrange
        registry.addCustomer(testCustomer);
        
        // Act: Try to find the customer we just added
        Customer foundCustomer = registry.findCustomerByNumber(708123456);
        
        // Assert: Prove we got the right customer back
        assertNotNull("The returned customer should not be null.", foundCustomer);
        assertEquals("The name of the found customer should match.", "Astrid Lindgren", foundCustomer.getName());
    }

    @Test
    public void testFindCustomerByNumber_NotFound() { // Tests that finding a customer by their unique customer number correctly returns null when the customer does not exist in the registry. It uses the setUp method to create a test customer and adds them to the registry, then searches for a different number and asserts that null is returned.
        // Arrange: We add a customer with number 708123456
        registry.addCustomer(testCustomer);
        
        // Act: Try to search for a completely different number
        Customer foundCustomer = registry.findCustomerByNumber(999999999);
        
        // Assert: Prove the system correctly returns null when it can't find a match
        assertNull("Searching for a non-existent number should return null.", foundCustomer);
    }
}