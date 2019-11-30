package com.br.codenation.aplicacao.service;

import com.br.codenation.aplicacao.domain.entity.Empresa;
import javassist.NotFoundException;

import java.util.List;


public interface EmpresaService {

    public Empresa addEmpresa(String nome, String documento, int vagas, String site, Long enderecoId);

    public List<Empresa> getEmpresasList();

    public List<Empresa> getEmpresasListByNome(String nome);

    public Empresa getEmpresaById(Long empresaId);

    public void deleteEmpresaById(Long empresaId) throws NotFoundException;

}
