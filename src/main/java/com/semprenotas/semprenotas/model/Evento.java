package com.semprenotas.semprenotas.model;
import java.util.*;
import java.time.*;

class Evento extends Nota {
    LocalDate due_date;
    HashSet<Usuario> participants;

    Evento(String title, String description, Integer id, LocalDate due_date) {
        super.setTitle(title);
        super.setDescription(description);
        this.setCreationDate();
        super.setId(id);
        this.due_date = due_date;
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