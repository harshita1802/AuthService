package dev.harshita.AuthService.dto.responseDto;

import dev.harshita.AuthService.model.constant.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateResponseDto {
    private SessionStatus sessionStatus;
    private UserResponseDto userResponseDto;
}
