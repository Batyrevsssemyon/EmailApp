package ru.batsss.email.controller;

import org.springframework.web.bind.annotation.*;
import ru.batsss.email.model.Letter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/emails/{email_id}/letters")
public class LetterController {

    private final List<Letter> letters;

    public LetterController() {
        try {
            String strDate1 = "18.02.2017";
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date1 = formatter.parse(strDate1);

            String strDate2 = "20.02.2017";
            Date date2 = formatter.parse(strDate2);

            Letter l1 = new Letter(1L, 2L, 1L, "Work", "Dear John. I hope you wil get back to work soon. Sincerly Yours Michelle", date1);
            Letter l2 = new Letter(2L, 1L, 2L, "Work", "Dear Michelle. I have read your letter. I will get back to work on next week. Sincerly Yours John", date2);

            letters = List.of(l1, l2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping()
    public List<Letter> getLetters(@PathVariable("email_id") Long emailId) {
        return letters.stream()
                .filter(letter -> letter.recipientId().equals(emailId))
                .toList();
    }
}