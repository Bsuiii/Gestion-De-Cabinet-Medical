package com.example.MonCabinetMedicale.controllers;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.MonCabinetMedicale.services.EmailService;


@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;
    
    private int codeVerification;

    
    @PostMapping("/send-email")
    public String sendEmail(@RequestParam String email) {
        try {System.err.println("email verification sender :"+email);
        	
        Random random = new Random();
        int code= random.nextInt(10000); 
            codeVerification = code;
            System.err.println("Generated Code :"+code);
            emailService.sendSimpleMessage(email, "Code De Verification", "Your Code is: " + code);
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return e.getMessage();
        }
       return "redirect:/home";
    }
    
    @GetMapping("/VerifierCode")
    @ResponseBody
    public boolean verifyCode(@RequestParam int code) {
        return code == codeVerification;
    }
}
