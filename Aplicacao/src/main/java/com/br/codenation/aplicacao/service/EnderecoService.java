package com.br.codenation.aplicacao.service;

import com.br.codenation.aplicacao.domain.entity.Endereco;

public interface EnderecoService {

    public void addEndereco(Long id, String cep, String rua, int numero, String bairro, String cidade, String pais);

    public Endereco getEnderecoById(Long enderecoId);


}
