package com.semprenotas.semprenotas.model;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.*;

class Evento {
    LocalDate due_date;
    HashSet<Usuario> participants;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String title;

    LocalDate creation_date = LocalDate.now();

    @Column(nullable = false)
    String description;

    public Evento(String title, String description, Integer id, LocalDate due_date) {
        this.setTitle(title);
        this.setDescription(description);
        this.setCreationDate();
        this.setId(id);
        this.due_date = due_date;
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

    Boolean addParticipant(Usuario participant) {
        return participants.add(participant);
    }

    Boolean removeParticipant(Usuario participant) {
        return participants.remove(participant);
    }

    private void setCreationDate() {
        this.creation_date = LocalDate.now();
    }

    LocalDate getDueDate() {
        return this.getDueDate();
    }
}