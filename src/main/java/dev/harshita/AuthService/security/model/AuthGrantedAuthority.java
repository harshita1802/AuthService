package dev.harshita.AuthService.security.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.harshita.AuthService.model.Role;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@JsonDeserialize
@NoArgsConstructor
public class AuthGrantedAuthority implements GrantedAuthority {

    private String authority;

    public AuthGrantedAuthority(Role role){
        this.authority = role.getName();
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
