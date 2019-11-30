package com.br.codenation.aplicacao.data;

import com.br.codenation.aplicacao.domain.entity.Endereco;
import lombok.Data;


@Data
public class EmpresaDTO {

    private Long enderecoId;

    private String nome;

    private String documento;

    private int vagas;

    private String site;
}
