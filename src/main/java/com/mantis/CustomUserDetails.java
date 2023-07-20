package com.mantis;

import com.mantis.data.entity.Permission;
import com.mantis.data.entity.Role;
import com.mantis.data.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private final User user; // Your User entity class or the class that represents user details.

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();
        List<Permission> permissions = roles.stream()
                .flatMap(role -> role.getPermissions().stream())
                .collect(Collectors.toList());

        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName().toString()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        // Implement how you want to retrieve the user's password from the User entity.
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // Implement how you want to retrieve the username or email from the User entity.
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement any logic for account expiration if needed.
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement any logic for account locking if needed.
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement any logic for credentials expiration if needed.
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Implement any logic to check if the user is enabled or active if needed.
        return true;
    }



}
