package com.br.codenation.aplicacao.data;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpresaMediaSalarialDTO {

    private String nome;

    private BigDecimal mediaSalarial;
}
