package com.semprenotas.semprenotas.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.semprenotas.semprenotas.model.*;
import com.semprenotas.semprenotas.repository.UsuarioRepository;

@RestController
@RequestMapping("/anotacao")
public class AnotacaoController {

    @Autowired
    private UsuarioRepository UsuarioRepository;
    
    @CrossOrigin
    @GetMapping
    public @ResponseBody HashSet<Anotacao> getUserNotes(@RequestParam String token){
        HashSet<Anotacao> emptyNotes = new HashSet<Anotacao>();        
        List<Usuario> user = UsuarioRepository.findByToken(token);

        if (user.size() > 0){
            if (user.get(0).getToken().equals(token)) {
                for (Anotacao anotacao : user.get(0).getNotas()) {
                    System.out.println(anotacao.getTitle());
                };
                return user.get(0).getNotas();
            }
        }

        return emptyNotes;
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addUserNote(@RequestBody ObjectNode objectNode){
        String token = objectNode.get("token").asText();
        List<Usuario> user = UsuarioRepository.findByToken(token);

        JsonNode nota = objectNode.get("nota");
        String titleNota = nota.get("title").asText();
        String contentNota = nota.get("description").asText();

        Anotacao anotacao = new Anotacao();
        titleNota = titleNota.replaceAll("\"", "");
        contentNota = contentNota.replaceAll("\"", "");

        anotacao.setTitle(titleNota);
        anotacao.setDescription(contentNota);

        if (user.size() > 0) {
            if (user.get(0).getToken().equals(token)) {
                user.get(0).addAnotacao(anotacao);
                UsuarioRepository.save(user.get(0));
                return "Added note";
            }
        }

        return "User undefined";
    }
}
