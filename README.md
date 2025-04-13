# 🩺 MediTime – Medication Management System

A Spring Boot + Android powered backend for managing medication, adherence tracking, reminders, and AI-powered safety alerts for clients and carers in a disability support setting.

---
Current App Functionality Summary
The MediTimeApplication is a Spring Boot console application that supports role-based access:
Role Selection
When the app launches, users are prompted to select:
•	1. Manager
•	2. Carer
•	3. Exit
Manager Role
Currently supports full client management:
•	Add Client: Name, DOB, and contact info
•	List Clients: Display all clients in the database
•	Update Client: Modify client details by ID
•	Delete Client: Remove client from the database
•	Back: Return to main role selection
Carer Role
Placeholder for now – but will include:
•	View assigned clients
•	View medication schedule
•	Mark medication as Given/Skipped
•	Upload incident notes
•	Get AI-generated reminders

## 📁 Project Structure

MediTime/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── MediTime/
│       │               ├── controller/
│       │               │   ├── AdherenceController.java
│       │               │   ├── ClientController.java
│       │               │   ├── HomeController.java
│       │               │   ├── MedicationController.java
│       │               │   ├── ReminderController.java
│       │               │   ├── ReportController.java
│       │               │   ├── UserController.java
│       │               ├── dto/
│       │               │   ├── ClientDTO.java
│       │               │   ├── UserDTO.java
│       │               ├── model/
│       │               │   ├── AdherenceLog.java
│       │               │   ├── Client.java
│       │               │   ├── ClientMedication.java
│       │               │   ├── Medication.java
│       │               │   ├── MedicationInteraction.java
│       │               │   ├── MedicationLog.java
│       │               │   ├── Reminder.java
│       │               │   ├── Report.java
│       │               │   ├── Role.java
│       │               │   ├── User.java
│       │               ├── repository/
│       │               │   ├── AdherenceLogRepository.java
│       │               │   ├── ClientMedicationRepository.java
│       │               │   ├── ClientRepository.java
│       │               │   ├── MedicationInteractionRepository.java
│       │               │   ├── MedicationLogRepository.java
│       │               │   ├── MedicationRepository.java
│       │               │   ├── ReminderRepository.java
│       │               │   ├── RoleRepository.java
│       │               │   ├── UserRepository.java
│       │               │   ├── ReportRepository.java
│       │               ├── service/
│       │               │   ├── AdherenceLogService.java
								ClientMedicationService.java
│       │               │   ├── ClientService.java
│       │               │   ├── MedicationInteractionService.java
│       │               │   ├── MedicationLogService.java
│       │               │   ├── MedicationService.java
│       │               │   ├── ReminderService.java
│       │               │   ├── ReportService.java
│       │               │   ├── UserService.java
│       │               └── MediTimeApplication.java
│       └── resources/
│           ├── static/
│           │   └── index.html
│           ├── templates/
│           │   └── index.html 
│           ├── application.properties
│           └── data.sql 
├── pom.xml
└── README.md

