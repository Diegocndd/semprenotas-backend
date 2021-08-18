package com.semprenotas.semprenotas.controller;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.semprenotas.semprenotas.model.*;
import com.semprenotas.semprenotas.repository.UsuarioRepository;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private UsuarioRepository UsuarioRepository;
    
    @CrossOrigin
    @GetMapping
    public @ResponseBody HashSet<Evento> getEventsUser(@RequestParam String token){
        HashSet<Evento> emptyEventos = new HashSet<Evento>();        
        List<Usuario> user = UsuarioRepository.findByToken(token);

        if (user.size() > 0){
            if (user.get(0).getToken().equals(token)) {
                return user.get(0).getCalendar();
            }
        }

        return emptyEventos;
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addUserEvent(@RequestBody ObjectNode objectNode){
        String token = objectNode.get("token").asText();
        List<Usuario> user = UsuarioRepository.findByToken(token);

        JsonNode event = objectNode.get("evento");
        String titleEvent = event.get("title").asText();
        String contentEvent = event.get("description").asText();
        String dateEvento = event.get("date").asText();

        Evento evento = new Evento();
        titleEvent = titleEvent.replaceAll("\"", "");
        contentEvent = contentEvent.replaceAll("\"", "");
        dateEvento = dateEvento.replaceAll("\"", "");

        evento.setDescription(contentEvent);
        evento.setTitle(titleEvent);
        evento.setDateEvent(dateEvento);

        if (user.size() > 0) {
            if (user.get(0).getToken().equals(token)) {
                user.get(0).addEvent(evento);
                UsuarioRepository.save(user.get(0));
                return "Added event";
            }
        }

        return "User undefined";
    }



}
