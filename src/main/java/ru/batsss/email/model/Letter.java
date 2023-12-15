package ru.batsss.email.model;

import java.util.Date;
public record Letter(Long id, Long senderId, Long recipientId, String subject, String text, Date date) {
}