package dev.harshita.AuthService.dto.responseDto;

import dev.harshita.AuthService.model.Role;
import dev.harshita.AuthService.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserResponseDto {
    private UUID userId;
    private String name;
    private String email;
    private List<Role> roles;

    public static UserResponseDto from(User user){
        UserResponseDto loginResponseDto = new UserResponseDto();
        loginResponseDto.setEmail(user.getEmail());
        loginResponseDto.setName(user.getName());
        loginResponseDto.setUserId(user.getId());
        loginResponseDto.setRoles(new ArrayList<>());
        for (Role role:user.getRoles()){
            loginResponseDto.getRoles().add(role);
        }

        return loginResponseDto;
    }
}
