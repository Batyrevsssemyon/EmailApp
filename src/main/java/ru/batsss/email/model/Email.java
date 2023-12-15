package ru.batsss.email.model;

import java.util.Date;
public record Email(Long id, String adress, Date creationDate, String surname, String name, boolean corporative) {
}