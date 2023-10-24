package tunukOi.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tunukOi.dto.SimpleResponse;
import tunukOi.service.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Tag(name = "User API", description = "Endpoints for managing user information, favorites, and orders")
public class UserApi {
    private final UserService userService;

    @PutMapping
    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "Update user information", description = "Updates the user information based on the provided request.")
    public SimpleResponse updateUser(@RequestBody @Valid SimpleResponse userUpdateRequest) {
        return userService.userUpdate(userUpdateRequest);
    }
}
