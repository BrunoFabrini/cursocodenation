package com.br.codenation.aplicacao.domain.entity;

import com.br.codenation.aplicacao.annotation.ColumnAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Endereco endereco;

	@Column(name = "name", nullable = false, length = 255)
	private String nome;

	@Column(name = "document", nullable = false, length = 255)
	private String documento;

	@Column(name = "age")
	private int idade;

	@Column(name = "username", nullable = false, length = 255)
	private String username;

	@Column(name = "password", nullable = false, length = 255)
	private String senha;

	@ColumnAnnotation(position = 2, text = "My company is")
	@ManyToOne
	@JoinColumn(name = "company_id")
	@Null
	private Empresa empresa;

	@Column(name = "salary")
	private BigDecimal salario;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)

	private List<Role> roles;

	public String getSenha() {

		return senha;
	}

	public void setSenha(String senha) {
		this.senha = criptografarSenha(senha);
	}

	public Usuario(Usuario usuario){

		super();
		this.nome = usuario.getNome();
		this.username = usuario.getUsername();
		this.senha = usuario.getSenha();
		this.idade = usuario.getIdade();
		this.documento = usuario.getDocumento();
		this.roles = usuario.getRoles();
	}

	private String criptografarSenha(String senha){

		//Alterar “u” para = “#0P”
		//Alterar “s” para = “[%0”
		//Alterar “e” para = “lD7”
		//Alterar “r” para = “çA=“

		return senha.replace("u","#0P").replace("s","[%0").
						replace("e","lD7").replace("r","çA=");
	}

	private String descriptografarSenha(String senha){

		//Alterar “#0P” para = “u”
		//Alterar “[%0” para = “s”
		//Alterar “lD7” para = “e”
		//Alterar “çA=“ para = “r”

		return senha.replace("#0P","u").replace("[%0","s").
				replace("lD7","e").replace("çA=","r");
	}
}
