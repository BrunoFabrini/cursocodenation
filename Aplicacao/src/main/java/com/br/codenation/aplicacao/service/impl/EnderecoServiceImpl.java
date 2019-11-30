package com.br.codenation.aplicacao.service.impl;

import com.br.codenation.aplicacao.domain.dao.EnderecoDAO;
import com.br.codenation.aplicacao.domain.entity.Endereco;
import com.br.codenation.aplicacao.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    EnderecoDAO enderecoDAO;

    @Override
    @Transactional
    public void addEndereco(Long id, String cep, String rua, int numero, String bairro, String cidade, String pais) {

        Endereco endereco = new Endereco().builder().id(id).cep(cep).rua(rua).numero(numero).bairro(bairro).cidade(cidade).pais(pais).build();
    }

    public Endereco getEnderecoById(Long enderecoId){

        return enderecoDAO.findById(enderecoId).orElse(null);
    }

    public void delete(Long enderecoId){

        enderecoDAO.deleteById(enderecoId);
    }
}
