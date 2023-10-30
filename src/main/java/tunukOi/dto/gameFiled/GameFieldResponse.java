package tunukOi.dto.gameFiled;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tunukOi.dto.user.UserResponse;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class GameFieldResponse {
    private Long id;
    private List<UserResponse> users;

}
