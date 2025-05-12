package com.kirtidas.Dao;

// Importing the Medicine entity and required Spring & JDBC classes
import com.kirtidas.entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//Spring Annotation @Repository
// This marks the class as a DAO component that will be automatically scanned and managed by Spring

@Repository
public class MedicineDaoImpl implements MedicineDao{

    //  Dependency Injection @Autowired
    // JdbcTemplate is automatically injected by Spring Boot.
    // JdbcTemplate simplifies database operations like insert, update, select, etc.

    @Autowired
    JdbcTemplate JdbcTemplate;
    //Spring boot giving me some predefine templates so which can help me to interact with database
    //  Method mAdd() - Adds a new medicine to the database
    // Concept Conditional insert based on whether the medicine already exists or not

    @Override
    public String mAdd(Medicine medi) {

        // Step 1: Check if medicine already exists
        //String status = "";
        Medicine midi = mSearch(medi.getmID());

        // Step 2: If not present, insert it into DB
        if (midi == null) {

            // SQL INSERT operation using JdbcTemplate
            int rowCount = JdbcTemplate.update("insert into MedicineRecord values('" + medi.getmID() + "','" + medi.getmName() + "','" + medi.getmCount() + "','" + medi.getmDescription() + "')");

            // Step 3: Return status based on insertion result
            if (rowCount == 1) {
                return "success"; // insert success
            }
            else
            {
                return "existed"; // insert failed
            }
        }
        else
        {
            return "existed";  // already exists, do not insert

        }


    }

    // Method mDelete() Not implemented yet (returns null)
    @Override
    public String mDelete(int mid) {
        return null;
    }

    // Method mSearch()  Searches for a medicine by ID
    // Concept Uses JdbcTemplate.query() with Lambda RowMapper
    @Override
    public Medicine mSearch(int mid) {
        // we generaly test our application in our database
        //if medicine present in my database we say it is exist otherwise it is not present

        Medicine md;

        // Executes SELECT query and maps each row to a Medicine object
        List<Medicine> mediList=JdbcTemplate.query("select * from MedicineRecord where ID='"+mid+"'", (rs,rowCount) -> {
            Medicine m=new Medicine();
            m.setmID(Integer.parseInt(rs.getString("ID")));
            m.setmName(rs.getString("NAME"));
            m.setmCount(Integer.parseInt(rs.getString("COUNT")));
            m.setmDescription(rs.getString("DESCREPTION"));
            return m;
        });

        // Check if list is empty → medicine not found
        if(mediList.isEmpty()==true)
        {

            md=null;
        }else {

            return md=mediList.get(0);  // return the first matching result
        }
        return md;
    }
}






