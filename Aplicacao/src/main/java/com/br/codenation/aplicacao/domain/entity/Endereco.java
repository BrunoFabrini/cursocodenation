package com.br.codenation.aplicacao.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "address")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "zip_code", nullable = false, length = 255)
    private String cep;

    @Column(name = "street", nullable = false, length = 255)
    private String rua;

    @Column(name = "number")
    private int numero;

    @Column(name = "district", nullable = false, length = 255)
    private String bairro;

    @Column(name = "city", nullable = false, length = 255)
    private String cidade;

    @Column(name = "country", nullable = false, length = 255)
    private String pais;
}
