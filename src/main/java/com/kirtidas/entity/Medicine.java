// Package declaration for organizing the project structure
package com.kirtidas.entity;
// what we want
// medicine search, insert data


// This class represents a Medicine entity (used for storing and managing medicine-related data)
// OOP Concept Class (blueprint for creating objects)

public class Medicine {
    // OOP Concept Encapsulation
    // Variables (fields) are kept private or public and accessed via getters and setters.
    public int mID;  // Medicine ID - should ideally be private for full encapsulation

    public String mName; // It is similar to design to a database Medicine name (mapped to DB as VARCHAR)

    public int mCount;    // Quantity of medicine available

    public String mDescription;// I am using String because i want to use in databse varchar
                                // Description about the medicine

    // Get and Set to get & set data in variable
    //Java Concept Getters and Setters
    // Used to access and modify private/public fields
    // Follow JavaBeans standard naming
    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }


}
