package com.gsdev.gsmoney.api.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senha = "senha";
        String hash = encoder.encode(senha);
        System.out.println("Senha original: " + senha);
        System.out.println("Hash gerado: " + hash);
        
        // Verificar se o hash é válido
        boolean matches = encoder.matches(senha, hash);
        System.out.println("O hash é válido? " + matches);
    }
}