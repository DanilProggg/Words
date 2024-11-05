package com.word.memorization.components;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class JwtTokenProvider {
    @Value("${token.signing.key}")
    String jwtSigningKey;


    /**
     *
     * @param token
     * Получение всех данных из токена
     *
     * @return claims
     */
    public Claims getClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     *
     * @param token
     * Получение имени пользователя
     *
     * @return имя пользователя
     */
    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    /**
     *
     * @param token
     * Получение списка ролей
     *
     * @return List<роли>
     */
    public List<String> getRoles(String token) {
        return getClaims(token).get("roles", List.class);
    }

    /**
     * Получение ключа для подписи токена
     *
     * @return ключ
     */
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSigningKey.getBytes(StandardCharsets.UTF_8));
    }
}

