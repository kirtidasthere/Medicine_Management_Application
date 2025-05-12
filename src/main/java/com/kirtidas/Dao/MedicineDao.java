package com.kirtidas.Dao;

import com.kirtidas.entity.Medicine;

// DAO ---> Data Access Object
// This is an interface that defines database operations for the Medicine entity.
// It helps in separating persistence logic from business logic.

public interface MedicineDao {

    // interface use to achieve abstraction 100%
    // OOP Concept Used Abstraction (100%)
    // Interface hides implementation details.
    // Only method declarations are provided here.
    // Implemented in MedicineDaoImpl class.

    public String mAdd(Medicine medi);  // Add a medicine record to the database

    public String mDelete(int mid);  // Delete a medicine record by its ID

    public Medicine mSearch(int mid);  // Search for a medicine by ID
}
