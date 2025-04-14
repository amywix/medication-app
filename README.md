Current App Functionality Summary
The MediTimeApplication is a Spring Boot application that supports role-based access. I have added a console for testing purposes prior to integrating with the Android Front End:
Role Selection

When the console app launches, users are prompted to select:
•	1. Manager
•	2. Carer
•	3. Exit

Manager Role
	Add Client
	List Clients
	Update Client
	Delete Client
	Add Carer
	View Carers
	Delete Carer
	Assign Medication Schedule to Client
	Generate Adherence Report
	Assign Carer to Client

Carer Role
	View Client Medication Schedule
	Mark Medication as Given or Skipped
	Upload Incident Note

Working databse functions. 


src
└── main
    └── java
        └── com
            └── example
                └── meditime
                    ├── controller
                    │   ├── HomeController.java
                    │   ├── ClientController.java
                    │   ├── ClientMedicationController.java
                    │   ├── AdherenceLogController.java
                    │   ├── MedicationController.java
                    │   ├── UserController.java
                    │   ├── ReportController.java
                    │   └── ReminderController.java
                    │
                    ├── dto
                    │   ├── ClientDTO.java
                    │   ├── ClientMedicationDTO.java
                    │   ├── AdherenceLogDTO.java
                    │   ├── UserDTO.java
                    │   ├── MedicationLogDTO.java
                    │   ├── MedicationInteractionDTO.java
                    │   └── ReportDTO.java
                    │
                    ├── model
                    │   ├── Client.java
                    │   ├── User.java
                    │   ├── Role.java
                    │   ├── Medication.java
                    │   ├── ClientMedication.java
                    │   ├── MedicationSchedule.java
                    │   ├── MedicationLog.java
                    │   ├── MedicationInteraction.java
                    │   ├── AdherenceLog.java
                    │   ├── Report.java
                    │   └── Reminder.java
                    │
                    ├── repository
                    │   ├── ClientRepository.java
                    │   ├── UserRepository.java
                    │   ├── RoleRepository.java
                    │   ├── MedicationRepository.java
                    │   ├── ClientMedicationRepository.java
                    │   ├── MedicationLogRepository.java
                    │   ├── MedicationInteractionRepository.java
                    │   ├── AdherenceLogRepository.java
                    │   ├── ReportRepository.java
                    │   └── ReminderRepository.java
                    │
                    ├── service
                    │   ├── ClientService.java
                    │   ├── UserService.java
                    │   ├── MedicationService.java
                    │   ├── ClientMedicationService.java
                    │   ├── MedicationLogService.java
                    │   ├── MedicationInteractionService.java
                    │   ├── AdherenceLogService.java
                    │   ├── ReportService.java
                    │   └── ReminderService.java
                    │
                    └── MediTimeApplication.java