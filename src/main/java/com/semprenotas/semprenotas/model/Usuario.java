package com.semprenotas.semprenotas.model;
import java.util.*;
import java.time.*;

class Usuario {
    Integer id;
    String name;
    String password;
    HashSet<Evento> calendar;
    HashSet<Anotacao> notas;

    Usuario(Integer id, String name, String password) {
        this.id = id;
        setName(name);
        setPassword(password);
    }

    Boolean addAnotacao(Anotacao anotacao) {
        return notas.add(anotacao);
    }

    Boolean removeAnotacao(Anotacao anotacao) {
        return notas.remove(anotacao);
    }

    Boolean addEvent(Evento event) {
        return calendar.add(event);
    }

    Boolean removeEvent(Evento event) {
        return calendar.remove(event);
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setPassword(String password) {
        this.password = password;
    }

    String getPassword() {
        return this.password;
    }

}