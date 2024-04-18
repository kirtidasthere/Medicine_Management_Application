package com.kirtidas.Dao;

import com.kirtidas.entity.Medicine;
//Dao--> Data acces object
public interface MedicineDao {  // interface use to achieve abstraction 100%

    public String mAdd(Medicine medi);
    public String mDelete(int mid);
    public Medicine mSearch(int mid);
}
