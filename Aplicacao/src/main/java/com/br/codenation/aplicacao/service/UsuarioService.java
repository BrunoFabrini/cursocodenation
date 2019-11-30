package com.br.codenation.aplicacao.service;

import java.math.BigDecimal;

public interface UsuarioService {

    public void addUsuario(Long id, Long empresaId, String nome, String documento, int idade, String login, String senha, BigDecimal salario);
}
