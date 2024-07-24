package dev.harshita.AuthService.controller;

import dev.harshita.AuthService.dto.requestDto.RegisterRequestDto;
import dev.harshita.AuthService.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDto registerRequestDto){
        return authService.register(registerRequestDto);
    }

//    @PostMapping("/login")
//    public ResponseEntity<UserResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
//        return authService.login(loginRequestDto);
//    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader("Auth-Token") String token, @RequestHeader("User-Id") UUID user_id){
        return authService.logout(token,user_id);
    }

//    @PostMapping("/validate")
//    public ResponseEntity<ValidateResponseDto> validate(@RequestHeader("Auth-Token") String token, @RequestHeader("User-Id") UUID user_id){
//        return authService.validate(token,user_id);
//    }

}
