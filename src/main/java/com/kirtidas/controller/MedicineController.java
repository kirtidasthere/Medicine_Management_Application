package com.kirtidas.controller;

import com.kirtidas.entity.Medicine;
import com.kirtidas.services.MedicineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  //how i can handle the request from the client
public class MedicineController {  //sprintboot give functionality of autowire
    @Autowired
    MedicineServices mediService;

    @RequestMapping("/home")    // for the request handiling
    public String showHome()  //function name
    {
        return "index";
    }
    @RequestMapping("/services")
    public String showServices()
    {
        return "services";
    }
    @RequestMapping("/about")
    public String showAboutUs()
    {
        return "about";
    }
    @RequestMapping("/contact")
    public String showContact()
    {
        return "contact";
    }
    @RequestMapping("/addpage")
    public String addPage()
    {
        return "addpage";
    }

    //Why I am taking all the variable from String?
    //--> When data come from my client to the controller it will come in the form of String. that's why I am taking all the variable in the  from of  String
    public String add(ModelMap map, @RequestParam String id,@RequestParam String name,@RequestParam String count,@RequestParam String des)
    {
        // All these variable added in entity class

        Medicine medi=new Medicine();
        medi.setmID(Integer.parseInt(id));
        medi.setmName(name);
        medi.setmCount(Integer.parseInt(count));
        medi.setmDescription(des);

        String status=mediService.add(medi);
        return status;



    }


}
