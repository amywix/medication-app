
package com.example.meditime;

import com.example.meditime.dto.ClientDTO;
import com.example.meditime.dto.ClientMedicationDTO;
import com.example.meditime.model.Client;
import com.example.meditime.service.ClientMedicationService;
import com.example.meditime.service.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class MediTimeApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MediTimeApplication.class, args);
        ClientService clientService = context.getBean(ClientService.class);
        ClientMedicationService medicationService = context.getBean(ClientMedicationService.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MediTime Console ---");
            System.out.println("Select Role:");
            System.out.println("1. Manager");
            System.out.println("2. Carer");
            System.out.println("3. Exit");
            System.out.print("Enter option: ");

            int roleChoice = scanner.nextInt();
            scanner.nextLine();

            switch (roleChoice) {
                case 1 -> runManagerConsole(scanner, clientService, medicationService);
                case 2 -> runCarerConsole(scanner, clientService, medicationService);
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void runManagerConsole(Scanner scanner, ClientService clientService, ClientMedicationService medicationService) {
        while (true) {
            System.out.println("\n--- Manager Menu ---");
            System.out.println("1. Add Client");
            System.out.println("2. List Clients");
            System.out.println("3. Update Client");
            System.out.println("4. Delete Client");
            System.out.println("5. Generate Client Medication Report");
            System.out.println("6. Back to Role Menu");
            System.out.print("Enter option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter client's name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter DOB (yyyy-mm-dd): ");
                    String dob = scanner.nextLine();

                    System.out.print("Enter contact info: ");
                    String contact = scanner.nextLine();

                    ClientDTO dto = new ClientDTO(name, dob, contact);
                    clientService.addClientFromDTO(dto);
                    System.out.println("Client added successfully!");
                }
             case 2 -> {
    System.out.println("\n--- Carer Console ---");

    // Step 1: Show all clients
    List<Client> clients = clientService.getAllClients();
    if (clients.isEmpty()) {
        System.out.println("No clients found.");
        break;
    }

    System.out.println("Select a client:");
    for (Client client : clients) {
        System.out.printf("ID: %d | Name: %s | DOB: %s%n",
                client.getClientId(), client.getName(), client.getDob());
    }

    System.out.print("Enter client ID: ");
    Long selectedClientId = scanner.nextLong();
    scanner.nextLine();

    Optional<Client> selectedClientOpt = clients.stream()
            .filter(c -> c.getClientId().equals(selectedClientId))
            .findFirst();

    if (selectedClientOpt.isEmpty()) {
        System.out.println("Invalid client ID.");
        break;
    }

    Client selectedClient = selectedClientOpt.get();
    System.out.printf("Selected client: %s%n", selectedClient.getName());

    // Step 2: Show carer menu for selected client
    boolean back = false;
    while (!back) {
        System.out.println("\n--- Client Menu ---");
        System.out.println("1. View Medication Schedule");
        System.out.println("2. Mark Medication as Given/Skipped");
        System.out.println("3. Upload Incident Note");
        System.out.println("4. Back to Role Menu");
        System.out.print("Enter option: ");

        int clientMenuChoice = scanner.nextInt();
        scanner.nextLine();

        switch (clientMenuChoice) {
            case 1 -> {
                List<ClientMedicationDTO> meds = medicationService.getClientMedicationDTOs(selectedClient.getClientId());
if (meds.isEmpty()) {
    System.out.println("No medication scheduled for this client.");
} else {
    System.out.println("Medication Schedule:");
    for (ClientMedicationDTO med : meds) {
        System.out.printf("- %s | Dosage: %s | Frequency: %s | Start: %s | End: %s%n",
                med.getMedicationName(), med.getDosage(), med.getFrequency(), med.getStartDate(), med.getEndDate());
    }
}

            }
            case 2 -> {
                System.out.println("mark medication as Given/Skipped.");
            }
            case 3 -> {
                System.out.println("Upload incident note.");
            }
            case 4 -> back = true;
            default -> System.out.println("Invalid option.");
        }
    }
}

                case 3 -> {
                    System.out.print("Enter ID of client to update: ");
                    Long updateId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new DOB (yyyy-mm-dd): ");
                    String newDob = scanner.nextLine();

                    System.out.print("Enter new contact: ");
                    String newContact = scanner.nextLine();

                    ClientDTO dto = new ClientDTO(newName, newDob, newContact);
                    Client updated = clientService.updateClientFromDTO(updateId, dto);
                    if (updated != null) {
                        System.out.println("Client updated.");
                    } else {
                        System.out.println("Client not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter ID of client to delete: ");
                    Long deleteId = scanner.nextLong();
                    scanner.nextLine();

                    boolean deleted = clientService.deleteClientById(deleteId);
                    if (deleted) {
                        System.out.println("✅ Client deleted.");
                    } else {
                        System.out.println("❌ Client not found.");
                    }
                }
                case 5 -> {
                    System.out.print("Enter client ID for report: ");
                    Long clientId = scanner.nextLong();
                    scanner.nextLine();

                    List<ClientMedicationDTO> meds = medicationService.getClientMedicationDTOs(clientId);
                    try (FileWriter writer = new FileWriter("client_medication_report_" + clientId + ".txt")) {
                        for (ClientMedicationDTO med : meds) {
                            writer.write("Medication: " + med.getMedicationName() +
                                         ", Dosage: " + med.getDosage() +
                                         ", Frequency: " + med.getFrequency() +
                                         ", Start: " + med.getStartDate() +
                                         ", End: " + med.getEndDate() + "\n");
                        }
                        System.out.println("Report generated successfully.");
                    } catch (IOException e) {
                        System.out.println("Error writing report: " + e.getMessage());
                    }
                }
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void runCarerConsole(Scanner scanner, ClientService clientService, ClientMedicationService medicationService) {
        while (true) {
            System.out.println("\n--- Carer Menu ---");
            System.out.println("1. View Client Medication Schedule");
            System.out.println("2. Mark Medication as Given or Skipped");
            System.out.println("3. Upload Incident Note");
            System.out.println("4. Back to Role Menu");
            System.out.print("Enter option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter client ID: ");
                    Long clientId = scanner.nextLong();
                    scanner.nextLine();

                    List<ClientMedicationDTO> meds = medicationService.getClientMedicationDTOs(clientId);
                    if (meds.isEmpty()) {
                        System.out.println("No medications found for this client.");
                    } else {
                        for (ClientMedicationDTO med : meds) {
                            System.out.println("Medication: " + med.getMedicationName() +
                                    ", Dosage: " + med.getDosage() +
                                    ", Frequency: " + med.getFrequency() +
                                    ", Start: " + med.getStartDate() +
                                    ", End: " + med.getEndDate());
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Enter medication name to mark: ");
                    String medName = scanner.nextLine();
                    System.out.print("Was it Given or Skipped? (G/S): ");
                    String status = scanner.nextLine().equalsIgnoreCase("G") ? "Given" : "Skipped";
                    System.out.println("Status saved: " + medName + " marked as " + status);
                    // In real implementation, save to medication log in DB
                }
                case 3 -> {
                    System.out.print("Enter client ID: ");
                    Long clientId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Enter incident description: ");
                    String incident = scanner.nextLine();
                    try (FileWriter writer = new FileWriter("incident_log_client_" + clientId + ".txt", true)) {
                        writer.write(LocalDate.now() + " - " + incident + "\n");
                        System.out.println("Incident noted.");
                    } catch (IOException e) {
                        System.out.println("Error writing incident note: " + e.getMessage());
                    }
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
