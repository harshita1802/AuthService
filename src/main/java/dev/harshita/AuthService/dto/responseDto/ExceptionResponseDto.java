package dev.harshita.AuthService.dto.responseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDto {
    private String message;
    private int errorCode;

    public ExceptionResponseDto(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
