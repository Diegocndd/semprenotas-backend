package com.semprenotas.semprenotas.model;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    HashSet<Evento> calendar;

    @Lob
    HashSet<Anotacao> notas = new HashSet<>();

    @Column
    String token;

    public Boolean addAnotacao(Anotacao anotacao) {
        return notas.add(anotacao);
    }

    public Boolean removeAnotacao(Anotacao anotacao) {
        return notas.remove(anotacao);
    }

    public Boolean addEvent(Evento event) {
        return calendar.add(event);
    }

    public Boolean removeEvent(Evento event) {
        return calendar.remove(event);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public HashSet<Anotacao> getNotas() {
        return notas;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public Integer getId() {
        return id;
    }

    public void setNotas(HashSet<Anotacao> notas) {
        this.notas = notas;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}