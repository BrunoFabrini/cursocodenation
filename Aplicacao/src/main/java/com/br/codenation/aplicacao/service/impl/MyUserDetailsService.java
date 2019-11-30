package com.br.codenation.aplicacao.service.impl;

import com.br.codenation.aplicacao.domain.dao.UsuarioDAO;
import com.br.codenation.aplicacao.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Usuario usuario = usuarioDAO.findUsuarioByUsername(s);
        if (usuario == null)
            throw new UsernameNotFoundException("User not found!");

        return new UserRepositoryDetails(usuario);
    }

    private final static class UserRepositoryDetails extends Usuario implements UserDetails {

        private static final long serialVersionUID = 1L;

        private UserRepositoryDetails(Usuario usuario) {
            super(usuario);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return getRoles();
        }

        @Override
        public String getUsername(){
            return this.getNome();
        }

        @Override
        public String getPassword() {
            return super.getSenha();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
