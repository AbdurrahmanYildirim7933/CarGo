package com.mantis.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Common {
public static String hashPw(String pw){
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String hashedPassword = encoder.encode(pw);
    return hashedPassword;
}

    //permission token'a ekle
    //token kullanarak request atma
    //hasAuthority
    //filter chain
    //chain.dofilter
    //request filter
    //authentication detail service
    //@Preauthorize
}
