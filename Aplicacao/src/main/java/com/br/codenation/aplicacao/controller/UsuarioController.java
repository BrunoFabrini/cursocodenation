package com.br.codenation.aplicacao.controller;

import com.br.codenation.aplicacao.core.Result;
import com.br.codenation.aplicacao.domain.entity.Usuario;
import com.br.codenation.aplicacao.exception.CodenationException;
import com.br.codenation.aplicacao.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl service;

    public Result addUsuario(Long id, Long empresaId, String nome, String documento, int idade, String login, String senha, BigDecimal salario) {

        Result result = new Result();

        try {

            if (service.anyUsuarioByNomeLoginDocumento(nome, login, documento))
                return new Result("Falha ao inserir Usuário. Não é permitido inserir usuários com nome, login e documento já existente na lista!");

            EmpresaController empresaController = new EmpresaController();

//            if (!empresaController.anyEmpresaById(empresaId))
//                return new Result("Falha ao inserir Usuário. Empresa informada não existe!");
//
//            if (empresaController.anyUsuarioInEmpresaById(id, empresaId))
//                return new Result("Falha ao inserir Usuário. Usuário já pertence à Empresa informada!");

            service.addUsuario(id, empresaId, nome, documento, idade, login, senha, salario);
        }
        catch(CodenationException cEx) {
            result = new Result(cEx.getMessage());
        }
        catch(Exception ex) {
            result = new Result(ex.getMessage());
        }

        return result;
    }

    @GetMapping("/get/{id}")
    public Usuario getById(@PathVariable("id") Long id){

        return service.getUsuarioById(id);
    }

    public Result findUsuarios(Long empresaId, String nome, String documento, int idade) {

        Result result = new Result();

        service.findUsuario(empresaId, nome, documento, idade);

        return result;
    }
}
