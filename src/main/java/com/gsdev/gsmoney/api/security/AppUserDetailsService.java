package com.gsdev.gsmoney.api.security;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gsdev.gsmoney.api.model.Usuario;
import com.gsdev.gsmoney.api.repository.UsuarioRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("Tentando carregar usuário: {}", email);
        
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos"));
        
        logger.info("Usuário encontrado: {}", usuario.getEmail());
        logger.info("Senha do usuário: {}", usuario.getSenha());
        
        Set<GrantedAuthority> authorities = new HashSet<>();
        usuario.getPermissoes().forEach(permissao -> {
            authorities.add(new SimpleGrantedAuthority(permissao.getDescricao()));
        });
        
        logger.info("Permissões do usuário: {}", authorities);
        
        return new User(usuario.getEmail(), usuario.getSenha(), authorities);
    }
}
