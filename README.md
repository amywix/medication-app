# 🩺 MediTime – Medication Management System

A Spring Boot + Android powered backend for managing medication, adherence tracking, reminders, and AI-powered safety alerts for clients and carers in a disability support setting.

---

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

