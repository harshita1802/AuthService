package dev.harshita.AuthService.service;

import dev.harshita.AuthService.dto.requestDto.RegisterRequestDto;
import dev.harshita.AuthService.exception.EmailAlreadyExistException;
import dev.harshita.AuthService.exception.InvalidTokenException;
import dev.harshita.AuthService.model.Session;
import dev.harshita.AuthService.model.User;
import dev.harshita.AuthService.model.constant.SessionStatus;
import dev.harshita.AuthService.repository.RoleRepository;
import dev.harshita.AuthService.repository.SessionRepository;
import dev.harshita.AuthService.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private RoleRepository roleRepository;

    public ResponseEntity<String> register(RegisterRequestDto registerRequestDto) throws EmailAlreadyExistException{
        Optional<User> savedUser = userRepository.findByEmail(registerRequestDto.getEmail());
        if(!savedUser.isEmpty()){
            throw new EmailAlreadyExistException("user with "+registerRequestDto.getEmail()+" exist, login?");
        }

        User user = registerRequestDto.toEntity();
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));
        user.setRoles(Arrays.asList(roleRepository.getReferenceById(registerRequestDto.getRoleId())));

        userRepository.save(user);

        return ResponseEntity.ok("Registered Successfully!");
    }

//    public ResponseEntity<UserResponseDto> login(LoginRequestDto loginRequestDto) throws UserNotFoundException, PasswordIncorrectException{
//        User user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow(
//                () -> new UserNotFoundException("email is not registered!, register?")
//        );
//
//        if(!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())){
//            throw new PasswordIncorrectException("password incorrect!");
//        }
//
//        UserResponseDto loginResponseDto = UserResponseDto.from(user);
//
////        SecretKey key = Jwts.SIG.HS256.key().build();
////
////        Map<String,String> claims = new HashMap<>();
////        claims.put("User_Id",user.getId().toString());
////
////        String jws = Jwts.builder()
////                .claims(claims)
////                .signWith(key)
////                .compact();
//
//        String token = UUID.randomUUID().toString();
//        Session session = new Session();
//        session.setToken(token);
//        session.setSessionStatus(SessionStatus.ACTIVE);
//        session.setLoginTime(new Date());
//        session.setUser(user);
//
//        Session savedSession = sessionRepository.save(session);
//
//        MultiValueMapAdapter<String,String> headers = new MultiValueMapAdapter<>(new HashMap<>());
//        headers.add("Auth-Token",token);
////        headers.add("Session_id",savedSession.getId().toString());
//
//        ResponseEntity<UserResponseDto> responseEntity = new ResponseEntity(
//                loginResponseDto,
//                headers,
//                HttpStatus.OK
//        );
//
//        return responseEntity;
//    }


    public ResponseEntity logout(String token, UUID user_id) throws InvalidTokenException{
        Session session = sessionRepository.findByTokenAndUser_Id(token,user_id).orElseThrow(
                () -> new InvalidTokenException("token is invalid!")
        );

        session.setSessionStatus(SessionStatus.LOGGED_OUT);
        sessionRepository.save(session);

        return ResponseEntity.ok("Logged Out!, Login?");
    }


//    public ResponseEntity<ValidateResponseDto> validate(String token, UUID user_id){
//        Optional<Session> optionalSession = sessionRepository.findByTokenAndUser_Id(token,user_id);
//
//        ValidateResponseDto validateResponseDto = new ValidateResponseDto();
//
//        if(optionalSession.isEmpty()){
//            validateResponseDto.setSessionStatus(SessionStatus.INVALID);
//            return ResponseEntity.ok(validateResponseDto);
//        }
//
//        Session session = optionalSession.get();
//
//        if(!session.getSessionStatus().equals(SessionStatus.ACTIVE)){
//            validateResponseDto.setSessionStatus(SessionStatus.INVALID);
//            return ResponseEntity.ok(validateResponseDto);
//        }
//
//        User user = userRepository.getReferenceById(user_id);
//
//        validateResponseDto.setSessionStatus(SessionStatus.ACTIVE);
//        validateResponseDto.setUserResponseDto(UserResponseDto.from(user));
//
//        return ResponseEntity.ok(validateResponseDto);
//    }

}
