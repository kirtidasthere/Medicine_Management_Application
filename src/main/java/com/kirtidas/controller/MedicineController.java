package com.kirtidas.controller;

import com.kirtidas.entity.Medicine;
import com.kirtidas.services.MedicineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  //how i can handle the request from the client
// Marks this class as a Spring MVC Controller.
// It can handle client requests (typically from a browser).

public class MedicineController {  //spring boot give functionality of autowire

    // OOP Concept Dependency Injection (DI)
    // We use @Autowired to inject the MedicineServices bean.
    // Spring Boot automatically wires it via Inversion of Control (IoC) container.

    @Autowired
    MedicineServices mediService;

    @RequestMapping("/home")  // for the request handiling URL Mapping /home → index.html
    public String showHome()  //function name
    {
        return "index";  // returns view name (index.jsp / index.html)
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
    //--> When data come from my client to the controller it will come in the form of String.
    // that's why I am taking all the variable in the  from of  String

    //  Request Handling for Add Operation
    // This method will be called when the form is submitted (POST or GET depending on form method).

    // @RequestParam Extracts parameters sent from the client (form input).
    // Data from the client is always received as String → that’s why all parameters are String.

    public String add(ModelMap map, @RequestParam String id,@RequestParam String name,@RequestParam String count,@RequestParam String des)
    {
        // All these variable added in entity class

        // Creating a new Medicine object and setting form data into it
        Medicine medi=new Medicine();

        medi.setmID(Integer.parseInt(id));   // String to int conversion
        medi.setmName(name);
        medi.setmCount(Integer.parseInt(count));
        medi.setmDescription(des);

        // Calling service layer to add medicine to DB
        String status=mediService.add(medi);  // service layer abstraction

        // Returning the status view (success/failure/existed)
        return status;



    }


}
