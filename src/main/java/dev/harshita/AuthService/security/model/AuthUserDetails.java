package dev.harshita.AuthService.security.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.harshita.AuthService.model.Role;
import dev.harshita.AuthService.model.User;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@JsonDeserialize
@NoArgsConstructor
public class AuthUserDetails implements UserDetails{
    private List<GrantedAuthority> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private UUID userId;

    public AuthUserDetails(User user){
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.userId = user.getId();
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.accountNonExpired = true;
        this.authorities = new ArrayList<>();

        for(Role role : user.getRoles()){
            authorities.add(new AuthGrantedAuthority(role));
        }
    }

    public UUID getUserId(){
        return this.userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
