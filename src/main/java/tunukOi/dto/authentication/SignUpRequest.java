package tunukOi.dto.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tunukOi.validations.password.Password;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank(message = "Name must not be empty")
    @NotNull(message = "Name must not be null")
    private String nickName;

    @Email(message = "Wrong format email")
    private String email;

    @Password(message = "Wrong format password")
    private String password;

}
