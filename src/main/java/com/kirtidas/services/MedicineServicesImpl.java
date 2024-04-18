package com.kirtidas.services;

import com.kirtidas.Dao.MedicineDao;
import com.kirtidas.entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineServicesImpl implements MedicineServices
{
    @Autowired //Autowired Annotation It help me to give a object of implementation class
    MedicineDao mediDao;
    @Override
    public String add(Medicine medi) {
        String status=mediDao.mAdd(medi);
        return status;
    }

    @Override
    public String Search() {
        return null;
    }

    @Override
    public String Delete() {
        return null;
    }
}
