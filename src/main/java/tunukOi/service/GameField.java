package tunukOi.service;

import tunukOi.dto.SimpleResponse;
import tunukOi.dto.gameFiled.GameFieldResponse;
import tunukOi.dto.user.UserResponse;

import java.util.List;

public interface GameField {
    SimpleResponse createGameField();
    GameFieldResponse getGameFieldById(Long gameFieldId);
    List<UserResponse> getAllGameFieldsUsers(Long gameFieldId);

}
