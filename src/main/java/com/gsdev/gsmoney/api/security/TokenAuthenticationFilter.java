package com.gsdev.gsmoney.api.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

    @Autowired
    private AppUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        final String authHeader = request.getHeader("Authorization");
        logger.info("Auth Header: {}", authHeader);
        logger.info("Request URI: {}", request.getRequestURI());
        
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String token = authHeader.substring(7); // Remove "Bearer " prefix
            logger.info("Token: {}", token);
            
            if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                try {
                    String username = jwtTokenProvider.extractUsername(token);
                    logger.info("Username extraído do token: {}", username);
                    
                    if (username != null) {
                        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
                        logger.info("UserDetails carregado: {}", userDetails.getUsername());
                        logger.info("Permissões do usuário: {}", userDetails.getAuthorities());
                        
                        if (jwtTokenProvider.validateToken(token, userDetails)) {
                            logger.info("Token válido para o usuário: {}", username);
                            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authToken);
                            logger.info("Autenticação configurada no SecurityContext");
                            logger.info("Permissões no SecurityContext: {}", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
                        } else {
                            logger.error("Token inválido para o usuário: {}", username);
                        }
                    }
                } catch (Exception e) {
                    logger.error("Erro ao processar token: {}", e.getMessage());
                }
            }
        } else {
            logger.warn("Header de autorização não encontrado ou inválido");
        }
        
        filterChain.doFilter(request, response);
    }
} 