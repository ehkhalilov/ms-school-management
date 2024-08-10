package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    public void sendEmail(String to, String subject, String body) {
        emailService.sendSimpleEmail(to, subject, body);
    }

    @PostMapping("/attachment")
    public void sendEmailWithAttachment(
            String to, String subject, String body,
            @RequestParam("file") MultipartFile file
    ) {
        emailService.sendEmailWithAttachment(to, subject, body, file);
    }
}
