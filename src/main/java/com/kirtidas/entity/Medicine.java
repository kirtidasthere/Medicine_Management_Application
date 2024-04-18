package com.kirtidas.entity;
// what we want
// medicine search, insert data
public class Medicine {

    public int mID;
    public String mName; // It is similar to design to a database
    public int mCount;
    public String mDescription;// I am using String because i wnt to use in databse varchar

    // Get and Set to get & set data in variable
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
