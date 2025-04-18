package com.example.meditime;

import com.example.meditime.model.Role;
import com.example.meditime.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MediTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediTimeApplication.class, args);
    }

    // ✅ Seed roles on startup
    @Bean
    public ApplicationRunner seedRoles(@Autowired RoleRepository roleRepository) {
        return args -> {
            createRoleIfNotExists(roleRepository, "Manager");
            createRoleIfNotExists(roleRepository, "Carer");
        };
    }

    private void createRoleIfNotExists(RoleRepository roleRepository, String roleName) {
        if (roleRepository.findByRoleName(roleName).isEmpty()) {
            Role role = new Role();
            role.setRoleName(roleName);
            roleRepository.save(role);
            System.out.println("Created role: " + roleName);
        }
    }
}


/*// Amy Wickham 12178502
// File: MediTimeApplication.java


package com.example.meditime;

import com.example.meditime.dto.ClientDTO;
import com.example.meditime.dto.ClientMedicationDTO;
import com.example.meditime.model.Client;
import com.example.meditime.model.Role;
import com.example.meditime.repository.RoleRepository;
import com.example.meditime.service.*;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class MediTimeApplication {

    public static void main(String[] args) {
        // Initialize Spring Boot application 
        ApplicationContext context = SpringApplication.run(MediTimeApplication.class, args);

        // Service instances 
        ClientService clientService = context.getBean(ClientService.class);
        ClientMedicationService clientMedicationService = context.getBean(ClientMedicationService.class);
        UserService userService = context.getBean(UserService.class);
        MedicationInteractionService medicationInteractionService = context.getBean(MedicationInteractionService.class);
        MedicationService medicationService = context.getBean(MedicationService.class);
        MedicationLogService medicationLogService = context.getBean(MedicationLogService.class);
RoleRepository roleRepository = context.getBean(RoleRepository.class);
  initializeRoles(roleRepository);
        Scanner scanner = new Scanner(System.in);

        // Main menu
        while (true) {
            System.out.println("\n--- MediTime Console ---");
            System.out.println("Select Role:");
            System.out.println("1. Manager");
            System.out.println("2. Carer");
            System.out.println("3. Exit");
            System.out.print("Enter option: ");

            int roleChoice;
            try {
                roleChoice = scanner.nextInt();  // Read user input
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();  

            //  select role
            switch (roleChoice) {
                case 1 -> runManagerConsole(scanner, clientService, clientMedicationService, userService, medicationInteractionService, medicationLogService);
                case 2 -> runCarerConsole(scanner, clientService, clientMedicationService, medicationLogService);
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    private static void initializeRoles(RoleRepository roleRepository) {
        createRoleIfNotExists(roleRepository, "Manager");
        createRoleIfNotExists(roleRepository, "Carer");
    }

    private static void createRoleIfNotExists(RoleRepository roleRepository, String roleName) {
        if (roleRepository.findByRoleName(roleName).isEmpty()) {
            Role role = new Role();
            role.setRoleName(roleName);
            roleRepository.save(role);
            System.out.println("Created role: " + roleName);
        }
    }

    // Manager functions
    private static void runManagerConsole(Scanner scanner,
                                          ClientService clientService,
                                          ClientMedicationService clientMedicationService,
                                          UserService userService,
                                          MedicationInteractionService medicationInteractionService,
                                          MedicationLogService medicationLogService) {

        while (true) {
            System.out.println("\n--- Manager Menu ---");
            System.out.println("1. Add Client");
            System.out.println("2. List Clients");
            System.out.println("3. Update Client");
            System.out.println("4. Delete Client");
            System.out.println("5. Add Carer");
            System.out.println("6. View Carers");
            System.out.println("7. Delete Carer");
            System.out.println("8. Assign Medication Schedule to Client");
            System.out.println("9. Generate Adherence Report");
            System.out.println("10. Assign Carer to Client");
            System.out.println("11. Back to Role Menu");
            System.out.print("Enter option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
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
                case 2 -> clientService.getAllClients().forEach(c ->
                        System.out.println("ID: " + c.getClientId() + " | Name: " + c.getName()));
                case 3 -> {
                    System.out.print("Enter ID of client to update: ");
                    Long id = scanner.nextLong(); scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new DOB (yyyy-mm-dd): ");
                    String dob = scanner.nextLine();
                    System.out.print("Enter new contact: ");
                    String contact = scanner.nextLine();
                    Client updated = clientService.updateClientFromDTO(id, new ClientDTO(name, dob, contact));
                    System.out.println(updated != null ? "Client updated." : "Client not found.");
                }
                case 4 -> {
                    System.out.print("Enter ID of client to delete: ");
                    Long id = scanner.nextLong(); scanner.nextLine();
                    boolean result = clientService.deleteClientById(id);
                    System.out.println(result ? "Client deleted." : "Client not found.");
                }
                case 5 -> {
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    userService.addUser(name, email, password, "Carer");
                    System.out.println("Carer added.");
                }
               case 6 -> userService.getUsersByRole("Carer")
    .forEach(c -> System.out.println("ID: " + c.getUserId() + " | Name: " + c.getName()));

                case 7 -> {
                    System.out.print("Enter carer ID to delete: ");
                    Long id = scanner.nextLong(); scanner.nextLine();
                    boolean result = userService.deleteUserById(id);
                    System.out.println(result ? "Carer deleted." : "Carer not found.");
                }
                case 8 -> {
                    System.out.print("Client ID: ");
                    Long clientId = scanner.nextLong(); scanner.nextLine();
                    System.out.print("Medication ID: ");
                    Long medicationId = scanner.nextLong(); scanner.nextLine();

                    boolean interaction = medicationInteractionService.checkInteractions(clientId, medicationId);
                    if (interaction) {
                        System.out.println("WARNING: Drug interaction detected!");
                    }

                    System.out.print("Dosage: ");
                    String dosage = scanner.nextLine();
                    System.out.print("Frequency: ");
                    String frequency = scanner.nextLine();
                    System.out.print("Start Date (yyyy-mm-dd): ");
                    String start = scanner.nextLine();
                    System.out.print("End Date (yyyy-mm-dd): ");
                    String end = scanner.nextLine();

                    ClientMedicationDTO dto = new ClientMedicationDTO();
                    dto.setClientId(clientId);
                    dto.setMedicationId(medicationId);
                    dto.setDosage(dosage);
                    dto.setFrequency(frequency);
                    dto.setStartDate(LocalDate.parse(start));
                    dto.setEndDate(LocalDate.parse(end));
                    clientMedicationService.assignMedication(dto);
                    System.out.println("Medication assigned.");
                }
                case 9 -> {
                    System.out.print("Client ID for adherence report: ");
                    Long id = scanner.nextLong(); scanner.nextLine();
                    double rate = clientMedicationService.calculateAdherenceRate(id);
                    System.out.printf("Adherence Rate: %.2f%%\n", rate);
                }
                case 10 -> {
                    System.out.print("Enter Client ID: ");
                    Long clientId = scanner.nextLong(); scanner.nextLine();
                    System.out.print("Enter Carer ID: ");
                    Long carerId = scanner.nextLong(); scanner.nextLine();
                    boolean result = clientService.assignCarerToClient(clientId, carerId);
                    System.out.println(result ? "Carer assigned to client." : "Failed to assign carer.");
                }
                case 11 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

   //care functions
    private static void runCarerConsole(Scanner scanner,
                                        ClientService clientService,
                                        ClientMedicationService medicationService,
                                        MedicationLogService logService) {

        while (true) {
            System.out.println("\n--- Carer Menu ---");
            System.out.println("1. View Client Medication Schedule");
            System.out.println("2. Mark Medication as Given or Skipped");
            System.out.println("3. Upload Incident Note");
            System.out.println("4. Back to Role Menu");
            System.out.print("Enter option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();  

            switch (choice) {
              //view client medication scheudle
                case 1 -> {
                    System.out.print("Enter client ID: ");
                    Long clientId = scanner.nextLong(); scanner.nextLine();

                    List<ClientMedicationDTO> meds = medicationService.getClientMedicationDTOs(clientId);
                    if (meds.isEmpty()) {
                        System.out.println("No medications found for this client.");
                    } else {
                        meds.forEach(med ->
                                System.out.printf("Medication: %s | Dosage: %s | Frequency: %s | Start: %s | End: %s%n",
                                        med.getMedicationName(), med.getDosage(), med.getFrequency(),
                                        med.getStartDate(), med.getEndDate()));
                    }
                }
                // mark meidcation as given or skipped 
                case 2 -> {
                    System.out.print("Enter client ID: ");
                    Long clientId = scanner.nextLong(); scanner.nextLine();
                    System.out.print("Enter medication name to mark: ");
                    String medName = scanner.nextLine();
                    System.out.print("Was it Given or Skipped? (G/S): ");
                    String status = scanner.nextLine().equalsIgnoreCase("G") ? "Given" : "Skipped";
                    logService.logMedicationStatus(clientId, medName, status);
                    System.out.println("Status saved.");
                }
                case 3 -> {
                    System.out.print("Enter client ID: ");
                    Long clientId = scanner.nextLong(); scanner.nextLine();
                    System.out.print("Enter incident description: ");
                    String incident = scanner.nextLine();

                    try (var writer = new java.io.FileWriter("incident_log_client_" + clientId + ".txt", true)) {
                        writer.write(LocalDate.now() + " - " + incident + "\n");
                        System.out.println("Incident noted.");
                    } catch (Exception e) {
                        System.out.println("Error writing incident: " + e.getMessage());
                    }
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
                
}
*/