package com.ua.service;

import org.springframework.stereotype.Service;


public interface MailService {
    void sendMail(String email, String text, String subject);
}
