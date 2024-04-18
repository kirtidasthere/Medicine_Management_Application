package com.kirtidas.Dao;

import com.kirtidas.entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicineDaoImpl implements MedicineDao{

    @Autowired
    JdbcTemplate JdbcTemplate;
    //Spring boot giving me some predefine templates so which can help me to interact with database
    @Override
    public String mAdd(Medicine medi) {
        //String status = "";
        Medicine midi = mSearch(medi.getmID());
        if (midi == null) {
            int rowCount = JdbcTemplate.update("insert into MedicineRecord values('" + medi.getmID() + "','" + medi.getmName() + "','" + medi.getmCount() + "','" + medi.getmDescription() + "')");
            if (rowCount == 1) {
                return "success";
            }
            else
            {
                return "existed";
            }
        }
        else
        {
            return "existed";

        }


    }
    @Override
    public String mDelete(int mid) {
        return null;
    }

    @Override
    public Medicine mSearch(int mid) {
        // we generaly test our application in our database
        //if medicine present in my database we say it is exist otherwise it is not present
        Medicine md;
        List<Medicine> mediList=JdbcTemplate.query("select * from MedicineRecord where ID='"+mid+"'", (rs,rowCount) -> {
            Medicine m=new Medicine();
            m.setmID(Integer.parseInt(rs.getString("ID")));
            m.setmName(rs.getString("NAME"));
            m.setmCount(Integer.parseInt(rs.getString("COUNT")));
            m.setmDescription(rs.getString("DESCREPTION"));
            return m;
        });
        if(mediList.isEmpty()==true)
        {

            md=null;
        }else {

            return md=mediList.get(0);
        }
        return md;
    }


  /*  //repeat
    @Override
    public Medicine mAdd() {
        return null;
    }


    @Override
    public String mDelete() {
        return null;
    }

    @Override
    public Medicine mSearch(int mid) {
        Medicine md;
        return null;
    }

*/
































}
