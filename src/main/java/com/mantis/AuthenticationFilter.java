package com.mantis;

import com.mantis.data.entity.Permission;
import com.mantis.data.entity.Role;
import com.mantis.data.entity.User;
import com.mantis.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.util.ArrayList;
import java.util.List;

@Component
    public class AuthenticationFilter extends OncePerRequestFilter {

        @Autowired
        private UserRepository userRepository;
        @Autowired
        private CustomUserDetailsService customUserDetailsService;


    @Override
    public void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) throws ServletException, java.io.IOException {
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String token = request.getHeader("Authorization");

        Integer id = null;
        if (token != null && token.startsWith("Bearer ")) {
            String tokenValue = token.substring(7);
            id = jwtTokenUtil.extractUserIdFromToken(tokenValue);
            User user = userRepository.findById(id).orElseThrow();
            List<GrantedAuthority> perms = new ArrayList<>();


            for(Role role: user.getRoles())
            {
                for(Permission permission: role.getPermissions())
                {
                    perms.add(new SimpleGrantedAuthority(permission.getName().toString()));
                }
            }

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getEmail());

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, perms);

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }
        chain.doFilter(request, response);
    }



}
