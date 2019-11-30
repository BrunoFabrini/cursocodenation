package com.br.codenation.aplicacao.service.impl;

import com.br.codenation.aplicacao.controller.EmpresaController;
import com.br.codenation.aplicacao.domain.dao.UsuarioDAO;
import com.br.codenation.aplicacao.domain.entity.Empresa;
import com.br.codenation.aplicacao.domain.entity.Usuario;
import com.br.codenation.aplicacao.exception.CodenationException;
import com.br.codenation.aplicacao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl extends BaseService implements UsuarioService {

    private List<Usuario> usuariosList = new ArrayList<>();

    @Autowired
    private UsuarioDAO usuarioDAO;

    private void validateUsuario(Long id, Long empresaId, String nome, String documento, int idade, String login, String senha){

        if (id == null)
            throw new CodenationException("Falha ao inserir Usuário. A Idade precisa ser informada!");

        if (idade < 0)
            throw new CodenationException("Falha ao inserir Usuário. A Idade precisa ser informada!");

        if (nome == null || nome.isEmpty())
            throw new CodenationException("Falha ao inserir Usuário. O Nome precisa ser informado!");

        if (documento == null || documento.isEmpty())
            throw new CodenationException("Falha ao inserir Usuário. O Documento precisa ser informado!");

        if (login == null || login.isEmpty())
            throw new CodenationException("Falha ao inserir Usuário. O Login precisa ser informado!");

        if (senha == null || senha.isEmpty())
            throw new CodenationException("Falha ao inserir Usuário. A Senha precisa ser informad!");
    }

    @Override
    @Transactional
    public void addUsuario(Long id, Long empresaId, String nome, String documento, int idade, String login, String senha, BigDecimal salario) {

        validateUsuario(id, empresaId, nome, documento, idade, login, senha);

        EmpresaController empresaController = new EmpresaController();

        Empresa empresa = empresaController.getByEmpresaId(empresaId);
        if (empresa == null)
            throw new CodenationException("Nenhuma empresa contém o EmpresaId informado!");

        Usuario usuario = new Usuario().builder().id(id).empresa(empresa).nome(nome).documento(documento).idade(idade).username(login).senha(senha).salario(salario).build();

        usuarioDAO.save(usuario);
        System.out.println("Usuário '" + usuario.getNome() + "' incluído com sucesso!");
//        empresa.getUsuariosList().add(usuario);
        System.out.println("Usuário '" + usuario.getNome() + "' incluído na empresa '" + empresa.getNome() + "' com sucesso!");

//	 	LOG.info("Usuário '{}' incluído na empresa '{}' com sucesso!", usuario.getNome(), empresa.getNome());
    }

    public void deleteUsuario(Long usuarioId){

        usuarioDAO.deleteById(usuarioId);
    }

    public Usuario getUsuarioById(Long usuarioId){

        return usuarioDAO.findById(usuarioId).orElse(null);
    }

    public boolean anyUsuarioByNomeLoginDocumento(String nome, String login, String documento) {

        try {

            for(Usuario item:usuariosList) {
                if(item.getNome().equals(nome) && item.getUsername().equals(login) && item.getDocumento().equals(documento)) {
                    return true;
                }
            }
        }
        catch(Exception ex) {
            return false;
        }

        return false;
    }

    public void printUsuarios() {

        for (Usuario usuario:usuariosList){

            StringBuilder sb = new StringBuilder();

            sb.append("Id: '" + usuario.getId() + "'; ");
            sb.append("EmpresaId: '" + usuario.getEmpresa().getNome() + "'; ");
            sb.append("Nome: '" + usuario.getNome() + "'; ");
            sb.append("Documento: '" + usuario.getDocumento() + "'; ");
            sb.append("Idade: '" + usuario.getIdade() + "'; ");
            sb.append("Salario: '" + usuario.getSalario() + "'; ");
            sb.append("Login: '" + usuario.getUsername() + "'; ");
            sb.append("Senha: '" + usuario.getSenha());

            System.out.println(sb.toString());
        }
    }

    private void printUsuarios(List<Usuario> listaUsuarios) {

        for (Usuario usuario:listaUsuarios){

            StringBuilder sb = new StringBuilder();

            sb.append("Id: '" + usuario.getId() + "'; ");
            sb.append("EmpresaId: '" + usuario.getEmpresa().getNome() + "'; ");
            sb.append("Nome: '" + usuario.getNome() + "'; ");
            sb.append("Documento: '" + usuario.getDocumento() + "'; ");
            sb.append("Idade: '" + usuario.getIdade() + "'; ");
            sb.append("Salario: '" + usuario.getSalario() + "'; ");
            sb.append("Login: '" + usuario.getUsername() + "'; ");
            sb.append("Senha: '" + usuario.getSenha());

            System.out.println(sb.toString());
        }
    }

    public Long findUsuario(Long empresaId, String nome, String documento, int idade) {

        EmpresaController empresaController = new EmpresaController();

        List<Usuario> usuarios = usuariosList.stream().filter(usuario -> usuario.getEmpresa().getNome().equals(empresaId) &&
                usuario.getNome().equals(nome) &&
                usuario.getDocumento().equals(documento) &&
                usuario.getIdade() == (idade)).collect(Collectors.toList());
        for (Usuario usuario:usuarios)
            System.out.println("Usuário: '" + usuario.getNome() + "' - Empresa: '" + empresaController.getByEmpresaId(empresaId).getNome() + "'");

        return usuarios.get(0).getId();
    }
}
