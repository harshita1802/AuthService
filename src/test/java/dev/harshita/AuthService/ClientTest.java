package dev.harshita.AuthService;

import dev.harshita.AuthService.repository.RoleRepository;
import dev.harshita.AuthService.repository.UserRepository;
import dev.harshita.AuthService.security.service.JpaRegisteredClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class ClientTest {

    @Autowired
    private JpaRegisteredClientRepository jpaRegisteredClientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

//    @Test
//    @Order(1)
//    @Commit
//    public void clientTest(){
//    RegisteredClient postmanClient = RegisteredClient.withId(UUID.randomUUID().toString())
//        .clientId("postman-client")
//        .clientSecret("secret")
//        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//        .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//        .redirectUri("https://oauth.pstmn.io/v1/callback")
//        .postLogoutRedirectUri("http://127.0.0.1:8080/")
//        .scope(OidcScopes.OPENID)
//        .scope(OidcScopes.PROFILE)
//        .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//        .build();
//
//        jpaRegisteredClientRepository.save(postmanClient);
//    }
//
//    @Test
//    @Order(2)
//    @Commit
//    public void roleTest(){
//        Role role = new Role();
//        role.setName("USER");
//
//        roleRepository.save(role);
//    }
//
//    @Test
//    @Order(3)
//    @Commit
//    public void userTest(){
//        User user = new User();
//        user.setEmail("chotu@gmail.com");
//        user.setPassword(bCryptPasswordEncoder.encode("password"));
//        user.setName("Chutki");
//        user.setRoles(new ArrayList<>(Arrays.asList(roleRepository.findByName("USER"))));
//
//        userRepository.save(user);
//    }

}
