package com.example.meditime;

import com.example.meditime.model.Client;
import com.example.meditime.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MediTimeApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MediTimeApplication.class, args);
        ClientService clientService = context.getBean(ClientService.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MediTime Console ---");
            System.out.println("1. Add Client");
            System.out.println("2. List Clients");
            System.out.println("3. Exit");
            System.out.print("Enter option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter client's name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter DOB (yyyy-mm-dd): ");
                    LocalDate dob = LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter contact info: ");
                    String contact = scanner.nextLine();

                    clientService.addClient(name, dob, contact);
                    System.out.println("Client added successfully!");
                }

                case 2 -> {
                    List<Client> clients = clientService.getAllClients();
                    System.out.println("\n--- Registered Clients ---");
                    for (Client client : clients) {
                        System.out.println("ID: " + client.getClientId() +
                                ", Name: " + client.getName() +
                                ", DOB: " + client.getDob() +
                                ", Contact: " + client.getContactInfo());
                    }
                }

                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
