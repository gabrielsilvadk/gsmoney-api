package com.gsdev.gsmoney.api.security.dto;

import lombok.Data;

@Data
public class TokenDTO {
    private String token;
    private String tipo;

    public TokenDTO(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
} 