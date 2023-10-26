package tunukOi.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tunukOi.config.JwtService;
import tunukOi.dto.authentication.AuthenticationResponse;
import tunukOi.dto.authentication.SignInRequest;
import tunukOi.dto.authentication.SignUpRequest;
import tunukOi.entities.User;
import tunukOi.enums.Role;
import tunukOi.exceptions.AlreadyExistException;
import tunukOi.exceptions.BadCredentialException;
import tunukOi.exceptions.NotFoundException;
import tunukOi.repositories.UserRepository;
import tunukOi.service.AuthenticationService;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    @Value("${spring.admin_password}")
    private String PASSWORD;

    @Value("${spring.admin_email}")
    private String EMAIL;


    @Override
    public AuthenticationResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            log.error("User with email: %s already exist".formatted(signUpRequest.getEmail()));
            throw new AlreadyExistException(
                    "User with email: %s already exist".formatted(signUpRequest.getEmail()));
        }
        User user = User
                .builder()
                .nickName(signUpRequest.getNickName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(Role.USER)
                .build();
        log.info("User successfully saved");
        userRepository.save(user);
        log.info("Generation of a token for a new user");
        return AuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .role(user.getRole().name())
                .build();
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.getUserByEmail(signInRequest.getEmail())
                .orElseThrow(() -> {
                    log.error("User with email: %s not found".formatted(signInRequest.getEmail()));
                    return new NotFoundException(
                            "User with email: %s not found".formatted(signInRequest.getEmail()));
                });
        if (signInRequest.getPassword().isBlank()) {
            log.error("Password is blank!");
            throw new BadCredentialException("Email is blank!");
        }
        if (!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            log.error("Wrong password");
            throw new BadCredentialException("Wrong password!");
        }
        log.info("Generation of a token for a registered user");
        return AuthenticationResponse
                .builder()
                .token(jwtService.generateToken(user))
                .role(user.getRole().name())
                .build();
    }


    @PostConstruct
    public void addAdmin() {
        if (!userRepository.existsByEmail(EMAIL)) {
            User user = User
                    .builder()
                    .nickName("Admin")
                    .email(EMAIL)
                    .password(passwordEncoder.encode(PASSWORD))
                    .role(Role.ADMIN)
                    .build();
            userRepository.save(user);
            log.info("Admin saved");
        }
    }
}
