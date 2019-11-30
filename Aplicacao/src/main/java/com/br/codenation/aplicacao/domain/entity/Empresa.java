package com.br.codenation.aplicacao.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "company")
public class Empresa{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Endereco endereco;

	@Column(name = "name", nullable = false, length = 255)
	private String nome;

	@Column(name = "document", nullable = false, length = 255)
	private String documento;

	@Column(name = "vacancies")
	private int vagas;

	@Column(name = "site", nullable = false, length = 255)
	private String site;

//	private int idade;

	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Usuario> usuariosList;
}
