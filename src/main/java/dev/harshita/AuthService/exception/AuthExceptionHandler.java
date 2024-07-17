package dev.harshita.AuthService.exception;

import dev.harshita.AuthService.dto.responseDto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ExceptionResponseDto> handleUserExist(EmailAlreadyExistException e){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                e.getMessage(),
                409
        );

        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ExceptionResponseDto> handleInvalidToken(InvalidTokenException e){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                e.getMessage(),
                403
        );

        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(PasswordIncorrectException.class)
    public ResponseEntity<ExceptionResponseDto> handleIncorrectPassword(PasswordIncorrectException e){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                e.getMessage(),
                403
        );

        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleUserNotFound(UserNotFoundException e){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                e.getMessage(),
                404
        );

        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
    }

}
