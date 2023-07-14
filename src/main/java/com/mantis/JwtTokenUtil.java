package com.mantis;

import com.mantis.data.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.keygen.KeyGenerators;


import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtTokenUtil {

//     @Value("${spring.jwt.secret}")
    private String secretKey = "TG9yZW1JcHN1bWpkaXpnaXZlYmFza8SxZW5kw7xzdHJpc2luZGVrdWxsYW7EsWxhbm3EsWfEsXJtZXRpbmxlcmRpcmxM";

    @Value("${jwt.expiration}")
    private long expiration;
            //=15 * 60;
    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

//    public static String generateNewToken() {
//        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//        String secretString = Encoders.BASE64.encode(key.getEncoded());
//        return secretString;
//    }

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512,secretKey )
                .compact();
    }
}