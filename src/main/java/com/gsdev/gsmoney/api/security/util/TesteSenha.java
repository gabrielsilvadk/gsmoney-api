package com.gsdev.gsmoney.api.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteSenha {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senha = "senha";
        String hashBanco = "$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBpwTTyU3VWmWm";
        
        System.out.println("Senha a testar: " + senha);
        System.out.println("Hash do banco: " + hashBanco);
        
        boolean matches = encoder.matches(senha, hashBanco);
        System.out.println("A senha corresponde? " + matches);
        
        // Gerar um novo hash para comparação
        String novoHash = encoder.encode(senha);
        System.out.println("\nNovo hash gerado: " + novoHash);
        System.out.println("O novo hash corresponde? " + encoder.matches(senha, novoHash));
    }
} 