// Package declaration defines the folder structure and namespace of the application
package com.kirtidas;

// Importing the required Spring Boot classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This annotation marks the class as the entry point for a Spring Boot application
@SpringBootApplication
public class MedicineManagementApplication {

	// This is the main method the starting point of any Java application
	public static void main(String[] args) {
		// SpringApplication.run() bootstraps the application, starting up or initializing the application
		// starts Spring, and auto-configures the project
		SpringApplication.run(MedicineManagementApplication.class, args);
	}

}


/*

Client (Browser / HTML Form)   MedicineManagementApplication
	 Medicine (entity)
        ↓
Controller (MedicineController)
        ↓
Service Layer (MedicineServices)
        ↓
DAO Layer (MedicineDaoImpl)
        ↓
Database (via JdbcTemplate)

 */