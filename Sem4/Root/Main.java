package Sem4.Root;

import Sem4.controller.Controller;
import Sem4.integration.CustomerRegistry;
import Sem4.integration.RepairOrderRegistry;
import Sem4.model.domain.Bike;
import Sem4.model.domain.Customer;
import Sem4.view.Printer;
import Sem4.view.Viewer;

/**
 * The Main class is the entry point of the application. It initializes the necessary components (view, controller, customer registry, repair order registry, and printer) and starts the view to accept user input and perform search for customers and repair orders.
 */
public class Main {
    private static Viewer view;
    private static Controller controller;
    private static CustomerRegistry customerRegistry = new CustomerRegistry();
    private static RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();
    private static Printer printer = new Printer();

    /**
     * The main method is the entry point of the application.
     */
    public static void main(String[] args) {
        controller = new Controller(customerRegistry, repairOrderRegistry, printer);
        view = new Viewer(controller);
        setupMockData();
        view.start();
    }

    /**
     * Sets up some mock data for testing purposes by adding several customers to the customer registry. Each customer has a unique name, customer number, email, and bike.
     * Customer Data MADE WITH AI
     */
    private static void setupMockData() {
        customerRegistry.addCustomer(new Customer("Astrid Lindgren", 708123456, "astrid.l@example.se", new Bike("Crescent", "Classic", "CR1001", 708123456)));

        customerRegistry.addCustomer(new Customer("Björn Borg", 723456789, "bjorn.b@tennis.se", new Bike("Monark", "Karin", "MO5522", 723456789)));

        customerRegistry.addCustomer(new Customer("Zlatan Ibrahimovic", 739988776, "zlatan@football.se", new Bike("Trek", "Marlin 8", "TRK909", 739988776)));

        customerRegistry.addCustomer(new Customer("Alicia Vikander", 764554433, "alicia.v@movies.se", new Bike("Specialized", "Sirrus", "SP8871", 764554433)));

        customerRegistry.addCustomer(new Customer("Tim Bergling", 701122334, "tim.b@music.se", new Bike("Nishiki", "Pro SLD", "NI4433", 701122334)));
    }

}