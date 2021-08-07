package com.semprenotas.semprenotas.model;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.io.Serializable;
import java.time.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anotacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private LocalDate creation_date = LocalDate.now();

    private String description;

    /*Utilizada uma implementação de HashSet para evitar elementos duplicados*/
    HashSet<String> tags = new HashSet<>();

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

    public Boolean addTag(String tag) {
        return tags.add(tag.toLowerCase());
    }

    public Boolean removeTag(String tag) {
        return tags.remove(tag.toLowerCase());
    }

    public Boolean hasTag(String tag) {
        return tags.contains(tag.toLowerCase());
    }
}