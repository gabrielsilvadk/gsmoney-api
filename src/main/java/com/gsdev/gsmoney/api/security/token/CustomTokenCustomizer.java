package com.gsdev.gsmoney.api.security.token;

import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenClaimsContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomTokenCustomizer implements OAuth2TokenCustomizer<OAuth2TokenClaimsContext> {

    @Override
    public void customize(OAuth2TokenClaimsContext context) {
        if (AuthorizationGrantType.PASSWORD.equals(context.getAuthorizationGrantType())) {
            String username = context.getPrincipal().getName();
            context.getClaims().claim("username", username);
        }
    }
}
