package com.br.codenation.aplicacao.domain.dao;

import com.br.codenation.aplicacao.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM user u where u.username = :username LIMIT 1", nativeQuery = true)
    Usuario findUsuarioByUsername(@Param("username") String username);
}
