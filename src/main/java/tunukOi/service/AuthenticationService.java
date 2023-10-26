package tunukOi.service;


import tunukOi.dto.SimpleResponse;
import tunukOi.dto.authentication.AuthenticationResponse;
import tunukOi.dto.authentication.SignInRequest;
import tunukOi.dto.authentication.SignUpRequest;

public interface AuthenticationService {

    AuthenticationResponse signUp(SignUpRequest signUpRequest);

    AuthenticationResponse signIn(SignInRequest signInRequest);
}
