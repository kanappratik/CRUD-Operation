package com.first.Crud.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;  // Corrected import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.first.Crud.DAO.CrudRepo;
import com.first.Crud.Entity.CrudOP;
import com.first.Crud.Service.Opration;

@Controller
public class Crudoperation {

    @Autowired
    private CrudRepo repo;

    // Get mapping to display the form
    @GetMapping("/")
    public String crudoprt() {
        return "index";  // Display the form to add users
    }

    // Post mapping to handle form submissions and save the user data
    @PostMapping("/submit")
    public String op(CrudOP cp) {
        repo.save(cp);  // Save the user data to the database
        return "redirect:/list";  // Redirect to the form page after saving
    }

    // Get mapping to display the list of all users
    @GetMapping("/list")
    public String showList(Model model) {
        // Fetch the list of all users from the database
        List<CrudOP> users = repo.findAll();

        // Add the list of users to the model so it can be accessed in the view
        model.addAttribute("users", users);  // Fixed typo here (changed addAttribu to addAttribute)

        // Return the name of the view (HTML file) to display the list
        return "ShowData";  // Refers to the "list.html" view to display the users
    }
    
    // Delete method
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        // Call the service to delete the user by ID
        repo.deleteById(id);
        // Redirect to the list of users after deletion
        return "redirect:/list";
    }
    @GetMapping("/update/{id}")
    	public String updatedata(@PathVariable("id")long id) {
    		repo.findById(id);
    		return "update";
    	}
    
}

