package com.semprenotas.semprenotas.model;
import java.util.*;
import java.text.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.time.*;

@Entity
public class Evento implements Serializable {
    LocalDate due_date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String dateEvent;

    LocalDate creation_date = LocalDate.now();

    @Column(nullable = false)
    Date eventDate = new Date();

    @Column(nullable = false)
    String description;

    public Evento() {
        Format formatter;
        String s;
        Date date = new Date();

        formatter = new SimpleDateFormat("dd/MM/yyyy");
        s = formatter.format(date);
        this.setDateEvent(s);
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getDate() {
        return this.creation_date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}