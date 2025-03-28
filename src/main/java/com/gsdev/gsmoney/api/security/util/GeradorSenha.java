package com.gsdev.gsmoney.api.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "senha"; // Substitua pela senha desejada
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Senha criptografada: " + encodedPassword);
    }
}