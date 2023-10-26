package tunukOi.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tunukOi.dto.authentication.AuthenticationResponse;
import tunukOi.dto.authentication.SignInRequest;
import tunukOi.dto.authentication.SignUpRequest;
import tunukOi.service.AuthenticationService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "Authentication", description = "Authentication for users")
public class AuthenticationApi {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    @Operation(summary = "Sign up", description = "Register new users")
    public AuthenticationResponse signUp(@RequestBody @Valid SignUpRequest signUpRequest) {
        return authenticationService.signUp(signUpRequest);
    }

    @PostMapping("/sign-in")
    @Operation(summary = "Sign in", description = "Login for existing users")
    public AuthenticationResponse signIn(@RequestBody @Valid SignInRequest signInRequest) {
        return authenticationService.signIn(signInRequest);
    }
}
