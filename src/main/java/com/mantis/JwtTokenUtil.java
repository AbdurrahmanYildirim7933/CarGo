package com.mantis;

import com.mantis.common.enums.EPermission;
import com.mantis.data.entity.Permission;
import com.mantis.data.entity.Role;
import com.mantis.data.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.keygen.KeyGenerators;


import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class JwtTokenUtil {

//     @Value("${spring.jwt.secret}")
    private String secretKey = "TG9yZW1JcHN1bWpkaXpnaXZlYmFza8SxZW5kw7xzdHJpc2luZGVrdWxsYW7EsWxhbm3EsWfEsXJtZXRpbmxlcmRpcmxM";

    private long expiration=999999;
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
        claims.put("userId",user.getId());
        claims.put("name",user.getName());
        claims.put("lastName",user.getLastName());
        claims.put("email",user.getEmail());
        claims.put("phone",user.getPhone());
        List<Role> roles = user.getRoles();
        List<String> roleNames = new ArrayList<>();
        List<Permission> temp = new ArrayList<>();
        List<String> perms = new ArrayList<>();
        for (Role role : roles) {
            String roleName = role.getName();
            roleNames.add(roleName);
            temp = role.getPermissions();
            for(Permission permission: temp)
            {
                EPermission permissionName = permission.getName();
                perms.add(permissionName.toString());
            }
        }
        claims.put("roles",roleNames);
        claims.put("perms",perms);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + TimeUnit.HOURS.toMillis(4)))
                .signWith(SignatureAlgorithm.HS512,secretKey )
                .compact();
    }

    String extractUserIdFromToken(String token) {
        try {
            SecretKey secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
            Claims claims = Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody();
            return claims.get("userId", String.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to extract user ID from token",e);
        }
    }

}
