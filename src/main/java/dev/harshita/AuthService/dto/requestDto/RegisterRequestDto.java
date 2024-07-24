package dev.harshita.AuthService.dto.requestDto;

import dev.harshita.AuthService.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RegisterRequestDto {
    private String name;
    private String email;
    private String password;
    private UUID roleId;

    public User toEntity() {
        User user = new User();
        user.setName(this.getName());
        user.setEmail(this.getEmail());
        return user;
    }
}
