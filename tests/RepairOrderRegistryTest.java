package tests;

import Sem3.model.domain.*;
import Sem3.integration.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RepairOrderRegistryTest { // This class contains unit tests for the RepairOrderRegistry class, which manages a collection of repair orders in the system.

    private RepairOrderRegistry registry;
    private RepairOrder testOrder;

    // This runs before EVERY test, ensuring a completely clean slate.
    @Before
    public void setUp() { // Initializes a new RepairOrderRegistry and creates a test repair order before each test is run.
        registry = new RepairOrderRegistry();
        testOrder = new RepairOrder(new Customer("Zlatan Ibrahimovic", 739988776, "zlatan@football.se", new Bike("Trek", "Marlin 8", "TRK909", 739988776)), "Routine maintenance", "2024-06-01", "Pending");
    }

    @Test
    public void testAddRepairOrder() { // Tests that adding a repair order to the registry correctly increases the number of repair orders in the registry.
        // Arrange is handled by setUp()
        
        // Act
        registry.addRepairOrder(testOrder);
        
        // Assert: Prove the list now contains exactly 1 repair order
        assertEquals("Registry should contain 1 repair order after adding.", 1, registry.getAllRepairOrders().size());
    }

    @Test
    public void testFindRepairOrderByNumber_Success() { // Tests that finding a repair order by the customer's phone number works correctly when the repair order exists in the registry.
        // Arrange
        registry.addRepairOrder(testOrder);
        
        // Act: Try to find the repair order we just added
        RepairOrder foundOrder = registry.findCustomerByNumber(739988776);
        
        // Assert: Prove we got the right repair order back
        assertNotNull("The returned repair order should not be null.", foundOrder);
        assertEquals("The description of the found repair order should match.", "Routine maintenance", foundOrder.getDescription());
    }

    @Test
    public void testFindRepairOrderByNumber_NotFound() { // Tests that finding a repair order by the customer's phone number correctly returns null when the repair order does not exist in the registry.
        // Arrange: We add a repair order with number 708123456
        registry.addRepairOrder(testOrder);
        
        // Act: Try to search for a completely different number
        RepairOrder foundOrder = registry.findCustomerByNumber(999999999);
        
        // Assert: Prove the system correctly returns null when it can't find a match
        assertNull("Searching for a non-existent number should return null.", foundOrder);
    }
}
