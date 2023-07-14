package com.mantis.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Common {
public static String hashPw(String pw){
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String hashedPassword = encoder.encode(pw);
    return hashedPassword;
}
}
