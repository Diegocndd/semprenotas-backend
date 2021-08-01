package com.semprenotas.semprenotas.repository;

import java.util.List;

import com.semprenotas.semprenotas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    List<Usuario> findByName(String name);
}
