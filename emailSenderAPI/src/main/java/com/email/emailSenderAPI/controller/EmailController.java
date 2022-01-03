package com.email.emailSenderAPI.controller;


import com.email.emailSenderAPI.Model.EmailRequest;
import com.email.emailSenderAPI.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/hello")
    public String method(){
        return "hello I am Aayush Soni";
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) throws MessagingException, IOException {

        System.out.println(request);

        this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
        return ResponseEntity.ok("done.......");
    }

}
