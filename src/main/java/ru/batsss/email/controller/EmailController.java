package ru.batsss.email.controller;

import org.springframework.web.bind.annotation.*;
import ru.batsss.email.model.Email;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/emails")
public class EmailController {

    private final List<Email> emails;

    public EmailController() {
        try {
            String strDate1 = "11.10.2012";
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date1 = formatter.parse(strDate1);

            String strDate2 = "07.12.2014";
            Date date2 = formatter.parse(strDate2);

            Email e1 = new Email(1L, "johnasbros@outlook.com", date1, "Potter", "John", true);
            Email e2 = new Email(2L, "michelle132@gmail.com", date2, "Winchester", "Michelle", false);

            emails = List.of(e1, e2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<Email> getEmails() {
        return emails;
    }

    @GetMapping("/{email_id}")
    public Email getEmail(@PathVariable("email_id") Long emailId) {
        return emails.stream()
                .filter(email -> email.id().equals(emailId))
                .findAny()
                .orElse(null);
    }
}