package tunukOi.service;

import tunukOi.dto.SimpleResponse;
import tunukOi.dto.user.UserRequest;

public interface UserService {

    SimpleResponse getNickNameAndImage(UserRequest userRequest);
    SimpleResponse addCardToUser(Long cardId);
}
