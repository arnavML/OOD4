package Sem3.Root;

import Sem3.controller.Controller;
import Sem3.integration.CustomerRegistry;
import Sem3.integration.RepairOrderRegistry;
import Sem3.model.domain.Bike;
import Sem3.model.domain.Customer;
import Sem3.view.Printer;
import Sem3.view.Viewer;

public class Main { //The Main class is the entry point of the application. It initializes the necessary components (view, controller, customer registry, repair order registry, and printer) and starts the view to accept user input and perform search for customers and repair orders.
    private static Viewer view;
    private static Controller controller;
    private static CustomerRegistry customerRegistry = new CustomerRegistry();
    private static RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry();
    private static Printer printer = new Printer();

    public static void main(String[] args) { //Boots up the system by initializing the controller and view, and then starts the view to perform search
        controller = new Controller(customerRegistry, repairOrderRegistry, printer);
        view = new Viewer(controller);
        setupMockData() ; // Set up some mock data for testing purposes
        view.start(); // Start the view to accept user input and perform search // Can also start itself in initialization, but this way there have more control over when it starts for future use
    }

    private static void setupMockData() { // Sets up some mock data for testing purposes by adding several customers to the customer registry. Each customer has a unique name, customer number, email, and bike.
        //Customer Data MADE WITH AI

        // Astrid with a classic Swedish Crescent bike
        customerRegistry.addCustomer(new Customer("Astrid Lindgren", 708123456, "astrid.l@example.se", new Bike("Crescent", "Classic", "CR1001", 708123456)));

        // Björn with a classic Swedish Monark bike
        customerRegistry.addCustomer(new Customer("Björn Borg", 723456789, "bjorn.b@tennis.se", new Bike("Monark", "Karin", "MO5522", 723456789)));

        // Zlatan with a mountain bike
        customerRegistry.addCustomer(new Customer("Zlatan Ibrahimovic", 739988776, "zlatan@football.se", new Bike("Trek", "Marlin 8", "TRK909", 739988776)));

        // Alicia with a hybrid commuter bike
        customerRegistry.addCustomer(new Customer("Alicia Vikander", 764554433, "alicia.v@movies.se", new Bike("Specialized", "Sirrus", "SP8871", 764554433)));

        // Tim with a fast Nishiki bike
        customerRegistry.addCustomer(new Customer("Tim Bergling", 701122334, "tim.b@music.se", new Bike("Nishiki", "Pro SLD", "NI4433", 701122334)));
    }

}