package tunukOi.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tunukOi.dto.SimpleResponse;
import tunukOi.dto.user.UserRequest;
import tunukOi.service.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE)
@Tag(name = "User API", description = "Endpoints for managing user information, favorites, and orders")
public class UserApi {
    private final UserService userService;

    @PutMapping()
    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "Get nick name", description = "Get nick name to start game")
    SimpleResponse addNickNameAndImage(@RequestBody UserRequest userRequest){
        return userService.getNickNameAndImage(userRequest);
    }

    @PutMapping("/card")
    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "add card", description = "Add card to user")
    SimpleResponse addCardToUser(@RequestParam Long cardId){
        return userService.addCardToUser(cardId);
    }

}
