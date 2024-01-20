package com.example.EmployeeManagementWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.example.EmployeeManagementWeb.model.Contact;
//import com.example.EmployeeManagementWeb.model.ContactForm;
//import com.example.EmployeeManagementWeb.model.ContactRepository;
//
//@Controller
//@RequestMapping("/contact")
//public class ContactController {
//
//    @Autowired
//    private ContactRepository contactRepository;
//
//    @GetMapping
//    public String showContactForm(ContactForm contactForm) {
//        return "contact-form";
//    }
//
//    @PostMapping("/submit")
//    public String submitContactForm(ContactForm contactForm, Model model) {
//        // Convert ContactForm to Contact entity
//        Contact contact = contactForm.toContactEntity();
//
//        // Save the contact to the database
//        contactRepository.save(contact);
//
//        // Redirect to a thank you page or any other desired page
//        return "redirect:/thankyou";
//    }
//}


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.EmployeeManagementWeb.model.Contact;
//import com.example.EmployeeManagementWeb.repository.ContactRepository;

//@Controller
//public class ContactController {
//
//    @Autowired
//    private ContactRepository contactRepository;
//
//    @GetMapping("/contact")
//    public String showContactForm(Model model) {
//        model.addAttribute("contactForm", new Contact());
//        return "contact-form";
//    }

//    @PostMapping("/contact/submit")
//    public String submitContactForm(Contact contact) {
//        contactRepository.save(contact);
//        return "redirect:/contact/thankyou";
//    }
//}
